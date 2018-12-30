package data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NifTest {
    private Nif n, n1, nsame;
    @BeforeEach
    void prepare(){
        n = new Nif("123456789A");
        n1 = new Nif("987654321A");
        nsame = new Nif("123456789A");
    }
    @Test
    void getNif() {
        assertEquals("123456789A", n.getNif());
        assertEquals("987654321A", n1.getNif());
    }

    @Test
    void equalsDiferentObject() {
        assertFalse(n.equals(n1));
    }
    @Test
    void equalsDiferentObjectSameNif() {
        assertTrue(n.equals(nsame));
    }
    @Test
    void toStringProperOutput(){
        assertEquals("Nif{nif='123456789A'}", n.toString());
        assertEquals("Nif{nif='987654321A'}", n1.toString());
    }

}