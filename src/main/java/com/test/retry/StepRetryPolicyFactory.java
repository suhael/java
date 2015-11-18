package com.test.retry;

public final class StepRetryPolicyFactory {

    public static final StepRetryPolicy STANDARD = new StepRetryPolicy(5, 500, 2);

    private StepRetryPolicyFactory() {
    }
}