package n1exercici2;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class CalculoDniTest {

	@Parameters
	public static Iterable<Object[]> getData() {
		return Arrays.asList(new Object[][] { { 85306804, 'B', 'B' }, { 15761896, 'L', 'L' }, { 10, 'X', 'X' },
				{ 46725892, 'N', 'N' }, { 94405708, 'T', 'T' }, { 53291912, 'S', 'S' }, { 13071213, 'Z', 'Z' },
				{ 93008593, 'C', 'C' }, { 2, 'W', 'W' }, { 3, 'A', 'A' } });

	}

	private int numDni;
	private char letter;
	private char expectedLetter;

	public CalculoDniTest(int numDni, char letter, char expectedLetter) {
		this.numDni = numDni;
		this.letter = letter;
		this.expectedLetter = expectedLetter;
	}
	
	@Test
	public void testAdd() {
		CalculoDni calculoDni = new CalculoDni();
		char result = calculoDni.calculateLetter(numDni);

		assertEquals(expectedLetter, result);
	}
	
	/*
	@Test
	public void testCalculateLetter() {
		CalculoDni calculoDni = new CalculoDni();
		int[] numbersDni = { 85306804, 15761896, 10, 46725892, 94405708, 53291912, 13071213, 93008593, 2, 3 };
		char[] expectedLetters = { 'B', 'L', 'X', 'N', 'T', 'S', 'Z', 'C', 'W', 'A' };

		for (int i = 0; i < numbersDni.length; i++) {
			char calculatedLetter = calculoDni.calculateLetter(numbersDni[i]);
			assertEquals(expectedLetters[i], calculatedLetter);
		}
	}*/

	
}
