package com.hackathon.contest.group.controller;

import com.hackathon.contest.group.model.Groups;
import com.hackathon.contest.group.model.mapper.GroupMapper;
import com.hackathon.contest.group.model.rest.CreateGroup;
import com.hackathon.contest.group.service.GroupService;
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
@CrossOrigin(value = "*")
@RequestMapping("/groups")
public class GroupController {
  private GroupService service;
  private GroupMapper mapper;

  @GetMapping
  public List<Groups> getAllGroup() {
    return service.getAll();
  }

  @PostMapping
  public List<Groups> createGroup(@RequestBody List<CreateGroup> toCreate) {
    var toSave = toCreate.stream().map(mapper::toDomain).toList();
    return service.save(toSave);
  }

  @PutMapping
  public Groups updateGroup(@RequestBody Groups toUpdate) {
    return service.update(toUpdate);
  }

}
