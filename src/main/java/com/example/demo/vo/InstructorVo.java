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
public class InstructorVo {

	private int id;

	public InstructorVo(final String firstName, final String lastName, final String email,
			final InstructorDetailsVo instructorDetails, final List<CourseVo> courses) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.instructorDetails = instructorDetails;
		this.courses = courses;
	}

	private String firstName;

	private String lastName;

	private String email;

	private InstructorDetailsVo instructorDetails;

	private List<CourseVo> courses;

}
