package com.example.demo.vo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class StudentVo {

	private int id;

	private String firstName;

	private String lastName;

	private String email;

	private List<CourseVo> courses;

}
