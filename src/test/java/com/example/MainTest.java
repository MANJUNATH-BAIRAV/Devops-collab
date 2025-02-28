package com.example; 
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MainTest {
    @Test
    public void testGreet() {
        Main main = new Main();
        assertEquals("Hello, Jenkins!", main.greet());
    }
}
