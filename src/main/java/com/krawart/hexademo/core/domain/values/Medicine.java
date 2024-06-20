package com.krawart.hexademo.core.domain.values;

import com.krawart.hexademo.kernel.domain.ValueObject;
import java.util.UUID;
import lombok.Builder;

@Builder
public record Medicine(UUID manufacturerId, String supplierId, String name)
  implements ValueObject {}
