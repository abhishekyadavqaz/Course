package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "instructor_detail")
public class InstructorDetails {

	public InstructorDetails(final String youtubeChannel, final String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter
	@Getter
	@Column(name = "id")
	private int id;

	@Setter
	@Getter
	@Column(name = "youtube_channel")
	private String youtubeChannel;

	@Setter
	@Getter
	@Column(name = "hobby")
	private String hobby;

	@OneToOne(mappedBy = "instructorDetails", fetch = FetchType.LAZY)
	private Instructor instructor;

}
