package com.hackathon.contest.fees.service;

import com.hackathon.contest.fees.model.Fee;
import com.hackathon.contest.fees.repository.FeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FeeService {
  private FeeRepository feeRepository;

  public List<Fee> getByStudentId(Long student_id) {
    return feeRepository.findFeesByStudentsId(student_id);
  }

  public List<Fee> save(List<Fee> toCreate) {
    return feeRepository.saveAll(toCreate);
  }

  public Fee getByStudentIdAndId(Long studentId, Long id){
    return feeRepository.findByStudentsIdAndId(studentId, id);
  };
}
