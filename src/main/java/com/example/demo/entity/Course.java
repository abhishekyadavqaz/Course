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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Setter
@Getter
@Table(name = "course")
public class Course {

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}

	public Course(final String title) {
		this.title = title;
	}

	@Setter
	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Setter
	@Getter
	@Column(name = "title")
	private String title;

	@Setter
	@ManyToOne()
	@JoinColumn(name = "instructor_id", referencedColumnName = "id")
	private Instructor instructor;

	@Setter
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinTable(name = "course_student", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
	private List<Student> students;

	public void addStudent(final Student student) {
		if (student == null) {
			students = new ArrayList<>();
		}
		students.add(student);
	}

	// cascade = CascadeType.ALL, fetch = FetchType.LAZY

}
