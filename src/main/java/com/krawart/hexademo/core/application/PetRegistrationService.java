package com.krawart.hexademo.core.application;

import com.krawart.hexademo.core.domain.OwnerRepository;
import com.krawart.hexademo.core.domain.Pet;
import com.krawart.hexademo.core.domain.PetRepository;
import com.krawart.hexademo.kernel.application.cqrs.Command;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class PetRegistrationService {

  private final PetRepository petRepository;
  private final OwnerRepository ownerRepository;

  @Builder
  public record RegistrationCommand(
    @NotNull UUID ownerId,
    @NotNull String name,
    @PastOrPresent @NotNull OffsetDateTime birthDate
  )
    implements Command {}

  public Pet register(RegistrationCommand command) {
    checkOwnerExists(command);

    var pet = Pet
      .builder()
      .id(petRepository.nextId())
      .ownerId(command.ownerId())
      .name(command.name())
      .birthDate(command.birthDate())
      .build();

    petRepository.add(pet);

    return pet;
  }

  private void checkOwnerExists(RegistrationCommand command) {
    if (!ownerRepository.existsById(command.ownerId())) {
      throw new RuntimeException("Owner not found");
    }
  }
}
