package com.krawart.hexademo.core.application;

import com.krawart.hexademo.core.domain.Pet;
import com.krawart.hexademo.core.domain.PetRepository;
import jakarta.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetDetailsService {

  private final PetRepository petRepository;

  @Builder
  public record UpdatePetDetailsCommand(
    @NotNull UUID petId,
    Optional<OffsetDateTime> birthDate,
    Optional<String> name
  ) {}

  public Pet updateDetails(UpdatePetDetailsCommand command) {
    var pet = petRepository.getById(command.petId);

    command.birthDate.ifPresent(pet::setBirthDate);
    command.name.ifPresent(pet::setName);

    return pet;
  }
}
