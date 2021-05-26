package com.example.demo.vo;

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
public class InstructorDetailsVo {

	public InstructorDetailsVo(final String youtubeChannel, final String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	private int id;

	private String youtubeChannel;

	private String hobby;
}
