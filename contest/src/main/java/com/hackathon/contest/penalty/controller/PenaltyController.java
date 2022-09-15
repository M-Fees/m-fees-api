package com.hackathon.contest.penalty.controller;

import com.hackathon.contest.penalty.model.Penalty;
import com.hackathon.contest.penalty.model.mapper.PenaltyMapper;
import com.hackathon.contest.penalty.model.rest.CreatePenalty;
import com.hackathon.contest.penalty.service.PenaltyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/delay_penalty")
@CrossOrigin(value = "*")
public class PenaltyController {
  private final PenaltyService service;
  private final PenaltyMapper mapper;

  @GetMapping
  public List<Penalty> getAll() {
    return service.getAll();
  }

  @PostMapping
  public List<Penalty> create(@RequestBody List<CreatePenalty> toCreate) {
    var toSave = toCreate.stream()
            .map(mapper::toDomain).toList();
    return service.save(toSave);
  }

  @PutMapping
  public Penalty update(@RequestBody Penalty toUpdate) {
    return service.update(toUpdate);
  }
}
