package com.hackathon.contest.students.repository;

import com.hackathon.contest.students.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentsRepository extends JpaRepository<Students, Long> {
}
