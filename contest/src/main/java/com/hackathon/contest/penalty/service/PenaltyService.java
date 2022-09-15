package com.hackathon.contest.penalty.service;

import com.hackathon.contest.penalty.model.Penalty;
import com.hackathon.contest.penalty.repository.PenaltyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PenaltyService {
  private final PenaltyRepository repository;

  public List<Penalty> getAll() {
    return repository.findAll();
  }

  public List<Penalty> save(List<Penalty> toCreate) {
    return repository.saveAll(toCreate);
  }

  public Penalty update(Penalty toUpdate) {
    Optional<Penalty> penalty = repository.findById(toUpdate.getId());
    if (penalty.isPresent()) {
      penalty.get().setInterest(toUpdate.getInterest());
      penalty.get().setInterestTimerate(toUpdate.getInterestTimerate());
      return repository.save(penalty.get());
    } else {
      throw new RuntimeException();
    }
  }
}
