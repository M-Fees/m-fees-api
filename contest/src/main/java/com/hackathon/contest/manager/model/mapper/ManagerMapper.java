package com.hackathon.contest.manager.model.mapper;

import com.hackathon.contest.manager.model.rest.CreateManager;
import com.hackathon.contest.manager.model.rest.Manager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManagerMapper {
  public Manager toRest(com.hackathon.contest.manager.model.Manager domain) {
    return Manager.builder()
            .id(domain.getId())
            .firstName(domain.getFirstName())
            .lastName(domain.getLastName())
            .role(domain.getRole())
            .email(domain.getEmail())
            .build();
  }

  public com.hackathon.contest.manager.model.Manager toDomain(CreateManager manager) {
    return com.hackathon.contest.manager.model.Manager.builder()
            .firstName(manager.getFirstName())
            .lastName(manager.getLastName())
            .email(manager.getEmail())
            .role(manager.getRole())
            .password(manager.getPassword())
            .build();
  }
}
