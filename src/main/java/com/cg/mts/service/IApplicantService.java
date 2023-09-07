package com.cg.mts.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.mts.entities.Applicant;
import com.cg.mts.entities.UserEntity;

public interface IApplicantService {
	
	public Applicant addApplicant(Applicant applicant);

	public Applicant update(Applicant applicant);

	public void delete(int applicantId);

	public Applicant viewApplicant(int applicantid);

	public List<Applicant> viewAllApplicantByStatus(String admissionStatus);

	public List<Applicant> showAllAdmissionByCourseId(Integer courseId);

	public List<Applicant> showAllAdmissionByDate(LocalDate localDate);

	public List<Applicant> viewAllApplicant();

	public Applicant addApplicantUser(UserEntity userEntity);

}
