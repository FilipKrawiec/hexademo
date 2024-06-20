package com.krawart.hexademo.core.infrastructure.persistence;

import com.krawart.hexademo.core.domain.Owner;
import com.krawart.hexademo.core.domain.OwnerRepository;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
class InMemoryOwnerRepository implements OwnerRepository {

  private final Map<UUID, Owner> internalStorage = new ConcurrentHashMap<>();

  @Override
  public UUID nextId() {
    return UUID.randomUUID();
  }

  @Override
  public boolean add(Owner pet) {
    return internalStorage.putIfAbsent(pet.getId(), pet) == null;
  }

  @Override
  public Owner update(Owner pet) {
    internalStorage.put(pet.getId(), pet);
    return pet;
  }

  @Override
  public Owner getById(UUID id) {
    return internalStorage.get(id);
  }

  @Override
  public Optional<Owner> findById(UUID id) {
    return Optional.ofNullable(internalStorage.get(id));
  }

  @Override
  public void deleteById(UUID id) {
    internalStorage.remove(id);
  }

  @Override
  public boolean existsById(UUID id) {
    return internalStorage.containsKey(id);
  }
}
