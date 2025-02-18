package com.rhysticlibrary.core.http.attributes;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

/**
 * General Request Attribute enum representing generic Request Attributes.
 */
@AllArgsConstructor
@Getter
public enum GeneralRequestAttribute implements RequestAttribute {

  /**
   * Representation of the start time of the request.
   */
  START_TIME("startTime", Instant.class);

  private final String value;
  private final Class<?> tClass;
}
