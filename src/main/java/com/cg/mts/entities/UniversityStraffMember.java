package com.cg.mts.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "university_straff_member")
public class UniversityStraffMember {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "staff_id")
	int staffId;

	@NotEmpty(message = "Email is required")
	@Email(message = "Email should be valid")
	private String email;

	@NotNull
	@Size(min = 4, message = "password  must have at least 4 characters")
	@Column(name = "password", nullable = false)
	String password;
	
	@NotEmpty(message = "Email is required")
	@Column(name = "role", nullable = false)
	String role;

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UniversityStraffMember [staffId=" + staffId + ", email=" + email + ", password=" + password + ", role="
				+ role + "]";
	}

}
