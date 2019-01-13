package services;

import data.DigitalSignature;
import data.Nif;
import data.Party;

public class ElectoralOrganismDoble implements ElectoralOrganism {

	boolean canVoteNif;
	Nif voterNif;

	public ElectoralOrganismDoble() {
		canVoteNif = true;
		voterNif = new Nif("");
	}

	public Nif getVoterNif() {
		return voterNif;
	}

	public Boolean getCanVoteNif() {
		return canVoteNif;
	}

	@Override
	public boolean canVote(Nif nif) throws NullPointerException {
		mayThrowNullPointerException(nif);
		voterNif = nif;
		return !(nif.getNif().equals("00000000A"));
	}

	@Override
	public void disableVoter(Nif nif) throws NullPointerException {
		mayThrowNullPointerException(nif);
		canVoteNif = false;
	}

	@Override
	public DigitalSignature askForDigitalSignature(Party party) throws NullPointerException {
		mayThrowNullPointerException(party);
		return new DigitalSignature(party.getName().getBytes());
	}

	public void mayThrowNullPointerException(Object o) throws NullPointerException {
		if (o == null) {
			throw new NullPointerException();
		}
	}

}
