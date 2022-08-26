package com.lti.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.entity.Applicant;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {

}
