package com.hackathon.contest.manager.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;


@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Manager implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String firstName;

  private String lastName;

  private String role;

  private String email;

  private String password;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
      return false;
    Manager manager = (Manager) o;
    return id != null && Objects.equals(id, manager.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
