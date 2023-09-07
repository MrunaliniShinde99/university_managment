package com.cg.mts.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.mts.entities.Admission;
import com.cg.mts.entities.Course;
import com.cg.mts.repository.IAdmissionRepository;
import com.cg.mts.service.IAdmissionService;

@Service
@Transactional
public class IAdmissionServiceImpl implements IAdmissionService {

	@Autowired
	IAdmissionRepository iAdmissionRepository;

	@Override
	public Admission addAdmission(Admission admission) {
		Admission admissionNew = iAdmissionRepository.save(admission);
		return admissionNew;
	}

	@Override
	public Admission updateAdmission(Admission admission) {
		Admission updateAdmission = iAdmissionRepository.save(admission);
		return updateAdmission;
	}

	@Override
	public Admission cancelAdmission(int id) {
		iAdmissionRepository.deleteById(id);
		return null;
	}

	@Override
	public List<Admission> showAllAdmissionByCourseId(int id) {
		// iAdmissionRepository.showAllAdmissionByCourseId(id);
		return null;
	}

	@Override
	public List<Admission> showAllAdmissionByDate(LocalDate localDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admission viewAdmission(int id) {

		Admission admission = null;
		try {
			admission = iAdmissionRepository.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return admission;
	}

}
