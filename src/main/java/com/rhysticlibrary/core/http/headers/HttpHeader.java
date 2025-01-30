package com.rhysticlibrary.core.http.headers;

import com.rhysticlibrary.core.http.HttpEntity;
import lombok.NonNull;

/**
 * Contract for an HttpHeader
 */
public interface HttpHeader extends HttpEntity {

  /**
   * @return whether http header should be serialized by ObjectMapper
   */
  @NonNull
  Boolean serializable();
}
