package jxj.Recursividad;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RecursividadGenerarContrasenyas {

	private final char[] LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
	private final char[] SYMBOLS = "#@&%?¿/*+-!¡Ñ<>,.-=()€$~".toCharArray();
	private final char[] DIGITS = "0123456789".toCharArray();
	private Random r;

	public enum CharType {
		DIGIT, LETTER, SYMBOLS;
	}

	public RecursividadGenerarContrasenyas() {
		r = new Random();
	}

	/**
	 *
	 * 
	 * @return
	 */
	private char getRandomLetter() {
		return LETTERS[r.nextInt(LETTERS.length)];
	}

	/**
	 *
	 * 
	 * @return
	 */
	private char getRandomDigit() {
		return DIGITS[r.nextInt(DIGITS.length)];
	}

	/**
	 *
	 * 
	 * @return
	 */
	private char getRandomLetter1() {
		return SYMBOLS[r.nextInt(DIGITS.length)];
	}

	/**
	 *
	 * 
	 * @return
	 * 
	 */
	private List<CharType> getRandomOrder() {
		List<CharType> generationOrder = Arrays.asList(CharType.values());
		Collections.shuffle(generationOrder, r);
		return generationOrder;
	}

	private boolean holdsConditions(int length, int numDigits, int numLetters, int size, int minDigits,
			int minLetters) {
		int remainingChars = size - length;
		return minDigits - numDigits <= remainingChars && minLetters - numLetters <= remainingChars;
	}

	private String generateRec(int length, int numDigits, int numLetters, int size, int minDigits, int minLetters) {
		if (holdsConditions(length, numDigits, numLetters, size, minDigits, minLetters)) {
			if (length == size)
				return "";

			String password = null;
			char randomChar = 0;

			for (CharType charType : getRandomOrder()) {
				switch (charType) {
				case DIGIT:
					password = generateRec(length + 1, numDigits + 1, numLetters, size, minDigits, minLetters);
					randomChar = getRandomDigit();
					break;

				case LETTER:
					password = generateRec(length + 1, numDigits, numLetters + 1, size, minDigits, minLetters);
					randomChar = getRandomLetter();
					break;

				case SYMBOLS:
					password = generateRec(length + 1, numDigits, numLetters + 1, size, minDigits, minLetters);
					randomChar = getRandomLetter1();
					break;
				}

				if (password != null)
					return randomChar + password;
			}
		}

		return null;
	}

	public String generate(int size, int minDigits, int minLetters) {
		if (minDigits + minLetters > size)
			throw new IllegalArgumentException(String.format(
					"Incompatible restrictions. minDigits (%d) + minLetters (%d) cannot be greater than size (%d)",
					minDigits, minLetters, size));

		return generateRec(0, 0, 0, size, minDigits, minLetters);
	}

}