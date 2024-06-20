package com.krawart.hexademo.service.command;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.time.Instant;

public record UpdatePetCommand(
  @PastOrPresent @NotNull Instant birthDate,
  @NotNull String name,
  @NotNull String ownerId
) {}
