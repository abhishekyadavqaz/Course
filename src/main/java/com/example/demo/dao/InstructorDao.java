package com.example.demo.dao;

import java.util.List;

import com.example.demo.vo.InstructorVo;

public interface InstructorDao {

	InstructorVo insertInstructor(InstructorVo instructorVo);

	InstructorVo getInstructorbyId(int id);

	List<InstructorVo> getAllInstructor();

	InstructorVo updateInstructor(InstructorVo instructorVo);

	String deleteInstructor(int instructorId);
}
