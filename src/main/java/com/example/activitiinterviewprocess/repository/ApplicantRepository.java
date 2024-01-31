package com.example.activitiinterviewprocess.repository;

import com.example.activitiinterviewprocess.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
}

