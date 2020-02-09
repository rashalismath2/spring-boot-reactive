package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.Employee;
import com.example.demo.Repository.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository empRepo;
	
	
	@GetMapping(value="/", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Employee> getAll(){
		return empRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Mono<Employee> getEmployee(@PathVariable final String id){
		return empRepo.findById(id);
	}
	
	@GetMapping("/{id}/events")
	public Mono<Employee> getEvent(@PathVariable final String id){
		return empRepo.findById(id);
	}
	
	
}
