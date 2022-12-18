package com.example.ip.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ip.R;
import com.example.ip.ReceiveFromFragment;
import com.example.ip.TaskHandler;
import com.example.ip.tasks.TranslationTask;
import com.example.ip.tasks.VoiceTask;

public class VoiceTaskFragment extends Fragment {

    private final TaskHandler<VoiceTask> taskHandler;
    private int index;

    public VoiceTaskFragment(TaskHandler<VoiceTask> taskHandler, int index){
        super(R.layout.task_fragment);
        this.taskHandler = taskHandler;
        this.index = index;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView taskText = requireView().findViewById(R.id.taskText);
        Button answer1 = requireView().findViewById(R.id.answer1);
        Button answer2 = requireView().findViewById(R.id.answer2);
        Button answer3 = requireView().findViewById(R.id.answer3);
        Button answer4 = requireView().findViewById(R.id.answer4);
        Button nextTask = requireView().findViewById(R.id.nextTask);
        ImageButton listenButton = requireView().findViewById(R.id.listenButton);

        VoiceTask task = taskHandler.tasks.get(index);
        nextTask.setVisibility(View.INVISIBLE);
        makeAnswerButtonsVisible(answer1, answer2, answer3, answer4);
        listenButton.setVisibility(View.VISIBLE);
        initTexts(taskText, answer1, answer2, answer3, answer4, task);

        answer1.setOnClickListener(v -> actionOnClick(task, answer1, answer1, nextTask, answer2, answer3, answer4));
        answer2.setOnClickListener(v -> actionOnClick(task, answer2, answer1, nextTask, answer2, answer3, answer4));
        answer3.setOnClickListener(v -> actionOnClick(task, answer3, answer1, nextTask, answer2, answer3, answer4));
        answer4.setOnClickListener(v -> actionOnClick(task, answer4, answer1, nextTask, answer2, answer3, answer4));

        listenButton.setOnClickListener(v -> {
            MediaPlayer mp = MediaPlayer.create(getActivity(), task.getAudio());
            mp.start();
        });

        nextTask.setOnClickListener(v -> ((ReceiveFromFragment) getActivity()).receive(0, taskHandler, index + 1));
    }

    private void initTexts(TextView taskText, Button answer1, Button answer2, Button answer3, Button answer4, VoiceTask task) {
        taskText.setText(task.taskText);
        answer1.setText(task.options.get(0));
        answer2.setText(task.options.get(1));
        answer3.setText(task.options.get(2));
        answer4.setText(task.options.get(3));
    }

    private void actionOnClick(VoiceTask task, Button answer, Button answer1, Button nextTask, Button answer2, Button answer3, Button answer4) {
        if (task.checkIfAnswerGivenIsRight(
                answer.getText().toString())) {
            taskHandler.counter++;
            Toast.makeText(getActivity(), "Correct", Toast.LENGTH_SHORT).show();
        } else Toast.makeText(getActivity(), "Incorrect", Toast.LENGTH_SHORT).show();
        nextTask.setVisibility(View.VISIBLE);
        makeAnswerButtonsInvisible(answer1, answer2, answer3, answer4);
    }

    private void makeAnswerButtonsInvisible(Button answer1, Button answer2, Button answer3, Button answer4) {
        answer1.setVisibility(View.INVISIBLE);
        answer2.setVisibility(View.INVISIBLE);
        answer3.setVisibility(View.INVISIBLE);
        answer4.setVisibility(View.INVISIBLE);
    }

    private void makeAnswerButtonsVisible(Button answer1, Button answer2, Button answer3, Button answer4) {
        answer1.setVisibility(View.VISIBLE);
        answer2.setVisibility(View.VISIBLE);
        answer3.setVisibility(View.VISIBLE);
        answer4.setVisibility(View.VISIBLE);
    }
}
