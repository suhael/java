package com.test.retry;

public interface Step<T> {
    T run() throws Throwable;
    boolean shouldRetry(T o);
}
