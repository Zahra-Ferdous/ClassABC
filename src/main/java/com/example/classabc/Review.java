package com.example.classabc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Review extends AppCompatActivity {

    EditText rev;
    Button sub;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        databaseReference = FirebaseDatabase.getInstance().getReference("Review");

        rev = findViewById(R.id.revtextId);
        sub = findViewById(R.id.subButtonId);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }

            private void saveData() {

                String review = rev.getText().toString();

                String key = databaseReference.push().getKey();

                databaseReference.child(key).setValue(review);
                Toast.makeText(getApplicationContext() , "Submitted Successfully" , Toast.LENGTH_SHORT).show();

            }
        });
    }
}
