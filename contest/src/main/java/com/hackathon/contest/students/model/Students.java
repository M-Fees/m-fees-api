package com.hackathon.contest.students.model;

import com.hackathon.contest.grade.model.Grade;
import com.hackathon.contest.group.model.Groups;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class Students implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String ref;

  private String firstName;

  private String lastName;

  private String address;

  private String sex;

  @ManyToOne
  @JoinColumn
  private Grade grade;

  @ManyToOne
  @JoinColumn
  private Groups groups;

  private String email;

  private String phone;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
      return false;
    Students students = (Students) o;
    return id != null && Objects.equals(id, students.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
