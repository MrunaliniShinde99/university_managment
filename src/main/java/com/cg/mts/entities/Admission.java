package com.cg.mts.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "admission")
public class Admission {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	int admissionId;

	@Column(name = "admission_Date", nullable = false)
	LocalDate admissionDate;

	@NotEmpty(message = "admissionStatus is required")
	@Column(name = "admission_status", nullable = false)
	private String admissionStatus;

	@OneToOne
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@JoinColumn(name = "course_id", referencedColumnName = "id")
	private Course course;

	public int getAdmissionId() {
		return admissionId;
	}

	public void setAdmissionId(int admissionId) {
		this.admissionId = admissionId;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getAdmissionStatus() {
		return admissionStatus;
	}

	public void setAdmissionStatus(String admissionStatus) {
		this.admissionStatus = admissionStatus;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Admission [admissionId=" + admissionId + ", admissionDate=" + admissionDate + ", admissionStatus="
				+ admissionStatus + ", course=" + course + "]";
	}

}
