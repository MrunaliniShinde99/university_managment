package com.cg.mts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.UniversityStraffMember;
@Repository
public interface IUniversityStaffRepository extends JpaRepository<UniversityStraffMember, Integer>{

	UniversityStraffMember findByEmail(String email);

//	public UniversityStraffMember addStaff(UniversityStraffMember universityStraffMember);
//
//	public UniversityStraffMember updateStaff(UniversityStraffMember universityStraffMember);
//
//	public UniversityStraffMember viewStaff(int id);
//
//	public void removeStaff(UniversityStraffMember universityStraffMember);
//
//	public List<UniversityStraffMember> viweAllStaff(UniversityStraffMember universityStraffMember);
//

}
