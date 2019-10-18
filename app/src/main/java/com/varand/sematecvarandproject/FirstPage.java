package com.varand.sematecvarandproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        Button btnProfile = findViewById(R.id.btnProfile);
        Button btnDial = findViewById(R.id.btnDial);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(FirstPage.this,SecPage.class);
            startActivity(intent);
            //startActivityForResult(I,320);
            }
        });

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstPage.this,SecPage.class);
                startActivity(intent);
                //startActivityForResult(I,320);
            }
        });
    }
}
