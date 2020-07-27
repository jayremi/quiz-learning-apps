package com.example.janct;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.material.navigation.NavigationView;

import java.util.Random;

public class MathMedium_activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    private TextView mScoreView;
    private TextView mQuestion;

    private Button mBt_choice1,mBt_choice2,mBt_choice3,mBt_choice4,mBt_tips;
    private int mScore=0;
    private String mAnswer;
    private int randomarray[] =new int [9];
    private int mQuestionNumber;
    private int count=0;
    private String mTips;


    private Firebase mQuestionRef, mchoice1Ref,mchoice2Ref,mchoice3Ref,mchoice4Ref,mAnswerRef,mTipsRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        super.setContentView(R.layout.medium_math);

        //Navigation drawer
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout=findViewById(R.id.drawer_math_medium);
        navigationView=findViewById(R.id.navigationView_math_medium);
        navigationView.setNavigationItemSelectedListener(this);

        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        mScoreView=(TextView)findViewById(R.id.score_mathmedium);
        mQuestion=(TextView)findViewById(R.id.quiz_mathmedium);
        mBt_choice1=(Button)findViewById(R.id.a_math_medium);
        mBt_choice2=(Button)findViewById(R.id.b_math_medium);
        mBt_choice3=(Button)findViewById(R.id.c_math_medium);
        mBt_choice4=(Button)findViewById(R.id.d_math_medium);
        mBt_tips=(Button)findViewById(R.id.tips_math_medium);

        getrandom();
        updateQuestion();

        mBt_tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mTips.isEmpty())
                {
                    Toast toast= Toast.makeText(getApplicationContext(), "No tip available for this question", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }
                else
                {
                    Toast toast= Toast.makeText(getApplicationContext(), ""+mTips, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }
            }
        });

        mBt_choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mBt_choice1.getText().equals(mAnswer))
                {
                    mScore=mScore+1;
                    updateScore(mScore);
                    count++;
                    mQuestionNumber=randomarray[count];
                    if(count!=10)
                    {
                        updateQuestion();
                    }
                    else if(count==10)
                    {
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }

                }
                else
                {
                    count++;
                    mQuestionNumber=randomarray[count];
                    if(count!=10)
                    {
                        updateQuestion();
                    }
                    else if(count==10)
                    {
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }
                }
            }
        });

        mBt_choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mBt_choice2.getText().equals(mAnswer))
                {
                    mScore=mScore+1;
                    updateScore(mScore);
                    count++;
                    mQuestionNumber=randomarray[count];
                    if(count!=10)
                    {
                        updateQuestion();
                    }
                    else if(count==10)
                    {
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }
                }
                else
                {
                    count++;
                    mQuestionNumber=randomarray[count];
                    if(count!=10)
                    {
                        updateQuestion();
                    }
                    else if(count==10)
                    {
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }
                }

            }
        });

        mBt_choice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mBt_choice3.getText().equals(mAnswer))
                {
                    mScore=mScore+1;
                    updateScore(mScore);
                    count++;
                    mQuestionNumber=randomarray[count];
                    if(count!=10)
                    {
                        updateQuestion();
                    }
                    else if(count==10)
                    {
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }
                }
                else
                {
                    count++;
                    mQuestionNumber=randomarray[count];
                    if(count!=10)
                    {
                        updateQuestion();
                    }
                    else if(count==10)
                    {
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }
                }

            }
        });

        mBt_choice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mBt_choice1.getText().equals(mAnswer))
                {
                    mScore=mScore+1;
                    updateScore(mScore);
                    count++;
                    mQuestionNumber=randomarray[count];
                    if(count!=10)
                    {
                        updateQuestion();
                    }
                    else if(count==10)
                    {
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }
                }
                else
                {
                    count++;
                    mQuestionNumber=randomarray[count];
                    if(count!=10)
                    {
                        updateQuestion();
                    }
                    else if(count==10)
                    {
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }
                }
            }
        });

    }

    public void getrandom()
    {
        Random rd = new Random(); // creating Random object
        int x = 0;

        for (int i = 0; i < randomarray.length; i++) {
            int y = rd.nextInt(11);
            randomarray[i] = x + y;
            x = x + 5;
        }
    }

    public void updateScore(int score){
        mScoreView.setText(""+mScore);
    }

    public void updateQuestion() {

        mTipsRef=new Firebase("https://janct-53eab.firebaseio.com/"+mQuestionNumber+"/tips");
        mTipsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String tips=dataSnapshot.getValue(String.class);
                mTips=tips;
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mQuestionRef = new Firebase("https://janct-53eab.firebaseio.com/" + mQuestionNumber + "/question");
        mQuestionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String question = dataSnapshot.getValue(String.class);
                mQuestion.setText(question);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mchoice1Ref = new Firebase("https://janct-53eab.firebaseio.com/" + mQuestionNumber + "/choice1");
        mchoice1Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mBt_choice1.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mchoice2Ref = new Firebase("https://janct-53eab.firebaseio.com/" + mQuestionNumber + "/choice2");
        mchoice2Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mBt_choice2.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mchoice3Ref = new Firebase("https://janct-53eab.firebaseio.com/" + mQuestionNumber + "/choice3");
        mchoice3Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mBt_choice3.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mchoice4Ref = new Firebase("https://janct-53eab.firebaseio.com/" + mQuestionNumber + "/choice4");
        mchoice4Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mBt_choice4.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mAnswerRef = new Firebase("https://janct-53eab.firebaseio.com/" + mQuestionNumber + "/answer");
        mAnswerRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String answer = dataSnapshot.getValue(String.class);
                mAnswer = answer;
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if(menuItem.getItemId()==R.id.course)
        {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            /*fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment,new MainFragment());
            fragmentTransaction.commit();*/
        }
        if(menuItem.getItemId()==R.id.leaderboard)
        {
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment,new LdrFragment());
            fragmentTransaction.commit();
        }
        if(menuItem.getItemId()==R.id.logout)
        {

        }
        return true;
    }
}
