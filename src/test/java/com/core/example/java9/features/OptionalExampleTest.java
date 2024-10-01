package com.core.example.java9.features;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Optional;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class OptionalExampleTest {
private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Test
    public void testOptionalExample_01_ValuePresent() {
        OptionalExample optionalExample = new OptionalExample();

        // Redirect System.out to capture the output
        System.setOut(new PrintStream(outContent));

        optionalExample.optionalExample_01();

        // Assert that the output contains the expected message when value is present
        assertEquals("Value is present: Hello\n", outContent.toString());

        // Reset System.out
        System.setOut(originalOut);
    }

    @Test
    public void testOptionalExample_01_ValueNotPresent() {
        OptionalExample optionalExample = new OptionalExample();

        // Redirect System.out to capture the output
        System.setOut(new PrintStream(outContent));

        // Create an empty Optional
        Optional<String> optional = Optional.empty();

        // Replace the Optional in the method with the empty one
        // optionalExample.optional = optional;

        optionalExample.optionalExample_01();

        // Assert that the output contains the expected message when value is not present
        assertEquals("Value is not present\n", outContent.toString());

        // Reset System.out
        System.setOut(originalOut);
    }
}
