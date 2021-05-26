package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.InstructorDao;
import com.example.demo.vo.InstructorVo;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	private InstructorDao instructorDao;

	@Autowired
	private InstructorService instructorService;

	@Autowired
	private CourseService courseService;

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public InstructorVo insertInstructor(final InstructorVo instructorVo) {
//
//		final List<CourseVo> coursesVo = instructorVo.getCourses();
//		instructorVo.setCourses(null);
//
//
//		final var newInstructorVo = instructorDao.insertInstructor(instructorVo);
//
//		final int id = newInstructorVo.getId();
//
//		for (final CourseVo courses : coursesVo) {
//
//			courseService.insertCourse(courses, id);
//		}
		return instructorDao.insertInstructor(instructorVo);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public List<InstructorVo> getAllInstructor() {

		return instructorDao.getAllInstructor();
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public InstructorVo updateInstructor(final InstructorVo instructorVo) {

		instructorService.deleteInstructor(1);

		instructorDao.insertInstructor(instructorVo);// @Transactional(isolation = Isolation.DEFAULT, propagation =
														// Propagation.REQUIRED)

		instructorDao.getAllInstructor();// @Transactional(isolation = Isolation.DEFAULT, propagation =
											// Propagation.REQUIRES_NEW)
		return null;
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public String deleteInstructor(final int instructorId) {

		final InstructorVo instructorVo = instructorDao.getInstructorbyId(instructorId);

		final int courseId = instructorVo.getId();

		courseService.deleteCourseById(courseId);

		return instructorDao.deleteInstructor(instructorId);
	}
}