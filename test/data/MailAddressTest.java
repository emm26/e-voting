package data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailAddressTest {
	private MailAddress m, m1, msame;

	@BeforeEach
	void prepare() {
		m = new MailAddress("abc@def.com");
		m1 = new MailAddress("def@hij.com");
		msame = new MailAddress("abc@def.com");
	}

	@Test
	void getMailAddress() {
		assertEquals("abc@def.com", m.getMailAddress());
		assertEquals("def@hij.com", m1.getMailAddress());
	}

	@Test
	void equalsDiferentObject() {
		assertFalse(m.equals(m1));
	}

	@Test
	void equalsDiferentObjectSameMailAddress() {
		assertTrue(m.equals(msame));
	}

	@Test
	void toStringProperOutput() {
		assertEquals("MailAddress{mailAddress='abc@def.com'}", m.toString());
		assertEquals("MailAddress{mailAddress='def@hij.com'}", m1.toString());
	}

	@Test
	void catchExceptionOnNullToConstructor(){
		Throwable exception = assertThrows(NullPointerException.class,
			   () -> {
				   new MailAddress(null);
			   });
	}

}