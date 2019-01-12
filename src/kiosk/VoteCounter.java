package kiosk;
import data.Party;
import java.util.*;

/**
 * A class that represents the result in an election site
 */
public class VoteCounter {
	private Set<Party> validParties;
	private int currentVotes;

	public VoteCounter(Set<Party> validParties) throws NullPointerException{
		if (validParties == null){
			throw new NullPointerException();
		}
		this.validParties = validParties;
	}

	public void countParty(Party party) {

	}

	public void countNull() {

	}

	public void countBlank() {

	}

	public void scrutinize(Party party) {

	}

	public int getVotesFor(Party party) {

	}

	public int getNulls() {

	}

	public int getBlanks() {

	}

	public int getTotal() {

	}
}