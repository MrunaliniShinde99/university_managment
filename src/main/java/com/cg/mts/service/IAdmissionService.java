package com.cg.mts.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.mts.entities.Admission;

public interface IAdmissionService {

	public Admission addAdmission(Admission admission);

	public Admission updateAdmission(Admission admission);

	public Admission cancelAdmission(int id);

	public List<Admission> showAllAdmissionByCourseId(int id);

	public List<Admission> showAllAdmissionByDate(LocalDate localDate);
	
	public Admission viewAdmission(int id);

}
