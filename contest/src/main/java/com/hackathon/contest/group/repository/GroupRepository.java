package com.hackathon.contest.group.repository;

import com.hackathon.contest.group.model.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Groups, Long> {
}
