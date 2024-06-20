package com.krawart.hexademo.core.domain;

import com.krawart.hexademo.kernel.domain.AggregateRoot;
import com.krawart.hexademo.kernel.domain.Entity;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class Pet implements AggregateRoot<UUID> {

  private final UUID id;
  private final UUID ownerId;

  @Setter
  private String name;

  @Setter
  private OffsetDateTime birthDate;

  private List<MedicationPlan> medicationPlans;

  @Builder
  @Getter
  public static class MedicationPlan implements Entity<UUID> {

    private final UUID id;

    private OffsetDateTime from;
    private OffsetDateTime to;

    private String description;
  }
}
