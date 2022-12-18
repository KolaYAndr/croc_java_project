package com.example.ip;

import com.example.ip.tasks.Task;

public interface ReceiveFromFragment {

    void receive(String str);
    void receive(int i, TaskHandler<? extends Task> taskHandler, int index);
}
