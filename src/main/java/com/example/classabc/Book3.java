package com.example.classabc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Book3 extends AppCompatActivity {

    PDFView book3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book3);

        book3 = findViewById(R.id.pdf3id);

        book3.fromAsset("JavaTheCompleteReference.pdf").load();
    }
}
