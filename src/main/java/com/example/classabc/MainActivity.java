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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText name,rollno,passwards,emaill;
    private Button signup , newpage;
    private ProgressBar pbr;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        name = findViewById(R.id.et1id);
        emaill = findViewById(R.id.et2id);
        rollno = findViewById(R.id.et3id);
        passwards = findViewById(R.id.et4id);

        signup = findViewById(R.id.button1id);
        newpage = findViewById(R.id.button2id);

        pbr = findViewById(R.id.pbid);

        signup.setOnClickListener(this);
        newpage.setOnClickListener(this);

        passwards.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.button1id)
        {
            userReg();
            //saveData();
        }

        if(v.getId()==R.id.button2id){
            Intent signin = new Intent(MainActivity.this , LoginPage.class);
            startActivity(signin);
        }

    }

    private void saveData() {

        String nm, rl , ps , em;

        nm = name.getText().toString().trim();
        rl = rollno.getText().toString().trim();
        em = emaill.getText().toString().trim();
        ps = passwards.getText().toString().trim();

    }

    private void userReg() {

        String username = name.getText().toString().trim();
        String email = emaill.getText().toString().trim();
        //int roll = Integer.parseInt(rn.getText().toString().trim());
        String roll = rollno.getText().toString().trim();
        final String password = passwards.getText().toString().trim();

        if(username.isEmpty())
        {
            name.setError("Enter a User Name");
            name.requestFocus();
            return;
        }
        if(email.isEmpty())
        {
            emaill.setError("Enter an Email Address");
            emaill.requestFocus();
            return;
        }
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            emaill.setError("Enter a Valid Email Address");
            emaill.requestFocus();
            return;
        }
        if(roll.isEmpty())
        {
            rollno.setError("Enter a Roll Number");
            rollno.requestFocus();
            return;
        }
        if(password.isEmpty())
        {
            passwards.setError("Enter a Password");
            passwards.requestFocus();
            return;
        }
        if(password.length()<6)
        {
            passwards.setError("Enter a Password with Minimum Length 6");
            passwards.requestFocus();
            return;
        }

        pbr.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "sign up successful" , Toast.LENGTH_SHORT).show();

                    if(password.equals("1707000")){
                        Intent admin = new Intent(getApplicationContext() , Admin_Panel.class);
                        admin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(admin);
                    }
                    else {
                        Intent profile = new Intent(getApplicationContext(), Profile.class);
                        profile.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(profile);
                    }
                } else {
                    if(task.getException() instanceof FirebaseAuthUserCollisionException)
                    {
                        Toast.makeText(getApplicationContext(),"user has already signed up" , Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(getApplicationContext(), "sign up is not successful" , Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
