package com.krawart.hexademo.core.api.rest;

import com.krawart.hexademo.core.application.PetDetailsService;
import com.krawart.hexademo.core.application.PetQueryService;
import com.krawart.hexademo.core.application.PetRegistrationService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pets")
@RequiredArgsConstructor
class PetController {

  private final PetRegistrationService registrationService;
  private final PetDetailsService petDetailsService;
  private final PetQueryService petQueryService;

  @PostMapping
  ResponseEntity<PetResponse> registerPet(
    @RequestBody @Valid PetRegistrationRequestBody body
  ) {
    var result = registrationService.register(
      PetRegistrationService.RegistrationCommand
        .builder()
        .ownerId(UUID.fromString(body.ownerId()))
        .name(body.name())
        .birthDate(body.birthDate())
        .build()
    );
    return ResponseEntity
      .created(URI.create("/api/v1/pets/" + result.getId()))
      .build();
  }

  @PatchMapping("/{id}/details")
  ResponseEntity<PetResponse> updatePetDetails(
    @PathVariable String id,
    @RequestBody @Valid PetDetailsRequestBody body
  ) {
    var result = petDetailsService.updateDetails(
      PetDetailsService.UpdatePetDetailsCommand
        .builder()
        .petId(UUID.fromString(id))
        .name(Optional.of(body.name()))
        .birthDate(Optional.of(body.birthDate()))
        .build()
    );
    return ResponseEntity.ok(PetResponse.of(result));
  }

  @GetMapping("/{id}")
  ResponseEntity<PetResponse> findPetById(@PathVariable String id) {
    return petQueryService
      .findById(UUID.fromString(id))
      .map(pet -> ResponseEntity.ok(PetResponse.of(pet)))
      .orElse(ResponseEntity.notFound().build());
  }
}
