package com.hackathon.contest.payment.service;

import com.hackathon.contest.fees.model.rest.CreateFee;
import com.hackathon.contest.payment.model.Payment;
import com.hackathon.contest.payment.repository.PaymentRepository;
import com.twilio.twiml.voice.Pay;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PaymentService {
  private PaymentRepository repository;

  public List<Payment> getAll(){
    return repository.findAll();
  }

  public Optional<Payment> getById(Long id){
    return repository.findById(id);
  }

  public List<Payment> getByStudentIdAndFeeId(Long studentId, Long feeId, int page, int pageSize){
    Pageable pageable = PageRequest.of(page, pageSize);
    return repository.findByFeeStudentsIdAndFeeId(studentId, feeId, pageable);
  }
  public List<Payment> getByStudentAndFee(Long studentId, int page, int pageSize){
    Pageable pageable = PageRequest.of(page, pageSize);
    return repository.findByFeeStudentsId(studentId, pageable);
  }

  public List<Payment> createPayement(List<Payment> payment){
    return repository.saveAll(payment);
  }

  public List<Payment> paymentList(List<CreateFee.Payment> list_id){
    List<Payment> list = new ArrayList<>();
    for (CreateFee.Payment payment: list_id) {
      list.add(getById(payment.getId()).get());
    }
    return list;
  }
}