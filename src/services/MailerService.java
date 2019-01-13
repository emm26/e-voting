package services;

import data.DigitalSignature;
import data.MailAddress;

public interface MailerService {
	void send(MailAddress address, DigitalSignature signature);
}
