package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	@Query(value = "DELETE FROM course WHERE instructor_id= :id;", nativeQuery = true)
	List<Course> deleteCourseById(Integer id);
}
