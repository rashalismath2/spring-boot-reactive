package com.example.demo;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.Model.Employee;
import com.example.demo.Repository.EmployeeRepository;

@SpringBootApplication
public class DemoApplication {

	  @Autowired
	  private EmployeeRepository repo;
	  
	  ArrayList<Employee> a=new ArrayList<>();

	public static void main(String[] args) {
			
		SpringApplication.run(DemoApplication.class, args);

	}
	
	@Bean
	CommandLineRunner employee() {
		
		for(int i=0;i<100;i++) {
			a.add(new Employee(i+"","name"+i,i+100));
		}
	
		
		return args->{
			repo.deleteAll()
			.subscribe(null,null,()->{
				repo.saveAll(a).subscribe(res->{System.out.println(res);});
			});
		};
		
	}

}
