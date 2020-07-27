package com.example.janct;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class LdrFragment extends Fragment {

    Button ldr_english;
    Button ldr_math;
    Button ldr_science;
    ArrayList mArrayList;
    RecyclerView mListview;
    private Object leaderboard;
    private ArrayAdapter mArrayAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_ldr,container,false);
        return view;
    }

    /*public Button getLdr_english() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Leaderboard").child("English");
        Query sort = ref.orderByChild("English").limitToLast(3);
        mArrayAdapter = new ArrayAdapter<this,R.layout.fragment_ldr,R.id.leaderboard,mArrayList>();
        sort.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds:dataSnapshot.getChildren()){
                    leaderboard=ds.getValue(leaderboard.class);
                    mArrayList.add(leaderboard.getClass());
                }
                Collections.reverse(mArrayList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return ldr_english;
    }*/
}
