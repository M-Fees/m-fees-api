package com.hackathon.contest.students.model.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Students {
  private Long id;
  private String ref;
  private String firstName;
  private String lastName;
  private String sex;
  private String address;
  private String grade;
  private String groupe;
  private String email;
  private String phone;
}
