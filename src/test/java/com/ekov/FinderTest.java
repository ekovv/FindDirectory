package com.ekov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FinderTest {

    @Test

    public void doMain() {
        Finder finder = new Finder();
        assertEquals("/Users/dmitrydenisov/Desktop/mogo/js/app.js", finder.doMain(new String[] {"-r", "-d", "/Users/dmitrydenisov/Desktop/mogo", "app.js"}));
    }
}