package com.cg.mts.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.dto.ApplicantDto;
import com.cg.mts.entities.Admission;
import com.cg.mts.entities.AdmissionStatusEnum;
import com.cg.mts.entities.Applicant;
import com.cg.mts.entities.Course;
import com.cg.mts.exception.ApplicanNotFoundException;
import com.cg.mts.exception.CourseNotFoundException;
import com.cg.mts.exception.CustomException;
import com.cg.mts.service.IAdmissionService;
import com.cg.mts.service.IApplicantService;
import com.cg.mts.service.ICourseService;
import com.cg.mts.util.Response;

@RestController
@RequestMapping("applicant")
public class ApplicantController {

	@Autowired
	IApplicantService iApplicantService;

	@Autowired
	ICourseService iCourseService;

	@Autowired
	IAdmissionService iAdmissionService;
	
	private final static Logger logger = LogManager.getLogger(ApplicantController.class);

	@PostMapping("/add")
	public ResponseEntity<Response> addApplicant(@RequestBody @Valid  ApplicantDto applicantDto) {
		logger.info("Starrted addAdmission method");

		logger.info("Request Object=>" + applicantDto);
		Response response = new Response();
		Applicant applicant = new Applicant();
		Admission admission = new Admission();
		BeanUtils.copyProperties(applicantDto, applicant);
		BeanUtils.copyProperties(applicantDto, admission);

		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		admission.setAdmissionDate(localDate);
		admission.setAdmissionStatus(AdmissionStatusEnum.APPLIED.name());

		Course viewCourse = iCourseService.viewCourse(applicantDto.getCourse_Id());
		if (viewCourse != null) {
			admission.setCourse(viewCourse);
			iAdmissionService.addAdmission(admission);
			applicant.setAdmission(admission);
			Applicant addApplicant = iApplicantService.addApplicant(applicant);

			response.setResponse(addApplicant);
			response.setStatus(Response.SUCCESS);
			response.setStatusCode(HttpStatus.OK);
			logger.info("End addApplicant method");
			logger.info("Response Object=>" + response);
			return new ResponseEntity<Response>(response, response.getStatusCode());
		} else {
			throw new CourseNotFoundException("COURSE NOT FOUND");

		}
	}

	@GetMapping(value = "/view/{id}")
	public ResponseEntity<Response> viewApplicant(@PathVariable("id") Integer id) {
		logger.info("Starrted viewApplicant method");

		logger.info("Request Object=>" + id);
		Response response = new Response();
		Applicant applicant = iApplicantService.viewApplicant(id);
		if (applicant != null) {
			response.setResponse(applicant);
			response.setStatus(Response.SUCCESS);
			response.setStatusCode(HttpStatus.OK);
			logger.info("End viewApplicant method");
			logger.info("Response Object=>" + response);
			return new ResponseEntity<Response>(response, response.getStatusCode());
		} else {
			throw new ApplicanNotFoundException("APPLICANT NOT FOUND");
			
		}
	}

	@GetMapping(value = "/view/by/status/{admissionStatus}")
	public ResponseEntity<Response> viewAllApplicantByStatus(@PathVariable("admissionStatus") String admissionStatus) {

		logger.info("Starrted viewAllApplicantByStatus method");

		logger.info("Request Object=>" + admissionStatus);
		Response response = new Response();
		List<Applicant> Applicantlist = iApplicantService.viewAllApplicantByStatus(admissionStatus);
		response.setResponse(Applicantlist);
		response.setStatus(Response.SUCCESS);
		response.setStatusCode(HttpStatus.OK);
		return new ResponseEntity<Response>(response, response.getStatusCode());
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response> deleteApplicant(@PathVariable("id") Integer id) {
		logger.info("Starrted viewAllApplicantByStatus method");

		logger.info("Request Object=>" + id);

		Response response = new Response();

		Applicant applicant = iApplicantService.viewApplicant(id);
		if (applicant != null) {
			iApplicantService.delete(id);
			response.setResponse("Deleted");
			response.setStatus(Response.SUCCESS);
			response.setStatusCode(HttpStatus.OK);
			logger.info("End viewAllAdmissionCommiteeMembers method");
			logger.info("Response Object=>" + response);
			return new ResponseEntity<Response>(response, response.getStatusCode());
		} else {

			throw new ApplicanNotFoundException("APPLICANT NOT FOUND");
		}

	}

	@PostMapping(value = "/update")
	public ResponseEntity<Response> updateApplicant(@RequestBody @Valid  ApplicantDto applicantDto) {
		logger.info("Starrted updateApplicant method");

		logger.info("Request Object=>" + applicantDto);
		Response response = new Response();

		Applicant applicant = iApplicantService.viewApplicant(applicantDto.getApplicantId());
		if (applicant == null) {
			throw new ApplicanNotFoundException("APPLICANT NOT FOUND");

		}

		BeanUtils.copyProperties(applicantDto, applicant);

		Admission admission = applicant.getAdmission();
		BeanUtils.copyProperties(applicantDto, admission);

		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		admission.setAdmissionDate(localDate);
		admission.setAdmissionStatus(AdmissionStatusEnum.APPLIED.name());
		Course viewCourse = iCourseService.viewCourse(applicantDto.getCourse_Id());
		admission.setCourse(viewCourse);
		iAdmissionService.addAdmission(admission);
		applicant.setAdmission(admission);
		Applicant ApplicantUpdate = iApplicantService.update(applicant);
		response.setResponse(ApplicantUpdate);
		response.setStatus(Response.SUCCESS);
		response.setStatusCode(HttpStatus.OK);
		logger.info("End updateApplicant method");
		logger.info("Response Object=>" + response);
		return new ResponseEntity<Response>(response, response.getStatusCode());
	}

	@GetMapping(value = "/get/All")
	public ResponseEntity<Response> viewAllApplicant() {
		logger.info("Starrted viewAllApplicant method");

		Response response = new Response();
		List<Applicant> applicants = iApplicantService.viewAllApplicant();
		if (applicants.size() == 0) {
			throw new ApplicanNotFoundException("APPLICANT NOT FOUND");
		}

		response.setResponse(applicants);
		response.setStatus(Response.SUCCESS);
		response.setStatusCode(HttpStatus.OK);
		logger.info("End viewAllApplicant method");
		logger.info("Response Object=>" + response);
		return new ResponseEntity<Response>(response, response.getStatusCode());
	}

}
