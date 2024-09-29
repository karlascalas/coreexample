package com.core.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

        @Test
    public void test_returns_mr_followed_by_name() {
        String result = App.printGreeString("James");
        assertEquals("MR.James", result);
    }
}
