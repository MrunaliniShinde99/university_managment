package com.cg.mts.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.mts.entities.Course;
import com.cg.mts.repository.ICourseRepository;
import com.cg.mts.service.ICourseService;

@Service
@Transactional
public class ICourseServiceImpl implements ICourseService {

	@Autowired
	ICourseRepository iCourseRepository;

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

	@Override
	public Course viewCourse(int courseId) {
		Course course1 = null;
		try {
			course1 = iCourseRepository.findById(courseId).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return course1;
	}

	@Override
	public List<Course> viewAllCourses() {
	List<Course> couserList = iCourseRepository.findAll();
		return couserList;
	}

}
