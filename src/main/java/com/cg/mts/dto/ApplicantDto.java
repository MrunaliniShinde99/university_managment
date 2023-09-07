package com.cg.mts.dto;


public class ApplicantDto {

	private int applicantId;

	private String applicantName;

	private String applicantMobileNumber;

	private String applicantDegree;

	private int applicantGraduationPercent;

	private String admissionStatus;
	private String email;

	
	private int course_Id;

	public int getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getApplicantMobileNumber() {
		return applicantMobileNumber;
	}

	public void setApplicantMobileNumber(String applicantMobileNumber) {
		this.applicantMobileNumber = applicantMobileNumber;
	}

	public String getApplicantDegree() {
		return applicantDegree;
	}

	public void setApplicantDegree(String applicantDegree) {
		this.applicantDegree = applicantDegree;
	}

	public int getApplicantGraduationPercent() {
		return applicantGraduationPercent;
	}

	public void setApplicantGraduationPercent(int applicantGraduationPercent) {
		this.applicantGraduationPercent = applicantGraduationPercent;
	}

	public String getAdmissionStatus() {
		return admissionStatus;
	}

	public void setAdmissionStatus(String admissionStatus) {
		this.admissionStatus = admissionStatus;
	}

	public int getCourse_Id() {
		return course_Id;
	}

	public void setCourse_Id(int course_Id) {
		this.course_Id = course_Id;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ApplicantDto [applicantId=" + applicantId + ", applicantName=" + applicantName
				+ ", applicantMobileNumber=" + applicantMobileNumber + ", applicantDegree=" + applicantDegree
				+ ", applicantGraduationPercent=" + applicantGraduationPercent + ", admissionStatus=" + admissionStatus
				+ ", email=" + email + ", course_Id=" + course_Id + "]";
	}

}
