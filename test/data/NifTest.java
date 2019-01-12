package data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NifTest {
	private Nif nifOne, nifTwo, nifOneCopy;

	@BeforeEach
	void prepare() {
		nifOne = new Nif("123456789A");
		nifTwo = new Nif("987654321A");
		nifOneCopy = new Nif("123456789A");
	}

	@Test
	void getNif() {
		assertEquals("123456789A", nifOne.getNif());
		assertEquals("987654321A", nifTwo.getNif());
	}

	@Test
	void equalsOnDifferentObjects() {
		assertFalse(nifOne.equals(nifTwo));
	}

	@Test
	void equalsOnDifferentObjectsWithSameNif() {
		assertTrue(nifOne.equals(nifOneCopy));
	}

	@Test
	void toStringTest() {
		assertEquals("Nif{nif='123456789A'}", nifOne.toString());
		assertEquals("Nif{nif='987654321A'}", nifTwo.toString());
	}

	@Test
	void catchExceptionOnNullToConstructor(){
		Throwable exception = assertThrows(NullPointerException.class,
			   () -> {
				   new Nif(null);
			   });
	}
}