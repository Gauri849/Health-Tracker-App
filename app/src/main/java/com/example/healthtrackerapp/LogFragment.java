package com.example.healthtrackerapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LogFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_log, container, false);
        TextInputEditText symptomEditText = view.findViewById(R.id.symptom_input);
        MaterialButton saveButton = view.findViewById(R.id.save_button);

        saveButton.setOnClickListener(v -> {
            String title = symptomEditText.getText().toString();
            Toast.makeText(getContext(), "Saved:"+title, Toast.LENGTH_SHORT).show();
        });
        return view;
    }
}
