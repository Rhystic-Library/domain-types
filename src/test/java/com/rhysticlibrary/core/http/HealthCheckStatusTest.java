package com.rhysticlibrary.core.http;


import com.rhysticlibrary.core.BaseComponent;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

final class HealthCheckStatusTest extends BaseComponent {

  private static final String OK = "OK";

  @Test
  void testEqualsAndHash() {
    EqualsVerifier.forClass(HealthCheckStatus.class)
        .suppress(Warning.NONFINAL_FIELDS)
        .verify();
  }

  @Test
  void testOk() {
    HealthCheckStatus healthCheckStatus = HealthCheckStatus.ok();

    assertThat(healthCheckStatus.status())
        .isEqualTo(OK);
  }
}