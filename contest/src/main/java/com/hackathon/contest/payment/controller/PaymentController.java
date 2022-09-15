package com.hackathon.contest.payment.controller;

import com.hackathon.contest.payment.model.mapper.PaymentMapper;
import com.hackathon.contest.payment.model.rest.CreatePayment;
import com.hackathon.contest.payment.model.rest.Payment;
import com.hackathon.contest.payment.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(value = "*")
public class PaymentController {
  private final PaymentMapper mapper;
  private PaymentService service;

  @GetMapping("/students/{student_id}/fees/{fee_id}/payments")
  public List<Payment> getPaymentsByStudentsAndFees(
          @PathVariable Long student_id,
          @PathVariable Long fee_id,
          @RequestParam("page") int page,
          @RequestParam("page_size") int pageSize
  ) {
    return service.getByStudentIdAndFeeId(student_id, fee_id, page, pageSize).stream()
            .map(mapper::toRest).toList();
  }
  @GetMapping("/students/{student_id}/fees/payments")
  public List<Payment> getAll(
          @PathVariable Long student_id,
          @RequestParam("page") int page,
          @RequestParam("page_size") int pageSize
  ) {
    return service.getByStudentAndFee(student_id, page, pageSize).stream()
            .map(mapper::toRest).toList();
  }

  @PostMapping("/students/{student_id}/fees/{fee_id}/payments")
  public List<Payment> createPayments(
          @PathVariable Long student_id,
          @PathVariable Long fee_id,
          @RequestBody List<CreatePayment> toCreate
  ) {
    var toSave = toCreate.stream()
            .map(elt -> mapper.toDomain(elt, student_id, fee_id)).toList();
    return service.createPayement(toSave).stream()
            .map(mapper::toRest).toList();
  }
}
