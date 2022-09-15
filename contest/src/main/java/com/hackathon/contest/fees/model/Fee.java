package com.hackathon.contest.fees.model;

import com.hackathon.contest.payment.model.Payment;
import com.hackathon.contest.students.model.Students;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Fee implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Type type;
  private Double totalAmount;
  @OneToMany
  private List<Payment> payments;
  @Transient
  private Double remainingAmount;
  @OneToOne
  @JoinColumn
  private Students students;

  private Instant creationDatetime;

  private Status status;

  public Double getTotalPaid() {
    Double total = 0.0;
    if(payments!=null){
      for (Payment payment : payments) {
        total += payment.getAmount();
      }
    }
    return total;
  }

  public Double getRemainingAmount() {
    this.remainingAmount = totalAmount - getTotalPaid();
    return remainingAmount;
  }

  public enum Type {
    TUITION,
    HARDWARE
  }

  public enum Status {
    PAID,
    UNPAID,
    lATE
  }
}
