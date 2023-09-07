package com.cg.mts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.Admission;
import com.cg.mts.entities.AdmissionCommiteeMember;
import com.cg.mts.entities.UniversityStraffMember;
@Repository
public interface IAdmissionCommiteeMemberRepository extends JpaRepository<AdmissionCommiteeMember, Integer>{

	AdmissionCommiteeMember findByEmail(String email);

//	public AdmissionCommiteeMember addCommiteeMember(AdmissionCommiteeMember admissionCommiteeMember);
//
//	public AdmissionCommiteeMember updateCommiteeMember(AdmissionCommiteeMember admissionCommiteeMember);
//
//	public AdmissionCommiteeMember viewCommiteeMember(int id);
//
//	public void removeCommiteeMember(int id);
//
//	public List<AdmissionCommiteeMember> viewAllCommiteeMember();

	//public Admission provideAdmissionResult(Admission admission);
}
