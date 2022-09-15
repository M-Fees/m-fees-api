package com.hackathon.contest.payment.model.mapper;

import com.hackathon.contest.fees.model.Fee;
import com.hackathon.contest.fees.service.FeeService;
import com.hackathon.contest.payment.model.Payment;
import com.hackathon.contest.payment.model.rest.CreatePayment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@AllArgsConstructor
public class PaymentMapper {
  private FeeService feeService;
  public Payment toDomain(CreatePayment toCreate, Long studentId, Long feeId){
    Fee fee = feeService.getByStudentIdAndId(studentId, feeId);
    return Payment.builder()
            .type(toCreate.getType())
            .amount(toCreate.getAmount())
            .creationDatetime(Instant.now())
            .fee(fee)
            .build();
  }

  public com.hackathon.contest.payment.model.rest.Payment toRest(Payment domain){
    return com.hackathon.contest.payment.model.rest.Payment.builder()
            .id(domain.getId())
            .type(domain.getType())
            .amount(domain.getAmount())
            .creationDatetime(domain.getCreationDatetime())
            .fee_type(domain.getFee().getType().toString())
            .build();
  }
}
