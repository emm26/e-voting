package kiosk;

import data.Party;

import java.util.Set;

/**
 * A class that represents the result in an election site
 */
public class VoteCounter {
	private Set<Party> validParties;
	private int currentTotalVotes;
	private int blankVotes;
	private int nullVotes;

	public VoteCounter(Set<Party> validParties) throws NullPointerException{
		if (validParties == null){
			throw new NullPointerException();
		}
		this.validParties = validParties;
	}

	private void countParty(Party party) throws NullPointerException{
		if (party == null){
			throw new NullPointerException();
		}
		int partyCurrentVotes = party.getCurrentsVotes();
		party.setCurrentVotes(partyCurrentVotes + 1);
		currentTotalVotes++;
	}

	private void countNull() {
		nullVotes++;
	}

	private void countBlank() {
		blankVotes++;
	}

	public void scrutinize(Party party) {
		if (party == null || !(validParties.contains(party))) {
			nullVotes++;
		}else if (party.getName().equals("blank")) {
			blankVotes++;
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