package com.example.classabc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class View_Attendance extends AppCompatActivity {

    ListView lv;
    ArrayList<String> st;
    ArrayAdapter<String> ada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__attendance);

        setTitle("Present Students");

        lv = findViewById(R.id.ViewAttListid);

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null){
            st = bundle.getStringArrayList("array");
            setTitle(bundle.getString("viewdate"));
        }

        ada = new ArrayAdapter<>(View_Attendance.this , R.layout.sample_listview , R.id.viewAttTextid , st);
        lv.setAdapter(ada);
    }
}
