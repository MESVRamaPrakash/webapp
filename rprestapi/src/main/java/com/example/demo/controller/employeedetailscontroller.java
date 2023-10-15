package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.employeedetailsmodel;
import com.example.demo.service.employeedetailsservice;

@RestController
public class employeedetailscontroller {
	@Autowired
	employeedetailsservice service;
	
	@PostMapping("/insert")
	public employeedetailsmodel addemployee(@RequestBody employeedetailsmodel emp) {
		return service.addemployee(emp);
	}
	@GetMapping("/getall")
	public List<employeedetailsmodel> getall() {
		return service.getall();
	}
	@GetMapping("/findbyid/{id}")
	public Optional<employeedetailsmodel> findbyid(@PathVariable int id) {
		return service.findbyid(id);
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public String deletebyid(@PathVariable int id) {
		return service.deleteemployeedetailsmodel(id);
	}
	@PutMapping("/update")
	public employeedetailsmodel updatemployee(@RequestBody employeedetailsmodel m) {
		return service.updateemployee(m);
	}

}
