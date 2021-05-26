package com.example.demo.mapper;

import org.mapstruct.Mapper;

import com.example.demo.entity.InstructorDetails;
import com.example.demo.vo.InstructorDetailsVo;

@Mapper(componentModel = "spring") //
public interface InstructorDetailsMapper {

	InstructorDetailsVo toVo(InstructorDetails instructorDetails);

	InstructorDetails toEntity(InstructorDetailsVo instructorDetailsVo);
}
