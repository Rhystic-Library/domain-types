package com.rhysticlibrary.core.logger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;

/**
 * Enum for representing the different Logger Contexts that are available.
 * This is specific for general logger contexts.
 */
@AllArgsConstructor
@Getter
public enum GeneralLoggerContext implements LoggerContext {

  /**
   * The exception message
   */
  EXCEPTION("exception", String.class, false),
  /**
   * The trace of the exception
   */
  EXCEPTION_TRACE("exceptionTrace", StackTraceElement[].class, true),
  /**
   * The duration of the request.
   */
  REQUEST_DURATION("requestDuration", Long.class, false);

  @NonNull
  private final String value;
  @NonNull
  private final Class<?> tClass;
  @Accessors(fluent = true)
  @NonNull
  private final Boolean serializable;
}
