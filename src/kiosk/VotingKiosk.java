package kiosk;


import data.Party;
import data.MailAddress;

import services.ElectoralOrganism;
import services.MailerService;

import java.util.Set;

public class VotingKiosk{

	private ElectoralOrganism eO;
	private MailerService mService;
	private Set<Party> parties;
	private VoteCounter voteCounter;

	public VotingKiosk() {
		this.voteCounter = new VoteCounter(parties);
	}

	public void setElectoralOrganism(ElectoralOrganism eO) throws NullPointerException{
		mayThrowNullPointerException(eO);
		this.eO = eO;
	}

	public void setMailerService(MailerService mService) throws NullPointerException{
		mayThrowNullPointerException(mService);
		this.mService = mService;
	}

	public void vote(Party party) throws NullPointerException{
		mayThrowNullPointerException(party);
		voteCounter.countParty(party);
	}

	public void sendReceipt(MailAddress address) throws NullPointerException{
		mayThrowNullPointerException(address);
	}

	public void mayThrowNullPointerException(Object o) throws NullPointerException{
		if (o == null){
			throw new NullPointerException();
		}
	}
}
