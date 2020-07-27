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

public class EnglishFragment extends Fragment{
    private onFragmentBtnSelected listener;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_english, container, false);

        Button easy = view.findViewById(R.id.english_easy);
        Button medium = view.findViewById(R.id.english_medium);
        Button hard = view.findViewById(R.id.english_hard);

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onButtonSelectedEnglishEasy();
            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onButtonSelectedEnglishMedium() ;
            }
        });

        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onButtonSelectedEnglishHard();
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
        public void onButtonSelectedEnglishEasy();

        public void onButtonSelectedEnglishMedium();

        public void onButtonSelectedEnglishHard();
    }
}
