package com.cg.mts.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.Applicant;
@Repository
public interface IApplicantRepository  extends JpaRepository<Applicant, Integer>{

	
	@Query(value = "SELECT * FROM applicant ap "
			+ "join admission ad on ap.admission_id = ad.id WHERE  ad.admission_status=:admissionStatus ", nativeQuery = true)
	public List<Applicant> viewAllApplicantByStatus(@Param("admissionStatus") String admissionStatus);

	
	@Query(value = "SELECT * FROM applicant ap "
			+ "join admission ad on ap.admission_id = ad.id WHERE  ad.course_id=:courseId ", nativeQuery = true)
	public List<Applicant> showAllAdmissionByCourseId(Integer courseId);

	@Query(value = "SELECT * FROM applicant ap "
			+ "join admission ad on ap.admission_id = ad.id WHERE  ad.admission_date=:localDate ", nativeQuery = true)
	public List<Applicant> showAllAdmissionByDate(LocalDate localDate);

}
