package com.hackathon.contest.grade.model.mapper;

import com.hackathon.contest.grade.model.Grade;
import com.hackathon.contest.grade.model.rest.CreateGrade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GradeMapper {
  public Grade toDomain(CreateGrade toCreate){
    return Grade.builder()
            .grade(toCreate.getGrade())
            .fee(toCreate.getFee())
            .build();
  }
}
