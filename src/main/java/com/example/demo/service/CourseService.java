package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.CourseVo;

public interface CourseService {

	CourseVo insertCourse(CourseVo courseVo, int id);

	List<CourseVo> getAllCourse();

	CourseVo updateInstructor(CourseVo courseVo);

	String deleteCourse(int courseId);

	String deleteCourseById(int instructorId);

}
