package com.dm.springbootjpapostgresql.example.controllers;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dm.springbootjpapostgresql.example.beans.Student;
import com.dm.springbootjpapostgresql.example.beans.StudentRegistration;

@Controller
public class StudentRetrieveController {
	  @RequestMapping(method = RequestMethod.GET, value="/student/allstudent")

	  @ResponseBody
	  public List<Student> getAllStudents() {
		  System.out.println("In allstudent");
		  
	  return StudentRegistration.getInstance().getStudentRecords();
	  }
}
