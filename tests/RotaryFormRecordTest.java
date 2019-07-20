package tests;/*
   *************************************************************************************************
   Program: RotaryFormRecordTest.java
   Repository Name: Olalekan AKala
   Date Created: 19-Jul-19
   Program Description:
   *************************************************************************************************
*/

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.IntStream;
//import static org.hamcrest.MatcherAssert.*;
//import static org.hamcrest.Matchers.*;

public class RotaryFormRecordTest extends CommonTest {

    @Test
    public void othersShouldHaveSetterAndGetter() {
        String expected = "bees";
        pestProblem.setOthers(expected);
        record.setOthers(expected);

        assertAll("othersSetterAndGetter",
                () -> assertEquals(expected, pestProblem.getOthers()),
                () -> assertEquals(expected, record.getOthers())
        );
    }

    @Test
    public void pestInfoShouldHaveSetterAndGetter() {
        boolean[] expected = {true, true, false};
        IntStream.range(0, expected.length).forEach(i -> pestProblem.setPestInfo(i, expected[i]));
        IntStream.range(0, expected.length).forEach(i -> record.setPestInfo(i, expected[i]));

        assertAll("pestInfoSetterAndGetter",
                () -> assertArrayEquals(expected, pestProblem.getPestInfo()),
                () -> assertArrayEquals(expected, record.getPestInfo())
        );
    }

    @Test
    public void unitAddressShouldHaveSetterAndGetter() {
        String expected = "";
        assertEquals(-1, record.setUnitAddress(expected),"Input checker not working.");
        expected = "1400-103";
        record.setUnitAddress(expected);
        assertEquals(expected, record.getUnitAddress());
    }

    @Test
    public void keyHomeShouldHaveSetterAndGetter() {
        String expected = "house";
        assertEquals(-1, record.setKeyHome(expected),"Input checker not working.");
        expected = "home";
        record.setKeyHome(expected);
        assertEquals(record.getKeyHome(), expected.toUpperCase());
    }

    @Test
    public void unitAddressShouldHaveSetterAndGetter() {
        String expected = "";
        assertEquals(-1, record.setUnitAddress(expected),"Input checker not working.");
        expected = "1400-103";
        record.setUnitAddress(expected);
        assertEquals(expected, record.getUnitAddress());
}
