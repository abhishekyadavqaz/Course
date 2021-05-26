package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.entity.Instructor;
import com.example.demo.vo.InstructorVo;

@Mapper(componentModel = "spring", uses = { CourseMapper.class, InstructorDetailsMapper.class })
public interface InstructorMapper {

	InstructorVo toVo(Instructor instructor);

	Instructor toEntity(InstructorVo instructorVo);

	List<InstructorVo> toVoList(List<Instructor> entityList);

	List<Instructor> toEntityList(List<InstructorVo> voList);
}
