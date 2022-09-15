package com.hackathon.contest.penalty.model.mapper;

import com.hackathon.contest.penalty.model.Penalty;
import com.hackathon.contest.penalty.model.rest.CreatePenalty;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PenaltyMapper {
  public Penalty toDomain(CreatePenalty toCreate){
    return Penalty.builder()
            .interest(toCreate.getInterest())
            .interestTimerate(toCreate.getInterestTimerate())
            .build();
  };
}
