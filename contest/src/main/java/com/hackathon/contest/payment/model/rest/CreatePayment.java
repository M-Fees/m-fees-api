package com.hackathon.contest.payment.model.rest;

import com.hackathon.contest.payment.model.Payment;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class CreatePayment {
  private Double amount;

  private Payment.Type type;
}
