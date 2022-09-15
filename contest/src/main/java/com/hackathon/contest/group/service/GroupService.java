package com.hackathon.contest.group.service;

import com.hackathon.contest.group.model.Groups;
import com.hackathon.contest.group.repository.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GroupService {
  private GroupRepository repository;

  public List<Groups> getAll() {
    return repository.findAll();
  }

  public List<Groups> save(List<Groups> toSave) {
    return repository.saveAll(toSave);
  }

  public Optional<Groups> getById(Long id) {
    return repository.findById(id);
  }

  public Groups update(Groups toUpdate) {
    Optional<Groups> group = getById(toUpdate.getId());
    if (group.isPresent()) {
      group.get().setName(toUpdate.getName());
      return repository.save(group.get());
    } else {
      throw new RuntimeException();
    }
  }
}
