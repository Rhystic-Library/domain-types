package com.rhysticlibrary.core.http;

import lombok.NonNull;

/**
 * Contract for an HttpEntity
 */
public interface HttpEntity {

  /**
   * @return String value representation of the entity.
   */
  @NonNull
  String getValue();

  /**
   * @return the class type representation for the entity.
   */
  @NonNull
  Class<?> getTClass();
}
