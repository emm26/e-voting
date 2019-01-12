package kiosk;

import data.Party;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VoteCounterTest {

	private VoteCounter voteCounter;
	private Party partyOne;
	private Party blankParty;

	@BeforeEach
	void prepare() {
		partyOne = new Party("partyOne");
		blankParty = new Party("blank");
		Set<Party> validParties = new HashSet<>(Arrays.asList(partyOne, blankParty));
		voteCounter = new VoteCounter(validParties);
	}

	@Test
	void catchExceptionOnNullToConstructor() {
		assertThrows(NullPointerException.class,
			   () -> new VoteCounter(null));
	}

	@Test
	void catchExceptionOnCountParty() {
		assertThrows(NullPointerException.class,
			   () -> new VoteCounter(null));
	}

	@Test
	void scrutinizeTest() {
		// note that when testing scrutinize() method we are also testing
		// all the other methods in VoteCounter class:
		// countParty(), countNull(), countBlank(), getVotesFor(), getNulls()
		// and getBlanks()
		// as they are called by scrutinize()

		voteCounter.scrutinize(partyOne);
		assertEquals(1, voteCounter.getVotesFor(partyOne));

		voteCounter.scrutinize(blankParty);
		voteCounter.scrutinize(blankParty);
		assertEquals(2, voteCounter.getBlanks());

		Party nonValidParty = new Party("nonValid");
		voteCounter.scrutinize(nonValidParty);
		assertEquals(1, voteCounter.getNulls());

		assertEquals(4, voteCounter.getTotal());

	}
}
