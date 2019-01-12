package services;
import data.Nif;
import data.Party;
import data.DigitalSignature;

public interface ElectoralOrganism {

	boolean canVote(Nif nif);

	void disableVoter(Nif nif);

	DigitalSignature askForDigitalSignature(Party party);

}
