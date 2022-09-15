package com.hackathon.contest.manager.model.rest;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateManager {
  private String firstName;
  private String lastName;
  private String role;
  private String email;
  private String password;
}
