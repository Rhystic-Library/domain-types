package com.rhysticlibrary.core.http;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * The schema representing the HealthCheckStatus of a health endpoint.
 */
@Accessors(fluent = true)
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class HealthCheckStatus {

  private static final String OK = "OK";

  @NonNull
  private String status;

  /**
   * Healthy system
   *
   * @return HealthCheckStatus of ok.
   */
  public static HealthCheckStatus ok() {
    return new HealthCheckStatus(OK);
  }
}
