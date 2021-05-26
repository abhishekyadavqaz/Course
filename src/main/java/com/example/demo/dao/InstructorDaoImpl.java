package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Instructor;
import com.example.demo.mapper.InstructorMapper;
import com.example.demo.repository.InstructorRepository;
import com.example.demo.vo.InstructorVo;

@Component
public class InstructorDaoImpl implements InstructorDao {

	@Autowired
	private InstructorRepository instructorRepository;

	@Autowired
	private InstructorMapper instructorMapper;

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW)
	public InstructorVo insertInstructor(final InstructorVo instructorVo) {

		final var instructor = instructorMapper.toEntity(instructorVo);

		final var savedInstructor = instructorRepository.save(instructor);

		return instructorMapper.toVo(savedInstructor);

	}

	@Override
	public InstructorVo getInstructorbyId(final int id) {

		final Instructor instructor = instructorRepository.findById(id).orElse(null);

		return instructorMapper.toVo(instructor);
	}

	@Override
	public List<InstructorVo> getAllInstructor() {

		final List<Instructor> instructor = instructorRepository.findAll();

		return instructorMapper.toVoList(instructor);

	}

	@Override
	public InstructorVo updateInstructor(final InstructorVo instructorVo) {

		return null;
	}

	@Override
	public String deleteInstructor(final int instructorId) {

		instructorRepository.deleteById(Integer.valueOf(instructorId));

		return "Employee id : " + instructorId + " Removed";
	}

}
