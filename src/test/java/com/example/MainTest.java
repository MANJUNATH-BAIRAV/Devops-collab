package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class MainTest {

    @Test
    void testMainOutput() {
        // Capture system output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Run main method
        Main.main(new String[]{});

        // Restore system output
        System.setOut(originalOut);

        // Verify output
        String expectedOutput = "Hello, World!" + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString(), "Main method output should match");
    }
}
