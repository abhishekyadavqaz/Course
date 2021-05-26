package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.entity.Course;
import com.example.demo.vo.CourseVo;

@Mapper(componentModel = "spring")
public interface CourseMapper {

	CourseVo toVo(Course course);

	Course toEntity(CourseVo courseVo);

	List<CourseVo> toVoList(List<Course> entityList);

	List<Course> toEntityList(List<CourseVo> voList);
}
