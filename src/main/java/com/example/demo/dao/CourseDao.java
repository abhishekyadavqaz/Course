package com.example.demo.dao;

import java.util.List;

import com.example.demo.vo.CourseVo;

public interface CourseDao {

	CourseVo insertCourse(CourseVo courseVo, int id);

	CourseVo getInstructorbyId(int id);

	List<CourseVo> getAllCourse();

	CourseVo updateInstructor(CourseVo courseVo);

	String deleteCourse(int courseId);

	String deleteCourseById(int courseId);
}
