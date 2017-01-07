package com.suhael.java8.streams;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class FiltersNumbers {

    public List<Integer> filterAndMapTwoEvenSquares(List<Integer> numbers) {
        List<Integer> twoEvenSquares =
                numbers.stream()
                        .filter(n -> {
                            System.out.println("filtering " + n);
                            return n % 2 == 0;
                        })
                        .map(n -> {
                            System.out.println("mapping " + n);
                            return n * n;
                        })
                        .limit(2)
                        .collect(toList());

        return twoEvenSquares;
    }

    public List<Integer> mapNumbers(List<Integer> numbers) {
        List<Integer> mapNumbers =
                numbers.stream()
                        .map(n -> {
                            return 1;
                        })
                        .collect(toList());

        return mapNumbers;
    }
}
