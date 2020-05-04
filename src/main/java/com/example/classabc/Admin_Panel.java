package com.example.classabc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Admin_Panel extends AppCompatActivity implements View.OnClickListener {

    String[] course_code , session;
    Spinner course_spin,session_spin;
    TextView class_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__panel);

        course_code = getResources().getStringArray(R.array.course_code);
        session = getResources().getStringArray(R.array.session);

        class_id = findViewById(R.id.class_id);

        ArrayAdapter<String> adapter_course = new ArrayAdapter<>(getApplicationContext(),R.layout.spinner_layout ,R.id.spinner_layout_textId , course_code);
        course_spin.setAdapter(adapter_course);

        ArrayAdapter<String> adapter_session = new ArrayAdapter<>(getApplicationContext(),R.layout.spinner_layout ,R.id.spinner_layout_textId ,session);
        session_spin.setAdapter(adapter_session);

        course_spin = findViewById(R.id.course_select_spinnerId);
        session_spin = findViewById(R.id.session_select_spinnerId);

        session_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                class_id.append(session[position]+"_");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        course_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                class_id.append(course_code[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.attendenceButtonId){

            Intent att = new Intent(getApplicationContext() , Attendence.class);
            startActivity(att);

        }
        if(v.getId()==R.id.result_sheetButtonId){
            Intent res = new Intent(getApplicationContext() , Result_Sheet.class);
            startActivity(res);
        }
    }
}
