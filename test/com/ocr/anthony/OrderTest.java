package com.ocr.anthony;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class OrderTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    Order order = new Order();

    @Test
    public void Given_Nothing_When_DisplayMenuSelection_Then_ShouldDisplayText() {
        order.displayAvailableMenu();
        assertEquals(false, outContent.toString().isEmpty());
    }
    @Test
    public void Given_Vegetables_When_AskForMenuSelected_Then_ShouldDisplayCorrectSentence() {
        order.displaySelectedMenu(3);
        assertEquals("Vous avez choisi le menu 3\n", outContent.toString());
    }
}