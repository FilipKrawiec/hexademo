package com.krawart.hexademo.core.api.rest;

import com.krawart.hexademo.core.domain.values.PersonDetails;

record PersonDetailResponse(
  String firstName,
  String middleName,
  String lastName
) {
  static PersonDetailResponse of(PersonDetails value) {
    return new PersonDetailResponse(
      value.firstName(),
      value.middleName(),
      value.lastName()
    );
  }
}
