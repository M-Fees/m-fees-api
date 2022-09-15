package com.hackathon.contest.payment.repository;

import com.hackathon.contest.payment.model.Payment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
  List<Payment> findByFeeStudentsIdAndFeeId(Long studentId, Long feeId, Pageable pageable);

  List<Payment> findByFeeStudentsId(Long studentId, Pageable pageable);
}
