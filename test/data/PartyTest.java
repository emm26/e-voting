package data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartyTest {
    private Party p, p1, psame;
    @BeforeEach
    void prepare(){
        p = new Party("ABC");
        p1 = new Party("DEF");
        psame = new Party("ABC");
    }
    @Test
    void getName() {
        assertEquals("ABC", p.getName());
        assertEquals("DEF", p1.getName());
    }

    @Test
    void equalsDiferentObject() {
        assertFalse(p.equals(p1));
    }
    @Test
    void equalsDiferentObjectSamePartyName() {
        assertTrue(p.equals(psame));
    }
    @Test
    void toStringProperOutput(){
        assertEquals("Party{name='ABC'}", p.toString());
        assertEquals("Party{name='DEF'}", p1.toString());
    }
}