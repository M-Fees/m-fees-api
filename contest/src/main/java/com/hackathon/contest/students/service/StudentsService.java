package com.hackathon.contest.students.service;

import com.hackathon.contest.students.model.Students;
import com.hackathon.contest.students.repository.StudentsRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentsService {
  private StudentsRepository repository;

  public List<Students> findAllStudents(int page, int pageSize) {
    Pageable pageable = PageRequest.of(page, pageSize);
    return repository.findAll(pageable).toList();
  }

  public Optional<Students> getById(Long id) {
    return repository.findById(id);
  }

  public List<Students> save(List<Students> toCreate) {
    return repository.saveAll(toCreate);
  }

  public Students update(Students students) {
    Optional<Students> toUpdate = getById(students.getId());
    if (toUpdate.isPresent()) {
      toUpdate.get().setRef(students.getRef());
      toUpdate.get().setFirstName(students.getFirstName());
      toUpdate.get().setLastName(students.getLastName());
      toUpdate.get().setSex(students.getSex());
      toUpdate.get().setAddress(students.getAddress());
      toUpdate.get().setEmail(students.getEmail());
      toUpdate.get().setPhone(students.getPhone());
      toUpdate.get().setGrade(students.getGrade());
      return repository.save(toUpdate.get());
    } else {
      throw new RuntimeException();
    }
  }
}
