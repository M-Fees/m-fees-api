package com.hackathon.contest.manager.controller;

import com.hackathon.contest.manager.model.mapper.ManagerMapper;
import com.hackathon.contest.manager.model.rest.CreateManager;
import com.hackathon.contest.manager.model.rest.Manager;
import com.hackathon.contest.manager.service.ManagerService;
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
@RequestMapping("/manager")
@CrossOrigin(value = "*")
public class ManagerController {
  private final ManagerService service;
  private final ManagerMapper mapper;

  @GetMapping
  public List<Manager> getManagers() {
    return service.getAll().stream()
            .map(mapper::toRest).toList();
  }

  @PostMapping
  public List<Manager> createManager(@RequestBody List<CreateManager> toWrite) {
    var saved = toWrite.stream().map(mapper::toDomain).toList();
    return service.save(saved).stream()
            .map(mapper::toRest).toList();
  }

  @PutMapping
  public Manager updateManager(@RequestBody com.hackathon.contest.manager.model.Manager toUpdate) {
    return mapper.toRest(service.update(toUpdate));
  }
}
