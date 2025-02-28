package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class MainTest {
    private Main main;

    @Before // This runs before each test
    public void setUp() {
        main = new Main();
    }

    @Test
    public void testGreet() {
        assertEquals("Hello, Jenkins!", main.greet());
    }
}
