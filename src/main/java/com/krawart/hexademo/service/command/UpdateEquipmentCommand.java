package com.krawart.hexademo.service.command;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record UpdateEquipmentCommand(
  @NotBlank String name,
  @Min(1) Integer quantity
) {}
