package data;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DigitalSignatureTest {
    private DigitalSignature digitalSigOne, digitalSigTwo, digitalSigOneCopy;
    byte[] byteArrayOne, byteArrayTwo;

    @BeforeAll
    void prepare(){
        byteArrayOne = "First".getBytes();
        byteArrayTwo = "Second".getBytes();
        digitalSigOne = new DigitalSignature(byteArrayOne);
        digitalSigTwo = new DigitalSignature(byteArrayTwo);
        digitalSigOneCopy = new DigitalSignature(byteArrayOne);
    }

    @Test
    void getDigitalSignature() {
        assertEquals(byteArrayOne, digitalSigOne.getDigitalSignature());
        assertEquals(byteArrayTwo, digitalSigTwo.getDigitalSignature());
    }

    @Test
    void equalsOnDifferentObjects() {
        assertFalse(digitalSigOne.equals(digitalSigTwo));
    }

    @Test
    void equalsOnDifferentObjectsWithSameDigitalSignature() {
        assertTrue(digitalSigOne.equals(digitalSigOneCopy));
    }

    @Test
    String toStringTest(){
        assertEquals("DigitalSignature{digitalsignature="+ Arrays.toString(byteArrayOne)+"}", digitalSigOne.toString());
        assertEquals("DigitalSignature{digitalsignature="+ Arrays.toString(byteArrayTwo)+"}", digitalSigTwo.toString());
    }
}