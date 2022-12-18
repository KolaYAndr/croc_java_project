package com.example.ip;

import java.util.HashSet;

public class User {
    public String name;
    private double overallProgress;
    private HashSet<Integer> doneTasks = new HashSet<>();


    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void increaseOverallProgress(int i) {
        if (!doneTasks.contains(i)) {
            doneTasks.add(i);
            overallProgress += .33;
        }
    }
}
