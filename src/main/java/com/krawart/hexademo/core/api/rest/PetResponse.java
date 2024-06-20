package com.krawart.hexademo.core.api.rest;

import com.krawart.hexademo.core.domain.Pet;
import java.time.OffsetDateTime;
import lombok.Builder;

@Builder
record PetResponse(
  String id,
  String ownerId,
  OffsetDateTime birthDate,
  String name
) {
  public static PetResponse of(Pet entity) {
    return PetResponse
      .builder()
      .id(entity.getId().toString())
      .ownerId(entity.getOwnerId().toString())
      .birthDate(entity.getBirthDate())
      .name(entity.getName())
      .build();
  }
}
