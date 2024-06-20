package com.krawart.hexademo.core.domain;

import com.krawart.hexademo.kernel.domain.Repository;
import java.util.Optional;
import java.util.UUID;

public interface PetRepository extends Repository {
  UUID nextId();

  boolean add(Pet pet);

  Pet update(Pet pet);

  Pet getById(UUID id);

  Optional<Pet> findById(UUID id);

  void deleteById(UUID id);
}
