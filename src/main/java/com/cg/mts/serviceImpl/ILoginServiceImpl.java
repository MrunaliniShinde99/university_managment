package com.cg.mts.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.mts.repository.ILoginRepository;
import com.cg.mts.service.ILoginService;

@Service
@Transactional
public class ILoginServiceImpl implements ILoginService {

	@Autowired
	ILoginRepository iLoginRepository;

	@Override
	public boolean loginAsApplicant(String emailId, String pass) {
		boolean verifyApplicant = iLoginRepository.verifyApplicant(emailId, pass);
		return verifyApplicant;
	}

	@Override
	public boolean loginAsAdmissionCommiteeMember(String emailId, String pass) {
		boolean verifyAdmissionCommiteeMember = iLoginRepository.verifyAdmissionCommiteeMember(emailId, pass);
		return verifyAdmissionCommiteeMember;
	}

	@Override
	public boolean loginAsUniversityStaffMember(String emailId, String pass) {
		boolean verifyUniversityStaffMember = iLoginRepository.verifyUniversityStaffMember(emailId, pass);
		return verifyUniversityStaffMember;
	}

}
