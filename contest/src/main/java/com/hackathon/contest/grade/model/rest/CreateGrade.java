package com.hackathon.contest.grade.model.rest;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateGrade {
  private Double fee;
  private String grade;
}
