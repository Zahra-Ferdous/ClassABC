package com.example.classabc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText em,pw;
    private Button b1;
    private ProgressBar pgb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mAuth = FirebaseAuth.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        b1 = findViewById(R.id.buttonb1id);

        em = findViewById(R.id.etb1id);
        pw = findViewById(R.id.etb2id);

        pgb = findViewById(R.id.pbbid);

        pw.setTransformationMethod(PasswordTransformationMethod.getInstance());

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLog();
            }
        });
    }

    private void userLog() {

        String email = em.getText().toString().trim();
        final String password = pw.getText().toString().trim();

        if(email.isEmpty())
        {
            em.setError("Enter an Email Address");
            em.requestFocus();
            return;
        }
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            em.setError("Enter a Valid Email Address");
            em.requestFocus();
            return;
        }
        if(password.isEmpty())
        {
            pw.setError("Enter a Password");
            pw.requestFocus();
            return;
        }
        if(password.length()<6)
        {
            pw.setError("Enter a Password with Minimum Length 6");
            pw.requestFocus();
            return;
        }

        pgb.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email , password ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                pgb.setVisibility(View.GONE);
                if(task.isSuccessful())
                {
                    finish();
                    if(password.equals("1707000")){
                        Intent add = new Intent(getApplicationContext() , Admin_Panel.class);
                        add.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(add);
                    }
                    else {
                        Intent profile = new Intent(getApplicationContext(), Profile.class);
                        profile.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(profile);
                    }
                }
                else {
                    Toast.makeText(getApplicationContext() , "Login Unsuccessful" , Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
