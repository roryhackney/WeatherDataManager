import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UtilityTest {

    @Test
    public void test_verifyNotNullOrBlank() {
        String test = null;
        assertThrows(IllegalArgumentException.class, () ->
                Utility.verifyNotNullOrBlank("test", test));
        String s = "";
        assertThrows(IllegalArgumentException.class, () ->
                Utility.verifyNotNullOrBlank("s", s));
    }

    @Test
    public void test_double_verifyInRange() {
        double d = 64.2;
        Utility.verifyInRange(1, 100, "d", d);
        assertThrows(IllegalArgumentException.class, () ->
                Utility.verifyInRange(70, 100, "d", d));
        assertThrows(IllegalArgumentException.class, () ->
                Utility.verifyInRange(1, 60, "d", d));
    }

    @Test
    public void test_int_verifyInRange() {
        int i = 64;
        Utility.verifyInRange(1, 100, "i", i);
        assertThrows(IllegalArgumentException.class, () ->
                Utility.verifyInRange(70, 100, "i", i));
        assertThrows(IllegalArgumentException.class, () ->
                Utility.verifyInRange(1, 60, "i", i));
    }

}