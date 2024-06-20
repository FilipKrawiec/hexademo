package com.krawart.hexademo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Getter
@Setter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Medicine extends BaseEntity {

  @Column(name = "name")
  private String name;

  @Column(name = "weight")
  private Double weight;
}
