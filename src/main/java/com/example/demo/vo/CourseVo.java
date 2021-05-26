package com.example.demo.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class CourseVo {

	public CourseVo(final String title) {
		this.title = title;
	}

	private int id;

	private String title;

	private List<StudentVo> students;

}
