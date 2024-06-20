package com.krawart.hexademo.service.command;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record UpdateMedicineCommand(
  @NotBlank String name,
  @Min(1) Double weight
) {}
