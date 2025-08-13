package com.shiva.employee.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shiva.employee.department.model.Department;

public interface departmentRepository extends JpaRepository<Department, Integer>{

	@Transactional
	@Modifying
	@Query("update Department set members=members+:arg1 where did=:arg2" )
	void updateMebers(@Param("arg2") int did, @Param ("arg1") int i);


}
