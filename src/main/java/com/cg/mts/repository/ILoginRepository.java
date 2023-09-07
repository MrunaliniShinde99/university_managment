package com.cg.mts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.UserEntity;

@Repository
public interface ILoginRepository extends JpaRepository<UserEntity, Integer> {
	
	UserEntity findByEmail(String email);

	@Query(value = "SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM user_details u  WHERE  u.email = :email and  u.password = :password", nativeQuery = true)
	public boolean verifyAdmissionCommiteeMember(String email, String password);

	@Query(value ="SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM user_details u  WHERE  u.email = :email and  u.password = :password",  nativeQuery = true)
	public boolean verifyApplicant(String email, String password);

	@Query(value = "SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM user_details u  WHERE  u.email = :email and  u.password = :password", nativeQuery = true)
	public boolean verifyUniversityStaffMember(@Param("email") String email, @Param("password") String password);
}
