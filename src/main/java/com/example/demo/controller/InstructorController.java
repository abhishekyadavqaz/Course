package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.InstructorService;
import com.example.demo.vo.InstructorVo;

@RestController
@RequestMapping("/Instructor")
public class InstructorController {

	@Autowired
	private InstructorService instructorService;

	@PostMapping("/")
	public String creatInstructor(@RequestBody final InstructorVo instructorVo) {

		System.out.println("PostMapping Controller --  " + instructorVo);
		final InstructorVo ShowInstructorVo = instructorService.insertInstructor(instructorVo);

		return ShowInstructorVo.toString();
	}

	@PutMapping("/")
	public String updateInstructor(@RequestBody final InstructorVo instructorVo) {

		return "PutMapping";
	}

	@DeleteMapping("/{id}")
	public String deleteInstructor(@PathVariable final int id) {

		return instructorService.deleteInstructor(id);
	}

	@GetMapping("/")
	public List<InstructorVo> displayInstructor() {

		System.out.println("displayInstructor Controller --  ");
		return instructorService.getAllInstructor();
	}

}
