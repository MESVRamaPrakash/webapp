package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.employeedetailsmodel;
import com.example.demo.model.employeedetailsmodel;
import com.example.demo.repository.employeedetailsrepository;

@SuppressWarnings("unused")
@Service
public class employeedetailsservice {
	
	@Autowired
	employeedetailsrepository repo;
	
	public employeedetailsmodel addemployee(employeedetailsmodel emp) {
		
		return repo.save(emp);
	}
	public List<employeedetailsmodel> getall() {
		return (List<employeedetailsmodel>) repo.findAll();
	}
	public  Optional<employeedetailsmodel> findbyid(int id) {
		return repo.findById(id);
		
	}
	public String deleteemployeedetailsmodel(int id) {
	repo.deleteById(id);
	return "successfully deleted" + id;
	}
	public employeedetailsmodel updateemployee(employeedetailsmodel emp) {
		int id = emp.getId();
		employeedetailsmodel m = repo.findById(id).get();
		m.setName(emp.getName());
		m.setEmail(emp.getEmail());
		m.setPassword(emp.getPassword());
		return repo.save(m);
	}

}
