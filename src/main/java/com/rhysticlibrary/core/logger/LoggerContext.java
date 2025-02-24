package com.rhysticlibrary.core.logger;

import lombok.NonNull;

public interface LoggerContext {

  @NonNull
  String getValue();

  @NonNull
  Class<?> getTClass();

  @NonNull
  Boolean serializable();
}
