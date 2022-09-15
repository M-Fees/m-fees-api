package com.hackathon.contest.group.model.rest;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateGroup {
  private String name;
}
