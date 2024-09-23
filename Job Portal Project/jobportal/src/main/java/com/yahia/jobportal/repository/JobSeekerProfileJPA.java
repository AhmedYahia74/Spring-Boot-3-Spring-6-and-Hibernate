package com.yahia.jobportal.repository;

import com.yahia.jobportal.entity.JobSeekerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerProfileJPA extends JpaRepository<JobSeekerProfile,Integer> {
}
