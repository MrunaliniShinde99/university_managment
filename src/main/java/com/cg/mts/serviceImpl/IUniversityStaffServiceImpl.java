package com.cg.mts.serviceImpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.mts.controller.UserController;
import com.cg.mts.entities.Course;
import com.cg.mts.entities.RoleEnum;
import com.cg.mts.entities.UniversityStraffMember;
import com.cg.mts.entities.UserEntity;
import com.cg.mts.exception.ApplicanNotFoundException;
import com.cg.mts.exception.StaffNotFoundException;
import com.cg.mts.exception.UserAlreadyExistException;
import com.cg.mts.repository.ICourseRepository;
import com.cg.mts.repository.ILoginRepository;
import com.cg.mts.repository.IUniversityStaffRepository;

import com.cg.mts.service.IUniversityStaffService;

@Service
@Transactional
public class IUniversityStaffServiceImpl implements IUniversityStaffService {

	@Autowired
	ICourseRepository iCourseRepository;

	@Autowired
	IUniversityStaffRepository iUniversityStaffRepository;

	@Autowired
	ILoginRepository iLoginRepository;
	private final static Logger logger = LogManager.getLogger(IUniversityStaffServiceImpl.class);

	@Override
	public UniversityStraffMember addStaff(UniversityStraffMember universityStraffMember) {
		logger.info("addStaff" +universityStraffMember);
		UniversityStraffMember universityStraffMember1 = iUniversityStaffRepository.findByEmail(universityStraffMember.getEmail());

		if (universityStraffMember1 != null) {
			throw new UserAlreadyExistException("User Already Exist ");
		}

		UniversityStraffMember saveUniversityStraffMember = iUniversityStaffRepository.save(universityStraffMember);
		UserEntity userEntity = new UserEntity();
		userEntity.setEmail(universityStraffMember.getEmail());
		userEntity.setPassword(universityStraffMember.getPassword());
		userEntity.setRole(RoleEnum.STAFF.name());
		iLoginRepository.save(userEntity);
		return saveUniversityStraffMember;
	}

	@Override
	public UniversityStraffMember updateStaff(UniversityStraffMember universityStraffMember) {
		universityStraffMember = iUniversityStaffRepository.findByEmail(universityStraffMember.getEmail());

		if (universityStraffMember == null) {
			throw new StaffNotFoundException("STAFF NOT FOUND");
		}

		UniversityStraffMember universityStraffMember1 = iUniversityStaffRepository.save(universityStraffMember);
		UserEntity user = iLoginRepository.findByEmail(universityStraffMember.getEmail());
		user.setEmail(universityStraffMember.getEmail());
		user.setPassword(universityStraffMember.getPassword());
		user.setRole(RoleEnum.STAFF.name());
		iLoginRepository.save(user);
		return universityStraffMember1;
	}

	@Override
	public void removeStaff(int id) {
		iUniversityStaffRepository.deleteById(id);
	}

	@Override
	public UniversityStraffMember viewStaff(int id) {
		UniversityStraffMember universityStraffMember = null;
		try {
			universityStraffMember = iUniversityStaffRepository.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return universityStraffMember;
	}

	@Override
	public List<UniversityStraffMember> viweAllStaff() {
		List<UniversityStraffMember> findAll = iUniversityStaffRepository.findAll();
		return findAll;
	}

	@Override
	public Course addCourse(Course course) {
		Course course1 = iCourseRepository.save(course);
		return course1;
	}

	@Override
	public Course removeCourse(int courseId) {
		iCourseRepository.deleteById(courseId);
		return null;
	}

	@Override
	public Course updateCourse(Course course) {
		Course course1 = iCourseRepository.save(course);
		return course1;
	}

}
