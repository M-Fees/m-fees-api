package com.hackathon.contest.fees.model.mapper;

import com.hackathon.contest.fees.model.rest.CreateFee;
import com.hackathon.contest.fees.model.rest.Fee;
import com.hackathon.contest.payment.model.Payment;
import com.hackathon.contest.payment.service.PaymentService;
import com.hackathon.contest.students.model.Students;
import com.hackathon.contest.students.service.StudentsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class FeeMapper {

  private StudentsService studentsService;
  private PaymentService paymentService;

  public Fee toRest(com.hackathon.contest.fees.model.Fee domain) {
    return Fee.builder()
            .id(domain.getId())
            .type(domain.getType())
            .totalAmount(domain.getTotalAmount())
            .remainingAmount(domain.getRemainingAmount())
            .student_id(domain.getStudents().getId())
            .creationDatetime(domain.getCreationDatetime())
            .status(domain.getStatus())
            .build();
  }

  public com.hackathon.contest.fees.model.Fee toDomain(CreateFee toCreate, Long id) {
    com.hackathon.contest.fees.model.Fee toSave = new com.hackathon.contest.fees.model.Fee();
    Optional<Students> holder = studentsService.getById(id);
    toSave.setType(toCreate.getType());
    toSave.setCreationDatetime(Instant.now());
    if (holder.isPresent()
            && toCreate.getType() == com.hackathon.contest.fees.model.Fee.Type.TUITION) {
      toSave.setTotalAmount(holder.get().getGrade().getFee());
      toSave.setStudents(holder.get());
    } else {
      toSave.setTotalAmount(toCreate.getTotalAmount());
      toSave.setStudents(holder.get());
    }
    toSave.setPayments(null);
    if(toSave.getRemainingAmount() == 0.0){
      toSave.setStatus(com.hackathon.contest.fees.model.Fee.Status.PAID);
    }else{
      toSave.setStatus(com.hackathon.contest.fees.model.Fee.Status.UNPAID);
    }
    return toSave;
  }

}
