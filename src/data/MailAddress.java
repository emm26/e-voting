package data;

import java.util.Objects;

final public class MailAddress {
	private final String mailAddress;

	public MailAddress(String mailAddress) throws NullPointerException {
		if (mailAddress == null) {
			throw new NullPointerException("MailAddress constructor received null object");
		}
		this.mailAddress = mailAddress;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MailAddress that = (MailAddress) o;
		return Objects.equals(mailAddress, that.mailAddress);
	}

	@Override
	public int hashCode() {
		return Objects.hash(mailAddress);
	}

	@Override
	public String toString() {
		return "MailAddress{" +
			   "mailAddress='" + mailAddress + '\'' +
			   '}';
	}
}
