package com.example.ip.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ip.R;
import com.example.ip.ReceiveFromFragment;
import com.example.ip.TaskCreator;
import com.example.ip.TaskHandler;
import com.example.ip.tasks.ChooseTask;
import com.example.ip.tasks.TranslationTask;
import com.example.ip.tasks.VoiceTask;

public class TasksPathFragment extends Fragment {

    public TasksPathFragment() {
        super(R.layout.tasks_path_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button firstTask = (Button) requireView().findViewById(R.id.firstTask);
        Button secondTask = (Button) requireView().findViewById(R.id.secondTask);
        Button thirdTask = (Button) requireView().findViewById(R.id.thirdTask);

        firstTask.setOnClickListener(v -> {
            TaskHandler<VoiceTask> voiceTaskHandler = initVoicesTask();
            ((ReceiveFromFragment) requireActivity()).receive(0, voiceTaskHandler, 0);
        });

        secondTask.setOnClickListener(v -> {
            TaskHandler<TranslationTask> translationTaskHandler = initTranslationsTask();
            ((ReceiveFromFragment) requireActivity()).receive(1, translationTaskHandler, 0);
        });

        thirdTask.setOnClickListener(v -> {
            TaskHandler<ChooseTask> chooseTaskHandler = initChooseTask();
            ((ReceiveFromFragment) requireActivity()).receive(2, chooseTaskHandler, 0);
        });
    }

    private TaskHandler<VoiceTask> initVoicesTask() {
        return new TaskHandler<>(TaskCreator.createVoiceTasks());
    }

    private TaskHandler<TranslationTask> initTranslationsTask() {
        return new TaskHandler<>(TaskCreator.createTranslationTasks());
    }

    private TaskHandler<ChooseTask> initChooseTask() {
        return new TaskHandler<>(TaskCreator.createChooseTasks());
    }
}
