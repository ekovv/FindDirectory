package com.ekov;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FinderTest {

    @Test
    public void doMain() {
        Finder finder1 = new Finder();
        assertEquals("testFiles/test1File", finder1.doMain(new String[] {"-d", "testFiles", "test1File"}));
        Finder finder2 = new Finder();
        assertEquals("testFiles/test2Directory/test2File", finder2.doMain(new String[] {"-r", "-d", "testFiles", "test2File"}));
        Finder finder3 = new Finder();
        assertEquals("testFiles/test2Directory/test3Directory/test3File", finder3.doMain(new String[] {"-r", "-d", "testFiles", "test3File"}));
    }
}