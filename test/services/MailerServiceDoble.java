package services;

import data.Party;
import data.DigitalSignature;
import data.MailAddress;
import data.Nif;
import kiosk.VotingKiosk;
import kiosk.VotingRightsFailedException;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MailerServiceDoble implements MailerService{

	private MailAddress addressDestination;
	private DigitalSignature digitalSignature;

	@Override
	public void send(MailAddress address, DigitalSignature signature) throws NullPointerException{
		mayThrowNullPointerException(address);
		mayThrowNullPointerException(signature);
		// to do
		this.addressDestination = address;
		this.digitalSignature = signature;
	}

	public void mayThrowNullPointerException(Object o) throws NullPointerException{
		if (o == null){
			throw new NullPointerException();
		}
	}

	@Test
	void addressIsNull() {
		Party testParty = new Party("test");
		assertThrows(NullPointerException.class,
			   () -> send(null, new DigitalSignature(testParty.getName().getBytes())));
	}

	@Test
	void successfulSend() throws VotingRightsFailedException {
		Nif testNif = new Nif("12345678A");
		MailAddress testAddress = new MailAddress("abc@def.com");
		Party testParty = new Party("PartyOne");
		VotingKiosk votingKiosk = new VotingKiosk();

		votingKiosk.votingProcess(testNif, testAddress, testParty, true);

		assertEquals("abc@def.com", this.addressDestination);
		assertEquals();
	}
}
