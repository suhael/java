package com.test.retry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StepRetry {
    private Step step;
    private StepRetryPolicy stepRetryPolicy;
    private int retryCount;
    private int currentIntervalMS;
    private String operation;
    private final static Logger log = LoggerFactory.getLogger(StepRetry.class);

    public StepRetry(StepRetryPolicy stepRetryPolicy, String operation, Step step) {
        this.stepRetryPolicy = stepRetryPolicy;
        this.step = step;
        this.retryCount = 0;
        this.currentIntervalMS = stepRetryPolicy.getIntervalMS();
        this.operation = operation;
    }

    public <T> T run() throws Throwable {
        T result = (T)step.run();
        boolean shouldRetry;

        while((shouldRetry = step.shouldRetry(result)) && retryCount <= stepRetryPolicy.getMaxRetries()) {
            incrementRetryCountAndSleep();
            result = (T)step.run();
        }

        log.info("Operation '{}' {}. Number of retries= {} of {}", operation, shouldRetry ? "FAILED" : "SUCCEEDED", retryCount, stepRetryPolicy.getMaxRetries());

        return result;
    }

    private void incrementRetryCountAndSleep() {
        retryCount++;
        try {
            log.debug("Operation '{}' must be retried. Number of retries= {} of {}, retrying in {} milliseconds", operation, retryCount, stepRetryPolicy.getMaxRetries(), currentIntervalMS);
            Thread.sleep(currentIntervalMS);
            currentIntervalMS *= stepRetryPolicy.getMultiplier();
        }
        catch(InterruptedException ie) {
            log.warn("InterruptedException caught on step retry operation, coninuing");
        }
    }
}
