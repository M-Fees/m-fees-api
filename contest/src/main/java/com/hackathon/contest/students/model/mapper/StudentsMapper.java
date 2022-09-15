package com.hackathon.contest.students.model.mapper;

import com.hackathon.contest.grade.model.Grade;
import com.hackathon.contest.grade.service.GradeService;
import com.hackathon.contest.group.model.Groups;
import com.hackathon.contest.group.service.GroupService;
import com.hackathon.contest.students.model.rest.CreateStudents;
import com.hackathon.contest.students.model.rest.Students;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class StudentsMapper {
  private GradeService gradeService;
  private GroupService groupService;

  public Students toRest(com.hackathon.contest.students.model.Students domain) {
    return Students.builder()
            .id(domain.getId())
            .ref(domain.getRef())
            .firstName(domain.getFirstName())
            .lastName(domain.getLastName())
            .sex(domain.getSex())
            .address(domain.getAddress())
            .grade(domain.getGrade().getGrade())
            .groupe(domain.getGroups().getName())
            .email(domain.getEmail())
            .phone(domain.getPhone())
            .build();
  }

  public com.hackathon.contest.students.model.Students toDomain(CreateStudents toCreate) {
    Optional<Grade> grade = gradeService.getById(toCreate.getGrade_id());
    Optional<Groups> group = groupService.getById(toCreate.getGroup_id());
    com.hackathon.contest.students.model.Students domain = new com.hackathon.contest.students.model.Students();
    domain.setRef(toCreate.getRef());
    domain.setFirstName(toCreate.getFirstName());
    domain.setLastName(toCreate.getLastName());
    domain.setSex(toCreate.getSex());
    domain.setAddress(toCreate.getAddress());
    domain.setGrade(grade.get());
    domain.setGroups(group.get());
    domain.setEmail(toCreate.getEmail());
    domain.setPhone(toCreate.getPhone());
    return domain;
  }
}
