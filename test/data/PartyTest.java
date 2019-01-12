package data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartyTest {
	private Party partyOne, partyTwo, partyOneCopy;

	@BeforeEach
	void prepare() {
		partyOne = new Party("ABC");
		partyTwo = new Party("DEF");
		partyOneCopy = new Party("ABC");
	}

	@Test
	void getName() {
		assertEquals("ABC", partyOne.getName());
		assertEquals("DEF", partyTwo.getName());
	}

	@Test
	void equalsOnDifferentObjects() {
		assertFalse(partyOne.equals(partyTwo));
	}

	@Test
	void equalsOnDifferentObjectsWithSamePartyName() {
		assertTrue(partyOne.equals(partyOneCopy));
	}

	@Test
	void toStringTest() {
		assertEquals("Party{name='ABC'}", partyOne.toString());
		assertEquals("Party{name='DEF'}", partyTwo.toString());
	}

	@Test
	void catchExceptionOnNullToConstructor() {
		Throwable exception = assertThrows(NullPointerException.class,
			   () -> {
				   new Party(null);
			   });
	}
}