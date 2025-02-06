package com.rhysticlibrary.core.http.headers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;
import org.springframework.http.HttpHeaders;

/**
 * General Request Header enum representing generic HttpHeaders.
 */
@AllArgsConstructor
@Getter
public enum GeneralRequestHeader implements HttpHeader {

  /**
   * Representation of the ACCEPT Http Header.
   */
  ACCEPT(HttpHeaders.ACCEPT, String.class, false),
  /**
   * Representation of the CONTENT_TYPE Http Header.
   */
  CONTENT_TYPE(HttpHeaders.CONTENT_TYPE, String.class, false);

  @NonNull
  private final String value;
  @NonNull
  private final Class<?> tClass;
  @Accessors(fluent = true)
  private final boolean serializable;
}
