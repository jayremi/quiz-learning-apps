package com.example.janct;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ScienceFragment extends Fragment {

    private onFragmentBtnSelected listener;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_science, container, false);

        Button easy = view.findViewById(R.id.science_easy);
        Button medium = view.findViewById(R.id.science_medium);
        Button hard = view.findViewById(R.id.science_hard);

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onButtonSelectedScienceEasy();
            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onButtonSelectedScienceMedium(); ;
            }
        });

        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onButtonSelectedScienceHard();
            }
        });

        return view;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof onFragmentBtnSelected)
        {
            listener=(onFragmentBtnSelected)context;
        }
        else
        {
            throw new ClassCastException(context.toString()+"must implement listener");
        }
    }

    public interface onFragmentBtnSelected
    {
        public void onButtonSelectedScienceEasy();

        public void onButtonSelectedScienceMedium();

        public void onButtonSelectedScienceHard();
    }

}
