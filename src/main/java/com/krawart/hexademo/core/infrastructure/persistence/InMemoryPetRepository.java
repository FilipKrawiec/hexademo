package com.krawart.hexademo.core.infrastructure.persistence;

import com.krawart.hexademo.core.domain.Pet;
import com.krawart.hexademo.core.domain.PetRepository;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
class InMemoryPetRepository implements PetRepository {

  private final Map<UUID, Pet> internalStorage = new ConcurrentHashMap<>();

  @Override
  public UUID nextId() {
    return UUID.randomUUID();
  }

  @Override
  public boolean add(Pet pet) {
    return internalStorage.putIfAbsent(pet.getId(), pet) == null;
  }

  @Override
  public Pet update(Pet pet) {
    internalStorage.put(pet.getId(), pet);
    return pet;
  }

  @Override
  public Pet getById(UUID id) {
    return internalStorage.get(id);
  }

  @Override
  public Optional<Pet> findById(UUID id) {
    return Optional.ofNullable(internalStorage.get(id));
  }

  @Override
  public void deleteById(UUID id) {
    internalStorage.remove(id);
  }
}
