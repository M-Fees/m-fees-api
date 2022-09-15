package com.hackathon.contest.fees.model.rest;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Builder
@Getter
@Setter
public class CreateFee {
  private com.hackathon.contest.fees.model.Fee.Type type;

  private Double totalAmount;

  @Getter
  @Setter
  public static class Payment {
    private Long id;
  }
}
