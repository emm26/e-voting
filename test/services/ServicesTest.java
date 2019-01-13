package services;

import data.DigitalSignature;
import data.MailAddress;
import data.Nif;
import data.Party;
import kiosk.VotingKiosk;
import kiosk.VotingRightsFailedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ServicesTest {
	ElectoralOrganismDoble electoralOrganism;
	MailerServiceDoble mailerServiceDoble;

	@BeforeEach
	void prepare() {
		electoralOrganism = new ElectoralOrganismDoble();
		mailerServiceDoble = new MailerServiceDoble();
	}

	@Test
	void addressIsNull() throws NullPointerException {
		Party testParty = new Party("test");

		assertThrows(NullPointerException.class,
			   () -> mailerServiceDoble.send(null, new DigitalSignature(testParty.getName().getBytes())));
	}

	// mailer service tests

	@Test
	void checkMailAddressAndDigitalSignatureOnWantingReceipt() throws VotingRightsFailedException, NullPointerException {
		Nif testNif = new Nif("12345678A");
		MailAddress testAddress = new MailAddress("abc@def.com");
		Party testParty = new Party("PartyOne");
		VotingKiosk votingKiosk = new VotingKiosk();

		votingKiosk.setMailerService(mailerServiceDoble);
		votingKiosk.setElectoralOrganism(electoralOrganism);

		votingKiosk.votingProcess(testNif, testAddress, testParty, true);

		assertEquals(new MailAddress("abc@def.com"), mailerServiceDoble.getAddressDestination());
		assertEquals(electoralOrganism.askForDigitalSignature(testParty), mailerServiceDoble.getDigitalSignature());
	}

	// electoral organism tests

	@Test
	void checkCannotVoteException() throws VotingRightsFailedException, NullPointerException {
		Nif testNif = new Nif("00000000A");
		MailAddress testAddress = new MailAddress("abc@def.com");
		Party testParty = new Party("PartyOne");
		VotingKiosk votingKiosk = new VotingKiosk();

		votingKiosk.setMailerService(mailerServiceDoble);
		votingKiosk.setElectoralOrganism(electoralOrganism);

		assertThrows(VotingRightsFailedException.class,
			   () -> votingKiosk.votingProcess(testNif, testAddress, testParty, true));
		assertEquals(new Nif("00000000A"),electoralOrganism.getVoterNif());
	}

	@Test
	void checkDisabledVotingRightsAfterVoting() throws VotingRightsFailedException {
		Nif testNif = new Nif("00000001A");
		MailAddress testAddress = new MailAddress("abc@def.com");
		Party testParty = new Party("PartyOne");
		VotingKiosk votingKiosk = new VotingKiosk();

		votingKiosk.setMailerService(mailerServiceDoble);
		votingKiosk.setElectoralOrganism(electoralOrganism);

		votingKiosk.votingProcess(testNif, testAddress, testParty, false);

		assertEquals(new Nif("00000001A"),electoralOrganism.getVoterNif());
		assertFalse(electoralOrganism.getCanVoteNif());
	}


}
