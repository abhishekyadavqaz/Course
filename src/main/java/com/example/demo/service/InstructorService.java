package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.InstructorVo;

public interface InstructorService {

	InstructorVo insertInstructor(InstructorVo instructorVo);

	List<InstructorVo> getAllInstructor();

	InstructorVo updateInstructor(InstructorVo instructorVo);

	String deleteInstructor(int instructorId);

}
