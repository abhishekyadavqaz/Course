package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.InstructorDetails;

public interface InstructorDetailsRepository extends JpaRepository<InstructorDetails, Integer> {

}