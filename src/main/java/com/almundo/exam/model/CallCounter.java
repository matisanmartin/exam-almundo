package com.almundo.exam.model;

import org.springframework.stereotype.Component;

@Component
public class CallCounter {

    private Integer count = 0;
    Object lockObject = new Object();

    public void increment() {
        synchronized (lockObject) {
            count++;
        }
    }

    public void decrement() {
        synchronized (lockObject) {
            count--;
        }
    }

    public int count() {
        synchronized (lockObject) {
            return count;
        }

    }
}
