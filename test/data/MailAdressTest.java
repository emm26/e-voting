package data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailAdressTest {
    private MailAdress m, m1, msame;
    @BeforeEach
    void prepare(){
        m = new MailAdress("abc@def.com");
        m1 = new MailAdress("def@hij.com");
        msame = new MailAdress("abc@def.com");
    }
    @Test
    void getMailAdress() {
        assertEquals("abc@def.com", m.getMailAdress());
        assertEquals("def@hij.com", m1.getMailAdress());
    }

    @Test
    void equalsDiferentObject() {
        assertFalse(m.equals(m1));
    }
    @Test
    void equalsDiferentObjectSameMailAdress() {
        assertTrue(m.equals(msame));
    }
    @Test
    void toStringProperOutput(){
        assertEquals("MailAdress{mailAdress='abc@def.com'}", m.toString());
        assertEquals("MailAdress{mailAdress='def@hij.com'}", m1.toString());
    }

}