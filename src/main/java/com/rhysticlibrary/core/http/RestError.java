package com.rhysticlibrary.core.http;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.util.UUID;

/**
 * DataObject that represents errors with HttpRequests
 */
@Accessors(fluent = true)
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@NoArgsConstructor
public final class RestError {

  private UUID traceId;
  @NonNull
  private String error;
  @NonNull
  private String message;

  /**
   * Builds a rest error with a traceId.
   *
   * @param traceId the traceId of the request.
   * @param ex      the exception that caused the error.
   */
  public RestError(@NonNull UUID traceId, @NonNull Exception ex) {
    this.traceId(traceId);
    this.error(ex.getClass().getSimpleName());
    this.message(ex.getMessage());
  }

  /**
   * Builds a rest error without a traceId
   *
   * @param ex the exception that cuased the error.
   */
  public RestError(@NonNull Exception ex) {
    this.error(ex.getClass().getSimpleName());
    this.message(ex.getMessage());
  }
}
