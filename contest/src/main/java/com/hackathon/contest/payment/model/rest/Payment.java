package com.hackathon.contest.payment.model.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Payment {
  private Long id;
  private com.hackathon.contest.payment.model.Payment.Type type;
  private Double amount;
  private Instant creationDatetime;
  private String fee_type;
}
