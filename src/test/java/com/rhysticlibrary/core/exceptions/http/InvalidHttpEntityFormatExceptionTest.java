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

class InvalidHttpEntityFormatExceptionTest extends BaseComponent {

  private static final String CAUSED_BY_MESSAGE = "Caused by me.";
  private static final Exception CAUSED_BY_EXCEPTION = new Exception(CAUSED_BY_MESSAGE);
  private static final HttpEntity ENTITY = GeneralRequestHeader.ACCEPT;
  private static final String FORMATTED_EXCEPTION_MESSAGE = "%s with key '%s' could not be parsed.";

  private static Stream<Arguments> provideTestForEntityPassingExceptionData() {
    return Stream.of(
        Arguments.of((Exception) null),
        Arguments.of(CAUSED_BY_EXCEPTION)
    );
  }

  @Test
  void testForEntity() {
    InvalidHttpEntityFormatException ex = InvalidHttpEntityFormatException.forEntity(ENTITY);
    assertThat(ex)
        .hasMessage(this.getExpectedRequestExceptionMessage())
        .hasRootCause(null);
  }

  @MethodSource("provideTestForEntityPassingExceptionData")
  @ParameterizedTest
  void testForEntityPassingException(Exception causedByEx) {
    InvalidHttpEntityFormatException ex = InvalidHttpEntityFormatException.forEntity(ENTITY, causedByEx);
    assertThat(ex)
        .hasMessage(this.getExpectedRequestExceptionMessage())
        .hasRootCause(causedByEx);
  }

  @Test
  void testForEntityPassingException_HasRootCauseMessage() {
    InvalidHttpEntityFormatException ex = InvalidHttpEntityFormatException.forEntity(ENTITY, CAUSED_BY_EXCEPTION);
    assertThat(ex)
        .hasRootCauseMessage(CAUSED_BY_MESSAGE);
  }

  private String getExpectedRequestExceptionMessage() {
    return String.format(
        FORMATTED_EXCEPTION_MESSAGE,
        ENTITY.getClass().getSimpleName(),
        ENTITY.getValue()
    );
  }
}