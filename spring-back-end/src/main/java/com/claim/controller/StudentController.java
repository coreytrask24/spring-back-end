package com.claim.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.claim.entity.Student;
import com.claim.repository.StudentRepository;

@CrossOrigin
@RestController

public class StudentController {
		
		@Autowired
		private StudentRepository studentRepository; // = R123
		
		@RequestMapping(value= "/submitStudentDetails", 
				consumes=MediaType.APPLICATION_JSON_VALUE,
				method = RequestMethod.POST)
		public void submitStudentDetails(@RequestBody Student student) {
			this.studentRepository.save(student);
		}
		
		@RequestMapping(value="/findByEmail", 
				produces=MediaType.APPLICATION_JSON_VALUE,
				method = RequestMethod.GET)
		public ResponseEntity<Optional<Student>>findByEmail(String email){
			Optional<Student> student = this.studentRepository.findById(email);
			return new ResponseEntity<Optional<Student>>(student, HttpStatus.OK);
		}
}
