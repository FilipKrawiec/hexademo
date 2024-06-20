package com.krawart.hexademo.core.domain;

import com.krawart.hexademo.kernel.domain.Repository;
import java.util.Optional;
import java.util.UUID;

public interface OwnerRepository extends Repository {
  UUID nextId();

  boolean add(Owner owner);

  Owner update(Owner owner);

  Owner getById(UUID id);

  void deleteById(UUID id);

  boolean existsById(UUID id);

  Optional<Owner> findById(UUID id);
}
