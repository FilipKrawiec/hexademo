package com.krawart.hexademo.service.command;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AddOwnerCommand(
  @NotBlank String firstName,
  @NotBlank String lastName,
  @Email String email
) {}
