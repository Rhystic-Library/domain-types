package com.rhysticlibrary.core.http;

import com.rhysticlibrary.core.BaseComponent;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

final class RestErrorTest extends BaseComponent {

  private static final String CAUSED_BY_MESSAGE = "Caused by me.";
  private static final Exception CAUSED_BY_EXCEPTION = new Exception(CAUSED_BY_MESSAGE);
  private static final UUID TRACE_ID = UUID.fromString("d3f6b8e0-850b-4771-bfc0-b79ed2cfddc1");

  @Test
  public void testEqualsAndHash() {
    EqualsVerifier.forClass(RestError.class)
        .suppress(Warning.NONFINAL_FIELDS)
        .verify();
  }

  @Test
  public void testCreationWithTraceId() {
    RestError error = this.buildRestErrorWithTraceId();

    assertThat(error.traceId())
        .isEqualTo(TRACE_ID);
    assertThat(error.error())
        .isEqualTo(CAUSED_BY_EXCEPTION.getClass().getSimpleName());
    assertThat(error.message())
        .isEqualTo(CAUSED_BY_MESSAGE);
  }

  @Test
  public void testCreationWithoutTraceId() {
    RestError error = this.buildRestError();

    assertThat(error.traceId())
        .isNull();
    assertThat(error.error())
        .isEqualTo(CAUSED_BY_EXCEPTION.getClass().getSimpleName());
    assertThat(error.message())
        .isEqualTo(CAUSED_BY_MESSAGE);
  }

  private RestError buildRestErrorWithTraceId() {
    return new RestError(TRACE_ID, CAUSED_BY_EXCEPTION);
  }

  private RestError buildRestError() {
    return new RestError(CAUSED_BY_EXCEPTION);
  }
}