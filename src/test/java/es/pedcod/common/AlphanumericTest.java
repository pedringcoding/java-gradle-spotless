package es.pedcod.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/** Unit Test Class for common {@link Alphanumeric#Alphanumeric utilities}. */
@DisplayName("A Alphanumeric")
@TestMethodOrder(MethodName.class)
public class AlphanumericTest {

  @Test
  @DisplayName("When value parameter length must be greater than zero")
  void testValidateGreatherThanZero() {
    final int expectedLength = -5;

    final IllegalArgumentException expectedThrow =
        assertThrows(IllegalArgumentException.class, () -> Alphanumeric.generate(expectedLength));

    assertThat(expectedThrow)
        .satisfies(
            rimareEx -> {
              assertThat(rimareEx.getClass()).isEqualTo(IllegalArgumentException.class);
              assertThat(rimareEx.getMessage())
                  .contains(
                      String.format(
                          "Requested random string length %s is less than 0.", expectedLength));
            });
  }

  @Test
  @DisplayName("When create a random string according of chars specified")
  void testNominalCase() {
    final int expectedLength = 10;

    final String actualString = Alphanumeric.generate(expectedLength);

    assertThat(actualString).isNotEmpty().doesNotContainAnyWhitespaces();
  }
}
