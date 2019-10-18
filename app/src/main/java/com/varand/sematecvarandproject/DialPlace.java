package com.varand.sematecvarandproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DialPlace extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial_place);
        Button btnReview = findViewById(R.id.btnDial);
        final TextView edtnumber = findViewById(R.id.edtnumber);
        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(edtnumber.getText().toString()));
                startActivity(intent);
            }
        });
    }
}
