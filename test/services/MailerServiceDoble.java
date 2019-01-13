package services;

import data.DigitalSignature;
import data.MailAddress;

public class MailerServiceDoble implements MailerService{

	private MailAddress addressDestination;
	private DigitalSignature digitalSignature;

	public MailerServiceDoble(){
		this.addressDestination = null;
		this.digitalSignature = null;
	}

	@Override
	public void send(MailAddress address, DigitalSignature signature) throws NullPointerException{
		mayThrowNullPointerException(address);
		mayThrowNullPointerException(signature);
		this.addressDestination = address;
		this.digitalSignature = signature;
	}


	public MailAddress getAddressDestination(){
		return addressDestination;
	}

	public DigitalSignature getDigitalSignature(){
		return digitalSignature;
	}

	public void mayThrowNullPointerException(Object o) throws NullPointerException{
		if (o == null){
			throw new NullPointerException();
		}
	}

}
