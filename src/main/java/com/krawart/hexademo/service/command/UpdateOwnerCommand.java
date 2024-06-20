package com.krawart.hexademo.service.command;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UpdateOwnerCommand(
  @NotBlank String firstName,
  @NotBlank String lastName,
  @Email String email
) {}
