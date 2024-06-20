package com.krawart.hexademo.core.domain.values;

import com.krawart.hexademo.kernel.domain.ValueObject;
import lombok.Builder;

@Builder
public record PersonDetails(
  String firstName,
  String middleName,
  String lastName,
  String email
)
  implements ValueObject {}
