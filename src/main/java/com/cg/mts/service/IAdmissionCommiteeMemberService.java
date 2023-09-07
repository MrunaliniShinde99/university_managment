package com.cg.mts.service;

import java.util.List;

import com.cg.mts.entities.Admission;
import com.cg.mts.entities.AdmissionCommiteeMember;

public interface IAdmissionCommiteeMemberService {

	public AdmissionCommiteeMember addCommiteeMember(AdmissionCommiteeMember admissionCommiteeMember);

	public AdmissionCommiteeMember updateCommiteeMember(AdmissionCommiteeMember admissionCommiteeMember);

	public AdmissionCommiteeMember viewCommiteeMember(int id);

	public void removeCommiteeMember(int id);

	public List<AdmissionCommiteeMember> viewAllCommiteeMember();

	public Admission provideAdmissionResult(Admission admission);
}
