package services;

import data.DigitalSignature;
import data.Nif;
import data.Party;
import org.junit.jupiter.api.Test;

public class ElectoralOrganismDoble implements ElectoralOrganism {

	@Override
	public boolean canVote(Nif nif) throws NullPointerException{
		mayThrowNullPointerException(nif);
		// to do
		return false;
	}

	@Override
	public void disableVoter(Nif nif) throws NullPointerException{
		mayThrowNullPointerException(nif);
		// to do

	}

	@Override
	public DigitalSignature askForDigitalSignature(Party party) throws NullPointerException{
		mayThrowNullPointerException(party);
		// to do
		return new DigitalSignature(party.getName().getBytes());
	}

	public void mayThrowNullPointerException(Object o) throws NullPointerException{
		if (o == null){
			throw new NullPointerException();
		}
	}

	@Test
	void name() {

	}


}
