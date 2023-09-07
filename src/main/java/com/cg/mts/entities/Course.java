package com.cg.mts.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int courseId;
	
	@NotEmpty(message = "couresName should not be blank")
	@Column(name = "coures_name", nullable = false)
	private String couresName;

	@NotEmpty(message = "couresDuration should not be blank")
	@Column(name = "coures_duration", nullable = false)
	private String couresDuration;
	
	
	@Column(name = "coures_start_date", nullable = false)
	private LocalDate couresStartDate;

	@Column(name = "coures_end_date", nullable = false)
	private LocalDate couresEndDate;

	@NotEmpty(message = "couresFees should not be blank")
	@Column(name = "coures_fees", nullable = false)
	private String couresFees;



	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCouresName() {
		return couresName;
	}

	public void setCouresName(String couresName) {
		this.couresName = couresName;
	}

	public String getCouresDuration() {
		return couresDuration;
	}

	public void setCouresDuration(String couresDuration) {
		this.couresDuration = couresDuration;
	}

	public LocalDate getCouresStartDate() {
		return couresStartDate;
	}

	public void setCouresStartDate(LocalDate couresStartDate) {
		this.couresStartDate = couresStartDate;
	}

	public LocalDate getCouresEndDate() {
		return couresEndDate;
	}

	public void setCouresEndDate(LocalDate couresEndDate) {
		this.couresEndDate = couresEndDate;
	}

	public String getCouresFees() {
		return couresFees;
	}

	public void setCouresFees(String couresFees) {
		this.couresFees = couresFees;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", couresName=" + couresName + ", couresDuration=" + couresDuration
				+ ", couresStartDate=" + couresStartDate + ", couresEndDate=" + couresEndDate + ", couresFees="
				+ couresFees + "]";
	}



}
