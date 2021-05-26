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

import com.example.demo.service.CourseService;
import com.example.demo.vo.CourseVo;

@RestController
@RequestMapping("/Course")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@PostMapping("/{id}")
	public String creatCourse(@RequestBody final CourseVo courseVo, @PathVariable final int id) {

		System.out.println("PostMapping Controller --  " + courseVo);
		final CourseVo ShowCourseVo = courseService.insertCourse(courseVo, id);

		return ShowCourseVo.toString();
	}

	@PutMapping("/")
	public String updateCourse(@RequestBody final CourseVo courseVo) {

		return "PutMapping";
	}

	@DeleteMapping("/{id}")
	public String deleteCourse(@PathVariable final int id) {

		return courseService.deleteCourse(id);
	}

	@GetMapping("/")
	public List<CourseVo> displayCourse() {

		return courseService.getAllCourse();
	}
}
