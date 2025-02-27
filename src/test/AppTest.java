import static org.junit.Assert.*;
import org.junit.Test;

public class AppTest {
    @Test
    public void testSquare() {
        assertEquals(25, App.square(5));
        assertEquals(4, App.square(2));
        assertEquals(0, App.square(0));
    }
}