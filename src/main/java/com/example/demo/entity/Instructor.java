package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "instructor")
public class Instructor {

	public Instructor(final String firstName, final String lastName, final String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	// cascade = CascadeType.ALL
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instructor_detail_id", referencedColumnName = "id")
	private InstructorDetails instructorDetails;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Course> courses;

//	public void setInstructor(final List<Course> cours) {
//
//		for (final Course cour : cours) {
//			cour.setInstructor(this);
//		}
//
//	}

	public void add(final Course course) {

		if (courses == null) {
			courses = new ArrayList<>();
		}

		courses.add(course);

		if (course != null) {
			course.setInstructor(this);
		}
	}

}
