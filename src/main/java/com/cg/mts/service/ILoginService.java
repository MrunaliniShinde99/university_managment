package com.cg.mts.service;

public interface ILoginService {
	
	public boolean loginAsApplicant(String emailId, String pass);

	public boolean loginAsAdmissionCommiteeMember(String emailId, String pass);

	public boolean loginAsUniversityStaffMember(String emailId, String pass);

}
