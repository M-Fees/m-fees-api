package com.hackathon.contest.group.model.mapper;

import com.hackathon.contest.group.model.Groups;
import com.hackathon.contest.group.model.rest.CreateGroup;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GroupMapper {

  public Groups toDomain(CreateGroup toCreate) {
    return Groups.builder()
            .name(toCreate.getName())
            .build();
  }

}
