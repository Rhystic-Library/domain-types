package com.rhysticlibrary.core.exceptions.http;

import com.rhysticlibrary.core.http.HttpEntity;
import lombok.NonNull;

/**
 * Exception for Http Entities not found in their respective places.
 */
public final class HttpEntityNotFoundException extends RuntimeException {

  private static final String FORMATTED_EXCEPTION_MESSAGE = "%s with key '%s' not found.";

  private HttpEntityNotFoundException(String message, Exception ex) {
    super(message, ex);
  }

  /**
   * Creates an exception for a specific entity.
   *
   * @param entity the entity that was not found.
   * @return an exception for the given entity.
   */
  public static @NonNull HttpEntityNotFoundException forEntity(@NonNull HttpEntity entity) {
    return forEntity(entity, null);
  }

  /**
   * Creates an exception for a specific entity
   *
   * @param entity    the entity that was not found.
   * @param exception the caused exception.
   * @return An exception for the given entity with a caused by exception.
   */
  public static @NonNull HttpEntityNotFoundException forEntity(@NonNull HttpEntity entity, Exception exception) {
    return new HttpEntityNotFoundException(
        String.format(
            FORMATTED_EXCEPTION_MESSAGE,
            entity.getClass().getSimpleName(),
            entity.getValue()
        ),
        exception
    );
  }
}
