package com.shiva.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shiva.model.Employee;

public interface Repository  extends JpaRepository<Employee, Integer>{

}
