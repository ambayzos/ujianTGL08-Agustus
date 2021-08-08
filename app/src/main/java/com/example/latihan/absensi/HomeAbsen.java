package com.example.latihan.absensi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeAbsen extends AppCompatActivity {

    Button cekIn, cekOt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_absen);
        cekIn = findViewById(R.id.btnCekin);
        cekOt = findViewById(R.id.btnCekot);

        cekIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeAbsen.this, LoginAbsen.class);
                startActivity(intent);
            }
        });
    }
}