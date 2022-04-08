package com.d.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StringHelperTest {

    //test cases
    //- "ABCD" => "BCD", "AACD"=> "CD", "BACD"=>"BCD", "AAAA" => "AA", "MNAA"=>"MNAA"
    //extra cases
    // "", "A", "B", "BC"
    StringHelper helper = new StringHelper();

    @Test
    void replaceAInFirst2Positions_testWithAinFirstPosition() {
        String actual = helper.replaceAInFirst2Positions("ABCD");
        assertEquals("BCD", actual);
    }

    @Test
    void replaceAInFirst2Positions_testWithAinFirstTwoPosition() {
        String actual = helper.replaceAInFirst2Positions("AACD");
        assertEquals("CD", actual);
    }

    @Test
    void replaceAInFirst2Positions_testWithAinSecondPosition() {
        String actual = helper.replaceAInFirst2Positions("BACD");
        assertEquals("BCD", actual);
    }

    @Test
    void replaceAInFirst2Positions_testWithAinAllPositions() {
        String actual = helper.replaceAInFirst2Positions("AAAA");
        assertEquals("AA", actual);
    }

    @Test
    void replaceAInFirst2Positions_testWithAinTwoLastPositions() {
        String actual = helper.replaceAInFirst2Positions("MNAA");
        assertEquals("MNAA", actual);
    }

    @Test
    void replaceAInFirst2Positions_testWithEmptyString() {
        String actual = helper.replaceAInFirst2Positions("");
        assertEquals("", actual);
    }

    @Test
    void replaceAInFirst2Positions_testWithOnlyOneA() {
        String actual = helper.replaceAInFirst2Positions("A");
        assertEquals("", actual);
    }

    @Test
    void replaceAInFirst2Positions_testWithOnlyOneB() {
        String actual = helper.replaceAInFirst2Positions("B");
        assertEquals("B", actual);
    }

    @Test
    void replaceAInFirst2Positions_testWithTwoLettersNoA() {
        String actual = helper.replaceAInFirst2Positions("BC");
        assertEquals("BC", actual);
    }

    //test cases 
    //- ""=>false, "A"=>false, "AB"=>true, "ABC"=>false, "AAA"=>true, "ABCAB"=>true, "ABCDEBA"=>false
    @Test
    void testareFirstTwoAndLastTwoCharsTheSame() {
        assertFalse(helper.areFirstTwoAndLastTwoCharsTheSame(""));
        assertFalse(helper.areFirstTwoAndLastTwoCharsTheSame("A"));
        assertTrue(helper.areFirstTwoAndLastTwoCharsTheSame("AB"));
        assertFalse(helper.areFirstTwoAndLastTwoCharsTheSame("ABC"));
        assertTrue(helper.areFirstTwoAndLastTwoCharsTheSame("AAA"));
        assertTrue(helper.areFirstTwoAndLastTwoCharsTheSame("ABCAB"));
        assertFalse(helper.areFirstTwoAndLastTwoCharsTheSame("ABCDEBA"));

    }

}
