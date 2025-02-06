package com.rhysticlibrary.core.exceptions.http;

import com.rhysticlibrary.core.http.HttpEntity;
import lombok.NonNull;

/**
 * Exception that represents that a header has a bad format.
 */
public final class InvalidHttpEntityFormatException extends RuntimeException {

  private static final String FORMATTED_EXCEPTION_MESSAGE = "%s with key '%s' could not be parsed.";

  private InvalidHttpEntityFormatException(String message, Exception ex) {
    super(message, ex);
  }

  /**
   * Creates the exception with no caused by exception.
   *
   * @param entity The entity that has a bad format.
   * @return The exception created.
   */
  public static @NonNull InvalidHttpEntityFormatException forEntity(@NonNull HttpEntity entity) {
    return forEntity(entity, null);
  }

  /**
   * Creates the exception with a caused by exception.
   *
   * @param entity    The entity that has a bad format.
   * @param exception the exception that was the root cause of this format error.
   * @return The exception created.
   */
  public static @NonNull InvalidHttpEntityFormatException forEntity(@NonNull HttpEntity entity, Exception exception) {
    return new InvalidHttpEntityFormatException(
        String.format(
            FORMATTED_EXCEPTION_MESSAGE,
            entity.getClass().getSimpleName(),
            entity.getValue()
        ),
        exception
    );
  }
}
