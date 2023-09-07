package com.cg.mts.service;

import java.util.List;

import com.cg.mts.entities.Course;
import com.cg.mts.entities.UniversityStraffMember;

public interface IUniversityStaffService {

	public UniversityStraffMember addStaff(UniversityStraffMember universityStraffMember);

	public UniversityStraffMember updateStaff(UniversityStraffMember universityStraffMember);

	public void removeStaff(int id);

	public UniversityStraffMember viewStaff(int id);

	public Course addCourse(Course course);

	public Course removeCourse(int courseId);

	public Course updateCourse(Course course);

	public List<UniversityStraffMember> viweAllStaff();

}
