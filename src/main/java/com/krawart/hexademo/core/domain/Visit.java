package com.krawart.hexademo.core.domain;

import com.krawart.hexademo.kernel.domain.AggregateRoot;
import java.time.Instant;
import java.util.UUID;
import lombok.*;

@Getter
@Builder
public class Visit implements AggregateRoot<UUID> {

  private final UUID id;
  private final UUID petId;
  private Instant date;
  private String description;
}
