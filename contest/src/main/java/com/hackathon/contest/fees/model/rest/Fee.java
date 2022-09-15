package com.hackathon.contest.fees.model.rest;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
@Builder
@Getter
@Setter
public class Fee {
  private Long id;

  private com.hackathon.contest.fees.model.Fee.Type type;

  private Double totalAmount;

  private Double remainingAmount;

  private Long student_id;

  private Instant creationDatetime;

  private com.hackathon.contest.fees.model.Fee.Status status;
}
