package com.hackathon.contest.penalty.model.rest;

import com.hackathon.contest.penalty.model.Penalty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePenalty {
  private Double interest;
  private Penalty.Rate interestTimerate;
}
