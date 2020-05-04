package com.example.classabc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Course_Material extends AppCompatActivity implements View.OnClickListener {

    Button book1button, book2button , book3button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course__material);

        book1button = findViewById(R.id.book1Id);
        book2button = findViewById(R.id.book2Id);
        book3button = findViewById(R.id.book3Id);

        book1button.setOnClickListener(this);
        book2button.setOnClickListener(this);
        book3button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.book1Id){
            Intent b1 = new Intent(Course_Material.this , Book1.class);
            startActivity(b1);
        }

        if(v.getId()==R.id.book2Id){
            Intent b2 = new Intent(Course_Material.this , Book2.class);
            startActivity(b2);
        }

        if(v.getId()==R.id.book3Id){
            Intent b3 = new Intent(Course_Material.this , Book3.class);
            startActivity(b3);
        }

    }
}
