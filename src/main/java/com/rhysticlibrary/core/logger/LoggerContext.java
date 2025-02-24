package com.rhysticlibrary.core.logger;

import lombok.NonNull;

/**
 * Interface for the contract for LoggerContext
 */
public interface LoggerContext {

  /**
   * The key of the logger context
   *
   * @return the key
   */
  @NonNull
  String getValue();

  /**
   * The type of object stored in that context.
   *
   * @return the class type in the logger context.
   */
  @NonNull
  Class<?> getTClass();

  /**
   * Whether the object stored in the logger context is serializable or not.
   *
   * @return a boolean where true means it is serializable.
   */
  @NonNull
  Boolean serializable();
}
