package com.cg.mts.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Applicant;
import com.cg.mts.entities.RoleEnum;
import com.cg.mts.entities.UniversityStraffMember;
import com.cg.mts.entities.UserEntity;
import com.cg.mts.exception.StaffNotFoundException;
import com.cg.mts.exception.UserAlreadyExistException;
import com.cg.mts.repository.ILoginRepository;
import com.cg.mts.service.IAdmissionService;
import com.cg.mts.service.IApplicantService;
import com.cg.mts.service.ICourseService;
import com.cg.mts.service.ILoginService;
import com.cg.mts.service.IUniversityStaffService;
import com.cg.mts.util.Response;

@RestController
@RequestMapping("user")
//@Validated
public class UserController {

	@Autowired
	IUniversityStaffService iUniversityStaffService;

	@Autowired
	IApplicantService iApplicantService;

	@Autowired
	ICourseService iCourseService;

	@Autowired
	IAdmissionService iAdmissionService;

	@Autowired
	ILoginService iLoginService;

	@Autowired
	ILoginRepository iLoginRepository;

	private final static Logger logger = LogManager.getLogger(UserController.class);

	@PostMapping("/register")
	public ResponseEntity<Response> register(@RequestBody @Valid UserEntity userEntity) throws ParseException {
		Response response = new Response();
		logger.info("Starrted register method");

		logger.info("Request Object email=>" + userEntity.getEmail());
		logger.info("Request Object role=>" + userEntity.getRole());

		if (userEntity.getRole().equalsIgnoreCase(RoleEnum.STAFF.name())) {
			UniversityStraffMember universityStraffMember = new UniversityStraffMember();
			universityStraffMember.setEmail(userEntity.getEmail());
			universityStraffMember.setPassword(userEntity.getPassword());
			universityStraffMember.setRole(RoleEnum.STAFF.name().toString());
			UniversityStraffMember viewUniversityStraffMember = iUniversityStaffService
					.addStaff(universityStraffMember);
			response.setResponse("SUCCESSFULLY REGISTERED");
			response.setStatus(Response.SUCCESS);
			response.setStatusCode(HttpStatus.OK);
			return new ResponseEntity<Response>(response, response.getStatusCode());

		} else if (userEntity.getRole().equalsIgnoreCase(RoleEnum.APPLICANT.name())) {

			Applicant addApplicantUser = iApplicantService.addApplicantUser(userEntity);
			response.setResponse("SUCCESSFULLY REGISTERED");
			response.setStatus(Response.SUCCESS);
			response.setStatusCode(HttpStatus.OK);
			return new ResponseEntity<Response>(response, response.getStatusCode());
		} else if (userEntity.getRole().equalsIgnoreCase(RoleEnum.ACM.name())) {

			iLoginRepository.save(userEntity);

			response.setStatus(Response.SUCCESS);
			response.setStatusCode(HttpStatus.OK);
			return new ResponseEntity<Response>(response, response.getStatusCode());
		} else {
			response.setResponse("ROLE SHOULD BE   ACM, APPLICANT, STAFF");
			response.setStatus(Response.FAILURE);
			response.setStatusCode(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response>(response, response.getStatusCode());
		}
	}

	@PostMapping("/login")
	public ResponseEntity<Response> login(@RequestBody UserEntity userEntity) throws ParseException {
		logger.info("Starrted login method");

		logger.info("Request Object email=>" + userEntity.getEmail());
		logger.info("Request Object role=>" + userEntity.getRole());
		Response response = new Response();

		if (userEntity.getRole().equalsIgnoreCase(RoleEnum.STAFF.name())) {

			boolean loginAsUniversityStaffMember = iLoginService.loginAsUniversityStaffMember(userEntity.getEmail(),
					userEntity.getPassword());

			if (loginAsUniversityStaffMember == false) {
				response.setResponse("LOGIN FAIL");
				response.setStatus(Response.FAILURE);
				response.setStatusCode(HttpStatus.NOT_FOUND);
				return new ResponseEntity<Response>(response, response.getStatusCode());
			}

		} else if (userEntity.getRole().equalsIgnoreCase(RoleEnum.APPLICANT.name())) {

			boolean loginAsApplicant = iLoginService.loginAsApplicant(userEntity.getEmail(), userEntity.getPassword());

			if (loginAsApplicant == false) {
				response.setResponse("LOGIN FAIL");
				response.setStatus(Response.FAILURE);
				response.setStatusCode(HttpStatus.NOT_FOUND);
				return new ResponseEntity<Response>(response, response.getStatusCode());
			}
		} else if (userEntity.getRole().equalsIgnoreCase(RoleEnum.ACM.name())) {

			boolean loginAsAdmissionCommiteeMember = iLoginService.loginAsAdmissionCommiteeMember(userEntity.getEmail(),
					userEntity.getPassword());

			if (loginAsAdmissionCommiteeMember == false) {
				response.setResponse("LOGIN FAIL");
				response.setStatus(Response.FAILURE);
				response.setStatusCode(HttpStatus.NOT_FOUND);
				return new ResponseEntity<Response>(response, response.getStatusCode());
			}

		} else {
			response.setResponse("ROLE SHOULD BE   ACM, APPLICANT, STAFF");
			response.setStatus(Response.FAILURE);
			response.setStatusCode(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response>(response, response.getStatusCode());
		}

		response.setStatus(Response.SUCCESS);
		response.setStatusCode(HttpStatus.OK);
		return new ResponseEntity<Response>(response, response.getStatusCode());
	}

	@PostMapping(value = "/update")
	public ResponseEntity<Response> updateApplicant(@RequestBody @Valid UserEntity userEntity) throws ParseException {
		Response response = new Response();
		logger.info("Starrted login method");

		logger.info("Request Object email=>" + userEntity.getEmail());
		logger.info("Request Object role=>" + userEntity.getRole());

		if (userEntity.getRole().equalsIgnoreCase(RoleEnum.STAFF.name())) {
			UniversityStraffMember universityStraffMember = new UniversityStraffMember();
			universityStraffMember.setEmail(userEntity.getEmail());
			universityStraffMember.setPassword(userEntity.getPassword());
			universityStraffMember.setRole(RoleEnum.STAFF.name().toString());
			UniversityStraffMember viewUniversityStraffMember = iUniversityStaffService
					.addStaff(universityStraffMember);
			response.setResponse("SUCCESSFULLY REGISTERED");

		} else if (userEntity.getRole().equalsIgnoreCase(RoleEnum.APPLICANT.name())) {

			Applicant addApplicantUser = iApplicantService.addApplicantUser(userEntity);
			response.setResponse("SUCCESSFULLY REGISTERED");
		} else if (userEntity.getRole().equalsIgnoreCase(RoleEnum.ACM.name())) {

		}

		response.setStatus(Response.SUCCESS);
		response.setStatusCode(HttpStatus.OK);
		logger.info("End viewAllCourses method");
		logger.info("Response Object=>" + response);
		return new ResponseEntity<Response>(response, response.getStatusCode());
	}

}