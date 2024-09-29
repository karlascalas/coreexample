package com.core.example.thread;



import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class VirtualThreadTest {
    private VirtualThread MakeVirtualThread() {
        return new VirtualThread();
    }

    @Test
    public void Main_CreatesAndJoinsVirtualThread_PrintsIndex() {
        VirtualThread app = MakeVirtualThread();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Act: invoking the entry point
        String[] args = {};
        VirtualThread.main(args);

        // Assert: state-based check
        System.setOut(originalOut);
        String output = outputStream.toString();
        for (int i = 0; i < 10; i++) {
            assertTrue(output.contains("Index: " + i));
        }
    }

    @Test
    public void ThreadExample01_CreatesAndJoinsVirtualThread_PrintsMessages() {
        VirtualThread app = MakeVirtualThread();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Act: invoking the entry point
        app.threadExmple_01();

        // Assert: state-based check
        System.setOut(originalOut);
        String output = outputStream.toString();
        assertTrue(output.contains("Hello from virtual thread!"));
        assertTrue(output.contains("Main thread finished."));
    }
}


