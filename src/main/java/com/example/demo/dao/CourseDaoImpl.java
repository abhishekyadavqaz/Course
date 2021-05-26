package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.mapper.InstructorMapper;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.InstructorRepository;
import com.example.demo.vo.CourseVo;
import com.example.demo.vo.InstructorVo;

@Component
public class CourseDaoImpl implements CourseDao {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private CourseMapper courseMapper;

	@Autowired
	private InstructorDao instructorDao;

	@Autowired
	private InstructorMapper instructorMapper;

	@Autowired
	private InstructorRepository instructorRepository;

	@Override
	public CourseVo insertCourse(final CourseVo courseVo, final int id) {

		final Course course = courseMapper.toEntity(courseVo);

		System.out.println("CourseMapper " + course);

		final InstructorVo instructorVo = instructorDao.getInstructorbyId(id);

		System.out.println("instructor" + instructorVo);
		final Instructor instructor = instructorMapper.toEntity(instructorVo);

		System.out.println("instructor" + instructor);

		instructor.add(course);

		System.out.println("SaveCourse" + instructor);

		courseRepository.save(course);

		return courseVo;

	}

	@Override
	public CourseVo getInstructorbyId(final int id) {
		final Course course = courseRepository.findById(id).orElse(null);

		return courseMapper.toVo(course);
	}

	@Override
	public List<CourseVo> getAllCourse() {

		final List<Course> course = courseRepository.findAll();

		return courseMapper.toVoList(course);
	}

	@Override
	public CourseVo updateInstructor(final CourseVo courseVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCourse(final int courseId) {

		System.out.println("delete");
		courseRepository.deleteById(Integer.valueOf(courseId));
		System.out.println("deleteted");
		return "Employee id : " + courseId + " Removed";
	}

	@Override
	public String deleteCourseById(final int courseId) {

		courseRepository.deleteCourseById(Integer.valueOf(courseId));

		return "Employee id : " + courseId + " Removed";
	}

}
