package services;

import data.DigitalSignature;
import data.Nif;
import data.Party;

public class ElectoralOrganismDoble implements ElectoralOrganism {


	@Override
	public boolean canVote(Nif nif) {
		mayThrowNullPointerException(nif);
		// to do

	}

	@Override
	public void disableVoter(Nif nif) {
		mayThrowNullPointerException(nif);
		// to do

	}

	@Override
	public DigitalSignature askForDigitalSignature(Party party) {
		mayThrowNullPointerException(party);
		// to do

	}

	public void mayThrowNullPointerException(Object o) throws NullPointerException{
		if (o == null){
			throw new NullPointerException();
		}
	}

}
