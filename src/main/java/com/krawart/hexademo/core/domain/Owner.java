package com.krawart.hexademo.core.domain;

import com.krawart.hexademo.core.domain.values.PersonDetails;
import com.krawart.hexademo.kernel.domain.AggregateRoot;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Owner implements AggregateRoot<UUID> {

  private final UUID id;
  private PersonDetails details;
}
