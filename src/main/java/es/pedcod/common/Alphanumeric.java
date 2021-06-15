package es.pedcod.common;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.RandomStringUtils;

import java.lang.Number;

/** The commons class to generate random Strings */
@UtilityClass
public class Alphanumeric {

	/**
	 * Creates a random string whose length is the number of characters specified.
	 * <p>
	 * Characters will be chosen from the set of Latin alphabetic characters (a-z, A-Z).
	 *
	 * @param nroChars the length of random string to create
	 * @return the random string
	 */
	public static final String generate(final int nroChars) {
		return RandomStringUtils.randomAlphabetic(nroChars);
	}
}
