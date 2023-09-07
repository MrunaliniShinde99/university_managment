package com.cg.mts.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.mts.entities.Admission;
import com.cg.mts.entities.AdmissionCommiteeMember;
import com.cg.mts.entities.RoleEnum;
import com.cg.mts.entities.UniversityStraffMember;
import com.cg.mts.entities.UserEntity;
import com.cg.mts.exception.StaffNotFoundException;
import com.cg.mts.exception.UserAlreadyExistException;
import com.cg.mts.repository.IAdmissionCommiteeMemberRepository;
import com.cg.mts.repository.ICourseRepository;
import com.cg.mts.repository.ILoginRepository;
import com.cg.mts.service.IAdmissionCommiteeMemberService;

@Service
@Transactional
public class IAdmissionCommiteeMemberServiceImpl implements IAdmissionCommiteeMemberService {

	@Autowired
	IAdmissionCommiteeMemberRepository iAdmissionCommiteeMemberRepository;
	@Autowired
	ILoginRepository iLoginRepository;

	@Override
	public AdmissionCommiteeMember addCommiteeMember(AdmissionCommiteeMember admissionCommiteeMember) {
		AdmissionCommiteeMember AdmissionCommiteeMember1 = iAdmissionCommiteeMemberRepository
				.findByEmail(admissionCommiteeMember.getEmail());

		if (AdmissionCommiteeMember1 != null) {
			throw new UserAlreadyExistException("User Already Exist ");
		}

		AdmissionCommiteeMember saveAdmissionCommiteeMember = iAdmissionCommiteeMemberRepository
				.save(admissionCommiteeMember);
		UserEntity userEntity = new UserEntity();
		userEntity.setEmail(admissionCommiteeMember.getEmail());
		userEntity.setPassword(admissionCommiteeMember.getPassword());
		userEntity.setRole(RoleEnum.STAFF.name());
		iLoginRepository.save(userEntity);
		return saveAdmissionCommiteeMember;
	}

	@Override
	public AdmissionCommiteeMember updateCommiteeMember(AdmissionCommiteeMember admissionCommiteeMember) {
		AdmissionCommiteeMember AdmissionCommiteeMember1 = iAdmissionCommiteeMemberRepository
				.findByEmail(admissionCommiteeMember.getEmail());

		if (AdmissionCommiteeMember1 == null) {
			throw new StaffNotFoundException("STAFF NOT FOUND");
		}

		AdmissionCommiteeMember admissionCommiteeMember1 = iAdmissionCommiteeMemberRepository
				.save(admissionCommiteeMember);
		UserEntity user = iLoginRepository.findByEmail(admissionCommiteeMember.getEmail());
		user.setEmail(admissionCommiteeMember.getEmail());
		user.setPassword(admissionCommiteeMember.getPassword());
		user.setRole(RoleEnum.STAFF.name());
		iLoginRepository.save(user);
		return admissionCommiteeMember1;
	}

	@Override
	public AdmissionCommiteeMember viewCommiteeMember(int id) {
		AdmissionCommiteeMember admissionCommiteeMember1 = null;
		try {
			admissionCommiteeMember1 = iAdmissionCommiteeMemberRepository.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return admissionCommiteeMember1;
	}

	@Override
	public void removeCommiteeMember(int id) {
		iAdmissionCommiteeMemberRepository.deleteById(id);
	}

	@Override
	public List<AdmissionCommiteeMember> viewAllCommiteeMember() {
		List<AdmissionCommiteeMember> findAll = iAdmissionCommiteeMemberRepository.findAll();
		return findAll;
	}

	@Override
	public Admission provideAdmissionResult(Admission admission) {
		// TODO Auto-generated method stub
		return null;
	}

}
