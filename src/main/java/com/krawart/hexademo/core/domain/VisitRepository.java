package com.krawart.hexademo.core.domain;

import com.krawart.hexademo.kernel.domain.Repository;
import java.util.UUID;

public interface VisitRepository extends Repository {
  boolean add(Visit visit);

  Visit update(Visit visit);

  Visit getById(UUID id);

  void deleteById(UUID id);
}
