package com.hackathon.contest.students.model.rest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStudents {
  private String ref;
  private String firstName;
  private String lastName;
  private String sex;
  private String address;
  private Long grade_id;
  private Long group_id;
  private String email;
  private String phone;
}
