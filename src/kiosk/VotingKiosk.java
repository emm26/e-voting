package kiosk;


import data.MailAddress;
import data.Nif;
import data.Party;
import services.ElectoralOrganism;
import services.MailerService;

import java.util.HashSet;
import java.util.Set;

public class VotingKiosk{

	private ElectoralOrganism eO;
	private MailerService mService;
	private Set<Party> parties;
	private VoteCounter voteCounter;

	public VotingKiosk() {
		this.parties = new HashSet<>();
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

	public void votingProcess(Nif nif, MailAddress mailAddress, Party party, boolean wantsSignedReceipt) throws VotingRightsFailedException{
		mayThrowNullPointerException(nif);
		mayThrowNullPointerException(mailAddress);
		mayThrowNullPointerException(party);
		mayThrowNullPointerException(wantsSignedReceipt);

		if (eO.canVote(nif)){
			//voteCounter.scrutinize(party);
			vote(party);
			eO.disableVoter(nif);
			if (wantsSignedReceipt){
				sendReceipt(mailAddress, party);
			}
		}else{
			throw new VotingRightsFailedException("Cannot vote");
		}
	}

	public void vote(Party party) throws NullPointerException{
		mayThrowNullPointerException(party);
		voteCounter.scrutinize(party);
	}

	public void sendReceipt(MailAddress address, Party party) throws NullPointerException{
		mayThrowNullPointerException(address);
		mService.send(address, eO.askForDigitalSignature(party));
	}

	public void mayThrowNullPointerException(Object o) throws NullPointerException{
		if (o == null){
			throw new NullPointerException();
		}
	}
}
