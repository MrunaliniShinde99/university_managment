package com.cg.mts.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "applicant")
public class Applicant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@NotEmpty(message = "applicantName is required")
	@Column(name = "applicant_name", nullable = false)
	String applicantName;
	
	@NotEmpty(message = "Email is required")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",message="Email should be valid")
	@Email(message = "Email should be valid")
	@Column(name = "email", nullable = false)
	private String email;
	
	@Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message = "Mobile number is invalid")
	@Column(name = "applicant_mobile_number", nullable = false)
	private String applicantMobileNumber;

	@Column(name = "applicant_degree", nullable = false)
	private String applicantDegree;

	@Column(name = "applicant_graduation_percent", nullable = false)
	private int applicantGraduationPercent;

	@OneToOne
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@JoinColumn(name = "admission_id", referencedColumnName = "id")
	private Admission admission;

	public int getId() {
		return id;
	}

	public void setApplicantId(int id) {
		this.id = id;
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

	public Admission getAdmission() {
		return admission;
	}

	public void setAdmission(Admission admission) {
		this.admission = admission;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Applicant [id=" + id + ", applicantName=" + applicantName + ", email=" + email
				+ ", applicantMobileNumber=" + applicantMobileNumber + ", applicantDegree=" + applicantDegree
				+ ", applicantGraduationPercent=" + applicantGraduationPercent + ", admission=" + admission + "]";
	}

}
