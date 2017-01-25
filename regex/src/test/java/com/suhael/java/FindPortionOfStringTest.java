package com.suhael.java;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FindPortionOfStringTest {

    private FindPortionOfString findPortionOfString;

    @Before
    public void setup() {
        findPortionOfString = new FindPortionOfString();
    }

    @Test
    public void test() {
        String input = "The user may have already registered with the email (Internal Code: 5000-0).";
        String expected = "5000-0";
        String result = findPortionOfString.returnMatchingString(input);

        assertThat(result, is(expected));
    }

    @Test
    public void test2() {
        String input = "The user may have already registered with the email (Internal Code: 5000-01).";
        String expected = "5000-01";
        String result = findPortionOfString.returnMatchingString(input);

        assertThat(result, is(expected));
    }

    @Test
    public void test3() {
        String input = "The user may have already registered with the email.";
        String expected = "";
        String result = findPortionOfString.returnMatchingString(input);

        assertThat(result, is(expected));
    }

}