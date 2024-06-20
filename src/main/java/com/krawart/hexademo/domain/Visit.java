package com.krawart.hexademo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.time.Instant;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Getter
@Setter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Visit extends BaseEntity {

  @Column(name = "date")
  private Instant date;

  @Column(name = "description")
  private String description;

  @ManyToOne
  @ToString.Exclude
  private Pet pet;
}
