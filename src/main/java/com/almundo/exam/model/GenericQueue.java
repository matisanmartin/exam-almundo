package com.almundo.exam.model;

import java.util.LinkedList;
import java.util.Queue;

public class GenericQueue<T extends Employee> {

    private Queue<T> queue = new LinkedList<>();

    public void add(T element) {
        queue.add(element);
    }

    public T remove() {
        return queue.remove();
    }

    public Boolean isEmpty() {
        return queue.isEmpty();
    }
}
