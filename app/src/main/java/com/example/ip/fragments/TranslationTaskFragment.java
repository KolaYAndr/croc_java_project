package com.example.ip.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ip.R;
import com.example.ip.ReceiveFromFragment;
import com.example.ip.TaskHandler;
import com.example.ip.tasks.TranslationTask;

public class TranslationTaskFragment extends Fragment {
    private final TaskHandler<TranslationTask> taskHandler;
    private int index;

    public TranslationTaskFragment(TaskHandler<TranslationTask> taskHandler, int index) {
        super(R.layout.translation_task_fragment);
        this.taskHandler = taskHandler;
        this.index = index;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView taskText = requireView().findViewById(R.id.taskText);
        EditText answerInput = requireView().findViewById(R.id.answerInput);
        Button nextTask = requireView().findViewById(R.id.nextTask);
        Button giveAnswer = requireView().findViewById(R.id.giveAnswer);

        TranslationTask task = taskHandler.tasks.get(index);
        nextTask.setVisibility(View.INVISIBLE);
        answerInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (answerInput.getText().length() > 0) {
                    giveAnswer.setVisibility(View.VISIBLE);
                } else giveAnswer.setVisibility(View.INVISIBLE);
            }
        });

        giveAnswer.setOnClickListener(v -> {
            nextTask.setVisibility(View.VISIBLE);
            giveAnswer.setVisibility(View.INVISIBLE);
            if (task.checkIfAnswerGivenIsRight(answerInput.getText().toString())) {
                taskHandler.counter++;
                Toast.makeText(getActivity(), "Correct", Toast.LENGTH_SHORT).show();
            } else Toast.makeText(getActivity(), "Incorrect", Toast.LENGTH_SHORT).show();
        });

        initTexts(taskText, task);

        nextTask.setOnClickListener(v -> ((ReceiveFromFragment) getActivity()).receive(1, taskHandler, index + 1));


    }

    private void initTexts(TextView taskText, TranslationTask task) {
        taskText.setText(task.taskText);
    }
}
