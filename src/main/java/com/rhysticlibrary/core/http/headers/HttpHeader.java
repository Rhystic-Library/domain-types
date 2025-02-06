package com.rhysticlibrary.core.http.headers;

import com.rhysticlibrary.core.http.HttpEntity;

/**
 * Contract for an HttpHeader
 */
public interface HttpHeader extends HttpEntity {

  /**
   * @return whether http header should be serialized by ObjectMapper
   */
  boolean serializable();
}
