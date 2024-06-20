package com.krawart.hexademo.core.application;

import com.krawart.hexademo.core.domain.Pet;
import com.krawart.hexademo.core.domain.PetRepository;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PetQueryService {

  private final PetRepository petRepository;

  public Pet getById(UUID id) {
    return petRepository.getById(id);
  }

  public Optional<Pet> findById(UUID id) {
    return petRepository.findById(id);
  }
}
