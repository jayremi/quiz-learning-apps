package com.example.janct;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,MainFragment.onFragmentBtnSelected,EnglishFragment.onFragmentBtnSelected,MathFragment.onFragmentBtnSelected,ScienceFragment.onFragmentBtnSelected{

    //alex
    FirebaseAuth fAuth;
    FirebaseDatabase firebaseDatabase;

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    TextView headername;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //alex
        fAuth = FirebaseAuth.getInstance();
        Log.d("tag","onCreate: " + fAuth.getCurrentUser().getEmail() + fAuth.getCurrentUser().getDisplayName());


        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout=findViewById(R.id.drawer);
        navigationView=findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
        headername=findViewById(R.id.header_name);



        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        //load default fragment
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment,new MainFragment());
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if(menuItem.getItemId()==R.id.course)
        {
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment,new MainFragment());
            fragmentTransaction.commit();
        }
        if(menuItem.getItemId()==R.id.leaderboard)
        {
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment,new LdrFragment());
            fragmentTransaction.commit();
        }
        //logout alex
        if(menuItem.getItemId()==R.id.logout)
        {
            FirebaseAuth.getInstance().signOut();
            GoogleSignIn.getClient(this,new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build())
                    .signOut().addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this,"SignOut Failed!",Toast.LENGTH_SHORT).show();
                }
            });
        }
        return true;
    }

    //button clicks
    @Override
    public void onButtonSelectedEnglish() {
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment,new EnglishFragment());
        fragmentTransaction.commit();
    }
    public void onButtonSelectedMath() {
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment,new MathFragment());
        fragmentTransaction.commit();
    }
    public void onButtonSelectedScience() {
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment,new ScienceFragment());
        fragmentTransaction.commit();
    }


    //Select button in main fragment function
    public void onButtonSelectedEnglishEasy() {
        startActivity(new Intent(getApplicationContext(),EnglishEasy_activity.class));
    }
    public void onButtonSelectedEnglishMedium() {
        startActivity(new Intent(getApplicationContext(),EnglishMedium_activity.class));

    }
    public void onButtonSelectedEnglishHard() {
        startActivity(new Intent(getApplicationContext(),EnglishHard_activity.class));
    }

    //Math Fragment
    public void onButtonSelectedMathEasy() {
        startActivity(new Intent(getApplicationContext(),MathEasy_activity.class));

    }
    public void onButtonSelectedMathMedium() {
        startActivity(new Intent(getApplicationContext(),MathMedium_activity.class));

    }
    public void onButtonSelectedMathHard() {
        startActivity(new Intent(getApplicationContext(),MathHard_activity.class));

    }

    //Science Fragment
    public void onButtonSelectedScienceEasy() {
        startActivity(new Intent(getApplicationContext(),ScienceEasy_activity.class));

    }
    public void onButtonSelectedScienceMedium() {
        startActivity(new Intent(getApplicationContext(),ScienceMedium_activity.class));

    }
    public void onButtonSelectedScienceHard() {
        startActivity(new Intent(getApplicationContext(),ScienceHard_activity.class));

    }
}
