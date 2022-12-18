package com.example.ip;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.ip.fragments.ChooseTaskFragment;
import com.example.ip.fragments.GreetingsFragment;
import com.example.ip.fragments.TasksPathFragment;
import com.example.ip.fragments.TranslationTaskFragment;
import com.example.ip.fragments.VoiceTaskFragment;
import com.example.ip.tasks.ChooseTask;
import com.example.ip.tasks.Task;
import com.example.ip.tasks.TranslationTask;
import com.example.ip.tasks.VoiceTask;

public class MainActivity extends AppCompatActivity implements ReceiveFromFragment {
    private GreetingsFragment greetingsFragment = new GreetingsFragment();
    private TasksPathFragment tasksPathFragment = new TasksPathFragment();
    private User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showGreetingFragment();
    }

    private void showGreetingFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, greetingsFragment);
        ft.commitNow();
    }

    private void showFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.addToBackStack("");
        ft.commit();
    }

    @Override
    public void receive(String name) {
        showFragment(tasksPathFragment);
        user.setName(name);
    }


    @Override
    public void receive(int identifier, TaskHandler<? extends Task> taskHandler, int index) {
        if (identifier == 0) {
            if (index < 5)
                showFragment(new VoiceTaskFragment((TaskHandler<VoiceTask>) taskHandler, index));
            else {
                showFragment(tasksPathFragment);
                user.increaseOverallProgress(0);
            }
        }
        if (identifier == 1) {
            if (index < 5)
                showFragment(new TranslationTaskFragment((TaskHandler<TranslationTask>) taskHandler, index));
            else {
                showFragment(tasksPathFragment);
                user.increaseOverallProgress(1);
            }
        }
        if (identifier == 2) {
            if (index < 10)
                showFragment(new ChooseTaskFragment((TaskHandler<ChooseTask>) taskHandler, index));
            else {
                showFragment(tasksPathFragment);
                user.increaseOverallProgress(2);
            }
        }
    }
}