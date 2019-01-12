package services;

import data.DigitalSignature;
import data.MailAddress;

public class MailerServiceDoble implements MailerService{

	@Override
	public void send(MailAddress address, DigitalSignature signature) {
		mayThrowNullPointerException(address);
		mayThrowNullPointerException(signature);
		// to do

	}

	public void mayThrowNullPointerException(Object o) throws NullPointerException{
		if (o == null){
			throw new NullPointerException();
		}
	}

}
