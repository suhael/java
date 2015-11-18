package com.test.retry;

public class StepRetryPolicy {

    private int maxRetries;
    private int intervalMS;
    private int multiplier;

    public StepRetryPolicy(int maxRetries, int intervalMS) {
        this(maxRetries, intervalMS, 1);
    }

    public StepRetryPolicy(int maxRetries, int intervalMS, int multiplier) {
        if(maxRetries < 0) {
            throw new IllegalArgumentException("maxRetries must be 0 or greater");
        }
        if(intervalMS < 0) {
            throw new IllegalArgumentException("intervalMS must be 0 or greater");
        }
        if(multiplier <= 0) {
            throw new IllegalArgumentException("multiplier must be greater than 0");
        }
        this.maxRetries = maxRetries;
        this.intervalMS = intervalMS;
        this.multiplier = multiplier;
    }

    public int getMaxRetries() {
        return maxRetries;
    }

    public int getIntervalMS() {
        return intervalMS;
    }

    public int getMultiplier() {
        return multiplier;
    }
}