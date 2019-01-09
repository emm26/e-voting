package data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DigitalSignatureTest {
    private DigitalSignature d, d1, dsame;
    byte[] a, b, c;

    @BeforeEach
    void prepare(){
        a = "First".getBytes();
        b = "Second".getBytes();
        c = "First".getBytes();
        d = new DigitalSignature(a);
        d1 = new DigitalSignature(b);
        dsame = new DigitalSignature(c);
    }

    @Test
    void getDigitalSignature() {
        assertEquals(a, d.getDigitalSignature());
        assertEquals(b, d1.getDigitalSignature());
    }

    @Test
    void equalsOnDifferentObjects() {
        assertFalse(d.equals(d1));
    }

    @Test
    void equalsOnDifferentObjectsWithSameDigitalSignature() {
        assertTrue(d.equals(dsame));
    }

    @Test
    void toString(){
        assertEquals("DigitalSignature{digitalsignature="+ Arrays.toString(a)+"}", d.toString());
        assertEquals("DigitalSignature{digitalsignature="+ Arrays.toString(b)+"}", d1.toString());
    }
}