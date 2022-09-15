package com.hackathon.contest.manager.service;

import com.hackathon.contest.manager.model.Manager;
import com.hackathon.contest.manager.repository.ManagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ManagerService {
  private ManagerRepository repository;

  public List<Manager> getAll(){
    return repository.findAll();
  }

  public List<Manager> save(List<Manager> toCreate){
    return repository.saveAll(toCreate);
  }

  public Manager update(Manager toUpdate){
    Optional<Manager> manager = repository.findById(toUpdate.getId());
    if(manager.isPresent()){
      manager.get().setFirstName(toUpdate.getFirstName());
      manager.get().setLastName(toUpdate.getLastName());
      manager.get().setRole(toUpdate.getRole());
      manager.get().setEmail(toUpdate.getEmail());
      manager.get().setPassword(toUpdate.getPassword());
      return repository.save(manager.get());
    }else {
      throw new RuntimeException();
    }
  }
}