package com.example.demo_count.model;

public class Counter {
    private int count = 0;

    public Counter() {
    }

    public Counter(int count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int increment() {
        return count++;
    }
}
