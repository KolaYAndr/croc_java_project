package com.example.ip.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ip.R;
import com.example.ip.ReceiveFromFragment;

public class GreetingsFragment extends Fragment {


    public GreetingsFragment() {
        super(R.layout.greeting_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText askAboutName = (EditText) requireView().findViewById(R.id.askAboutName);
        Button setName = (Button) requireView().findViewById(R.id.setName);


        askAboutName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (askAboutName.getText().length() > 0) {
                    setName.setVisibility(View.VISIBLE);
                } else setName.setVisibility(View.INVISIBLE);
            }
        });

        setName.setOnClickListener(v -> {
            Activity activity = getActivity();
            assert activity != null;
            ((ReceiveFromFragment) activity).receive(askAboutName.getText().toString());
        });
    }
}