package com.example.classabc;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Profile extends AppCompatActivity implements View.OnClickListener {

    private Button plan , mat , review;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        plan = findViewById(R.id.course_planId);
        mat = findViewById(R.id.course_matId);
        review = findViewById(R.id.review_subId);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        plan.setOnClickListener(this);
        mat.setOnClickListener(this);
        review.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        /*MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate();*/
        getMenuInflater().inflate(R.menu.sample_menu , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.sign_outId){
            FirebaseAuth.getInstance().signOut();
            finish();
            Intent mainIn = new Intent(getApplicationContext() , MainActivity.class);
            startActivity(mainIn);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.course_planId){

            Intent cp = new Intent(Profile.this, Course_PLan.class);
            startActivity(cp);

        }
        if(v.getId()==R.id.course_matId){

            Intent cm = new Intent(Profile.this, Course_Material.class);
            startActivity(cm);

        }
        if(v.getId()==R.id.review_subId){

            Intent rv = new Intent(Profile.this, Review.class);
            startActivity(rv);

        }
    }
}
