package com.test.retry;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sakhtar on 02/09/2015.
 */
public class Run {

    private static int COUNTER = 0;
    final List<String> fruits = Arrays.asList("apple", "orange", "banana");

    public void retry() throws Throwable {
        String result = new StepRetry(StepRetryPolicyFactory.STANDARD,
                String.format("Check fruits (%s) contains %s", fruits, "banana"),
                new Step<String>() {
                    @Override
                    public String run() throws Throwable {
                        String fruit = fruits.get(COUNTER);
                        COUNTER++;
                        System.out.printf("getting fruit for counter %d \r", COUNTER);
                        return fruit;
                    }

                    @Override
                    public boolean shouldRetry(String fruit) {
                        return !fruit.equalsIgnoreCase("banana");
                    }
                }).run();
        System.out.println("Found fruit " + result + " at counter " + COUNTER);
    }

    public static void main(String[] args) {
        Run run = new Run();
        try {
            run.retry();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
