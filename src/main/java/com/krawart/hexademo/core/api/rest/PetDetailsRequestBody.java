package com.krawart.hexademo.core.api.rest;

import jakarta.validation.constraints.NotNull;
import java.time.OffsetDateTime;

record PetDetailsRequestBody(
  @NotNull String name,
  @NotNull OffsetDateTime birthDate
) {}
