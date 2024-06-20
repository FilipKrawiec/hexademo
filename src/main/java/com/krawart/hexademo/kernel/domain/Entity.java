package com.krawart.hexademo.kernel.domain;

import java.io.Serializable;

/**
 * A field for the ID is Often included and class implements equals() and hashCode() accordingly
 *
 * @param <ID> Identifier type
 */
public interface Entity<ID extends Serializable>
  extends IdentifiableDomainObject<ID> {}
