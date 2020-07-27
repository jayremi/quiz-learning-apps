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

public class MainFragment extends Fragment {
    private onFragmentBtnSelected listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_main,container,false);

        Button english=view.findViewById(R.id.bt_english);
        Button math=view.findViewById(R.id.bt_math);
        Button science=view.findViewById(R.id.bt_science);

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onButtonSelectedEnglish();
            }
        });

        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onButtonSelectedMath();
            }
        });

        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onButtonSelectedScience();
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

    public interface onFragmentBtnSelected{
        public void onButtonSelectedEnglish();

        public void onButtonSelectedMath();

        public void onButtonSelectedScience();


    }

}


