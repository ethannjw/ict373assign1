import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagazineTest {

    private Magazine mag;
    @BeforeEach
    void setUp() {
        mag = new Magazine("Programming Magazine", 12.20);
    }

    @Test
    void getMagId() {

    }

    @Test
    void getMagName() {
        assertEquals("Programming Magazine", mag.getMagName());
    }

    @Test
    void setMagName() {
        mag.setMagName("Testing");
        assertEquals("Testing", mag.getMagName());
    }

    @Test
    void getMagEmailContent() {

    }

    @Test
    void setMagEmailContent() {
    }

    @Test
    void setMagWeeklyCost() {
        mag.setMagWeeklyCost(200.05);
        assertEquals(200.05, mag.getMagWeeklyCost());
    }

    @Test
    void getMagWeeklyCost() {
        assertEquals(12.20, mag.getMagWeeklyCost());
    }

    @Test
    void testToString() {
        String testStr = "Magazine: \n" +
                "magazine ID: 1\n" +
                "magazine Name: Programming Magazine\n" +
                "magezine Email Content: null\n" +
                "magazine Weekly Cost: $12.2\n" +
                "Customers: \n";
        assertEquals(testStr, mag.toString());
    }

    @Test
    void testEquals() {
        Magazine testMag = new Magazine("Programming Magazine", 12.20);
        assertTrue(testMag.equals(mag));

    }

}