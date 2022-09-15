package com.hackathon.contest.fees.controller;

import com.hackathon.contest.fees.model.mapper.FeeMapper;
import com.hackathon.contest.fees.model.rest.CreateFee;
import com.hackathon.contest.fees.model.rest.Fee;
import com.hackathon.contest.fees.service.FeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(value = "*")
public class FeeController {
  private FeeService service;
  private FeeMapper feeMapper;

  @GetMapping("/students/{student_id}/fees")
  public List<Fee> getAll(
          @PathVariable Long student_id
  ) {
    return service.getByStudentId(student_id).stream()
            .map(feeMapper::toRest).toList();
  }

  @PostMapping("/students/{student_id}/fees")
  public List<Fee> createFees(@RequestBody List<CreateFee> toCreate, @PathVariable Long student_id) {
    var toSave = toCreate.stream()
            .map(elt -> feeMapper.toDomain(elt, student_id)).toList();
    return service.save(toSave).stream()
            .map(feeMapper::toRest).toList();
  }
}
