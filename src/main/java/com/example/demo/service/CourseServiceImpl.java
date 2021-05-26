package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.CourseDao;
import com.example.demo.vo.CourseVo;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW)
	public CourseVo insertCourse(final CourseVo courseVo, final int id) {

		return courseDao.insertCourse(courseVo, id);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public List<CourseVo> getAllCourse() {

		return courseDao.getAllCourse();
	}

	@Override
	public CourseVo updateInstructor(final CourseVo courseVo) {

		return null;
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW)

	public String deleteCourse(final int courseId) {

		return courseDao.deleteCourse(courseId);
	}

	@Override
	public String deleteCourseById(final int courseId) {

		return courseDao.deleteCourseById(courseId);
	}

}
