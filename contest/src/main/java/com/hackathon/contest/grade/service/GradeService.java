package com.hackathon.contest.grade.service;

import com.hackathon.contest.grade.model.Grade;
import com.hackathon.contest.grade.repository.GradeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GradeService {
  private GradeRepository repository;
  public List<Grade> findAllGrades(){
    return repository.findAll();
  }
  public Optional<Grade> getById(Long id){
    return repository.findById(id);
  }

  public List<Grade> save(List<Grade> toSave){
    return repository.saveAll(toSave);
  }

  public Grade update(Grade toUpdate){
    Optional<Grade> grade = getById(toUpdate.getId());
    if(grade.isPresent()){
      grade.get().setGrade(toUpdate.getGrade());
      grade.get().setFee(toUpdate.getFee());
      return repository.save(grade.get());
    }
    else{
      throw new RuntimeException();
    }
  }
}
