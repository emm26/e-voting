package kiosk;

import data.Party;

import java.util.Set;

/**
 * A class that represents the result in an election site
 */
public class VoteCounter {
	private Set<Party> validParties;
	private int currentTotalVotes = 0;
	private int blankVotes = 0;
	private int nullVotes = 0;

	public VoteCounter(Set<Party> validParties) throws NullPointerException{
		if (validParties == null){
			throw new NullPointerException("VoteCounter constructor received null object");
		}
		this.validParties = validParties;
	}

	private void countParty(Party party) throws NullPointerException{
		if (party == null){
			throw new NullPointerException();
		}
		int partyCurrentVotes = party.getCurrentsVotes();
		party.setCurrentVotes(partyCurrentVotes + 1);
	}

	private void countNull() {
		nullVotes++;
	}

	private void countBlank() {
		blankVotes++;
	}

	public void scrutinize(Party party) {
		if (party == null || !(validParties.contains(party))) {
			countNull();
		}else if (party.getName().equals("blank")) {
			countBlank();
		} else {
			countParty(party);
		}
		currentTotalVotes++;
	}

	public int getVotesFor(Party party) {
		return party.getCurrentsVotes();
	}

	public int getNulls() {
		return nullVotes;
	}

	public int getBlanks() {
		return blankVotes;
	}

	public int getTotal() {
		return currentTotalVotes;
	}
}