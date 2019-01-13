package data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailAddressTest {
	private MailAddress mailAddressOne, mailAddressTwo, mailAddressOneCopy;

	@BeforeEach
	void prepare() {
		mailAddressOne = new MailAddress("abc@def.com");
		mailAddressTwo = new MailAddress("def@hij.com");
		mailAddressOneCopy = new MailAddress("abc@def.com");
	}

	@Test
	void getMailAddress() {
		assertEquals("abc@def.com", mailAddressOne.getMailAddress());
		assertEquals("def@hij.com", mailAddressTwo.getMailAddress());
	}

	@Test
	void equalsOnDifferentObjects() {
		assertFalse(mailAddressOne.equals(mailAddressTwo));
	}

	@Test
	void equalsOnDifferentObjectsWithSameMailAddress() {
		assertTrue(mailAddressOne.equals(mailAddressOneCopy));
	}

	@Test
	void toStringTest() {
		assertEquals("MailAddress{mailAddress='abc@def.com'}", mailAddressOne.toString());
		assertEquals("MailAddress{mailAddress='def@hij.com'}", mailAddressTwo.toString());
	}

	@Test
	void catchExceptionOnNullToConstructor() {
		assertThrows(NullPointerException.class,
			   () -> new MailAddress(null));
	}

}