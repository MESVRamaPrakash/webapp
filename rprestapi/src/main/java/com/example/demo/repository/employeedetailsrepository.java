package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.employeedetailsmodel;

public interface employeedetailsrepository extends CrudRepository<employeedetailsmodel, Integer>{
	
}
