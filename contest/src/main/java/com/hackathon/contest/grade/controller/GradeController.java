package com.hackathon.contest.grade.controller;

import com.hackathon.contest.grade.model.Grade;
import com.hackathon.contest.grade.model.mapper.GradeMapper;
import com.hackathon.contest.grade.model.rest.CreateGrade;
import com.hackathon.contest.grade.service.GradeService;
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
@RequestMapping("/grades")
@CrossOrigin(value = "*")
public class GradeController {
  private GradeService service;
  private GradeMapper mapper;

  @GetMapping
  public List<Grade> getAllGrades(){
    return service.findAllGrades();
  }
  @PostMapping
  public List<Grade> createGrade(@RequestBody List<CreateGrade> toCreate){
    var toSave = toCreate.stream()
            .map(mapper::toDomain)
            .toList();
    return service.save(toSave);
  }
  @PutMapping
  public Grade updateGrade(@RequestBody Grade toUpdate){
    return service.update(toUpdate);
  };
}