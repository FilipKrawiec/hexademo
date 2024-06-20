package com.krawart.hexademo.core.domain;

import com.krawart.hexademo.kernel.domain.Repository;
import java.util.UUID;

public interface VetRepository extends Repository {
  boolean add(Vet vet);

  Vet update(Vet vet);

  Vet getById(UUID id);

  void deleteById(UUID id);
}
