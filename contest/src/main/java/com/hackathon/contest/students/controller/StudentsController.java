package com.hackathon.contest.students.controller;

import com.hackathon.contest.students.model.mapper.StudentsMapper;
import com.hackathon.contest.students.model.rest.CreateStudents;
import com.hackathon.contest.students.model.rest.Students;
import com.hackathon.contest.students.service.StudentsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(value = "*")
public class StudentsController {
  private StudentsService service;
  private StudentsMapper mapper;

  @GetMapping("/students")
  public List<Students> getAllStudents(
          @RequestParam("page") int page,
          @RequestParam("page_size") int pageSize
  ) {
    return service.findAllStudents(page, pageSize).stream()
            .map(mapper::toRest).toList();
  }

  @GetMapping("/students/{id}")
  public Students getStudentById(@PathVariable Long id) {
    return mapper.toRest(service.getById(id).get());
  }

  @PostMapping("/students")
  public List<Students> createStudents(@RequestBody List<CreateStudents> toCreate) {
    var toSave = toCreate.stream()
            .map(mapper::toDomain).toList();
    return service.save(toSave).stream()
            .map(mapper::toRest).toList();
  }

  @PutMapping("/students")
  public Students updateStudent(@RequestBody com.hackathon.contest.students.model.Students toUpdate) {
    return mapper.toRest(service.update(toUpdate));
  }
}
