package com.suhael.java8.streams;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class FiltersNumbersTest {

    private FiltersNumbers filtersNumbers;
    private static List<Integer> NUMBER_LIST = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

    @Before
    public void setup() {
        filtersNumbers = new FiltersNumbers();
    }

    @Test
    public void testFilterAndMapTwoEvenSquares() throws Exception {

        List<Integer> sortedNumbers = filtersNumbers.filterAndMapTwoEvenSquares(NUMBER_LIST);

        System.out.println(sortedNumbers);
    }


    @Test
    public void testMap() throws Exception {

        List<Integer> sortedNumbers = filtersNumbers.mapNumbers(NUMBER_LIST);

        System.out.println(sortedNumbers);
    }

}