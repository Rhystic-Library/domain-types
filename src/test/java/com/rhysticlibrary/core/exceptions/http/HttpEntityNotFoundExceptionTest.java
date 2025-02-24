package com.rhysticlibrary.core.exceptions.http;

import com.rhysticlibrary.core.BaseComponent;
import com.rhysticlibrary.core.http.HttpEntity;
import com.rhysticlibrary.core.http.headers.GeneralRequestHeader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class HttpEntityNotFoundExceptionTest extends BaseComponent {

  private static final String CAUSED_BY_MESSAGE = "Caused by me.";
  private static final Exception CAUSED_BY_EXCEPTION = new Exception(CAUSED_BY_MESSAGE);
  private static final HttpEntity ENTITY = GeneralRequestHeader.CALLER_TRACE_ID;
  private static final String FORMATTED_EXCEPTION_MESSAGE = "%s with key '%s' not found.";

  private static Stream<Arguments> provideTestForEntityPassingExceptionData() {
    return Stream.of(
        Arguments.of((Exception) null),
        Arguments.of(CAUSED_BY_EXCEPTION)
    );
  }

  @Test
  void testForEntity() {
    HttpEntityNotFoundException ex = HttpEntityNotFoundException.forEntity(ENTITY);
    assertThat(ex)
        .hasMessage(this.getExpectedExceptionMessage())
        .hasRootCause(null);
  }

  @MethodSource("provideTestForEntityPassingExceptionData")
  @ParameterizedTest
  void testForEntityPassingException(Exception causedByEx) {
    HttpEntityNotFoundException ex = HttpEntityNotFoundException.forEntity(ENTITY, causedByEx);
    assertThat(ex)
        .hasMessage(this.getExpectedExceptionMessage())
        .hasRootCause(causedByEx);
  }

  @Test
  void testForEntityPassingException_HasRootCauseMessage() {
    HttpEntityNotFoundException ex = HttpEntityNotFoundException.forEntity(ENTITY, CAUSED_BY_EXCEPTION);
    assertThat(ex).hasRootCauseMessage(CAUSED_BY_MESSAGE);
  }

  private String getExpectedExceptionMessage() {
    return String.format(FORMATTED_EXCEPTION_MESSAGE, ENTITY.getClass().getSimpleName(), ENTITY.getValue());
  }
}