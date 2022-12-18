package com.example.ip;

import com.example.ip.tasks.Task;

import java.util.Arrays;
import java.util.List;

public class TaskHandler<T extends Task> {
    public List<T> tasks;
    public int counter;
    public double percentage;

    public TaskHandler(List<T> tasks){
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return Arrays.asList(tasks).toString();
    }

    //    public double calculatePercentage(){
//
//    }
}
