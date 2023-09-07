package com.cg.mts.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.mts.entities.Admission;
import com.cg.mts.entities.Applicant;
import com.cg.mts.entities.Course;
import com.cg.mts.entities.RoleEnum;
import com.cg.mts.entities.UserEntity;
import com.cg.mts.repository.IAdmissionRepository;
import com.cg.mts.repository.IApplicantRepository;
import com.cg.mts.repository.ICourseRepository;
import com.cg.mts.repository.ILoginRepository;
import com.cg.mts.service.IApplicantService;

@Service
@Transactional
public class IApplicantServiceImpl implements IApplicantService {
	@Autowired
	private IApplicantRepository iApplicantRepository;

	@Autowired
	ILoginRepository iLoginRepository;
	
	@Autowired
	IAdmissionRepository iAdmissionRepository;
	
	@Autowired
	ICourseRepository iCourseRepository;

	@Override
	public Applicant addApplicant(Applicant applicant) {
		Applicant applicantNew = iApplicantRepository.save(applicant);
		return applicantNew;
	}

	@Override
	public Applicant update(Applicant applicant) {
		Applicant applicantNew = iApplicantRepository.save(applicant);
		return applicantNew;
	}

	@Override
	public void delete(int applicantId) {
		iApplicantRepository.deleteById(applicantId);

	}

	@Override
	public Applicant viewApplicant(int applicantid) {

		Applicant Applicant = null;
		try {
			Applicant = iApplicantRepository.findById(applicantid).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return Applicant;
	}

	@Override
	public List<Applicant> viewAllApplicantByStatus(String admissionStatus) {
		List<Applicant> viewAllApplicantlist = iApplicantRepository.viewAllApplicantByStatus(admissionStatus);
		return viewAllApplicantlist;
	}

	@Override
	public List<Applicant> showAllAdmissionByCourseId(Integer courseId) {
		List<Applicant> viewAllApplicantlist = iApplicantRepository.showAllAdmissionByCourseId(courseId);
		return viewAllApplicantlist;
	}

	@Override
	public List<Applicant> showAllAdmissionByDate(LocalDate localDate) {
		List<Applicant> viewAllApplicantlist = iApplicantRepository.showAllAdmissionByDate(localDate);
		return viewAllApplicantlist;
	}

	@Override
	public List<Applicant> viewAllApplicant() {
		List<Applicant> viewAllApplicantlist = iApplicantRepository.findAll();
		return viewAllApplicantlist;
	}

	@Override
	public Applicant addApplicantUser(UserEntity userEntity) {
		Applicant ap = new Applicant();
//		ap.setEmail(userEntity.getEmail());
//		Course c = new Course();
//		Course c2 = iCourseRepository.save(c);
//		
//		Admission addmission = new Admission();
//		addmission.setCourse(c2);
//		Admission ad = iAdmissionRepository.save(addmission);
//		
//		ap.setAdmission(ad);
//		iApplicantRepository.save(ap);
		iLoginRepository.save(userEntity);
		return ap;

	}

}
