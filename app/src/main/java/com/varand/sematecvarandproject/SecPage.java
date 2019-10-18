package com.varand.sematecvarandproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_page);
        Button btnReview = findViewById(R.id.btnReview);
        Log.d("tag","varand55");
        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText edtName = findViewById(R.id.edtName);
                final EditText edtFamilt = findViewById(R.id.edtFamilt);
                final EditText edtFmail = findViewById(R.id.edtFmail);
                final EditText edtAge = findViewById(R.id.edtAge);
                Intent intent = new Intent(SecPage.this,ThierdPage.class);
                intent.putExtra("Name",edtName.getText().toString());
                intent.putExtra("edtFamilt",edtFamilt.getText().toString());
                intent.putExtra("edtFmail",edtFmail.getText().toString());
                intent.putExtra("edtAge",edtAge.getText().toString());

                startActivityForResult(intent,2);



            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode== 2)
        {
            if (resultCode ==  Activity.RESULT_OK) {
                final EditText edtName = findViewById(R.id.edtName);
                final EditText edtFamilt = findViewById(R.id.edtFamilt);
                final EditText edtFmail = findViewById(R.id.edtFmail);
                final EditText edtAge = findViewById(R.id.edtAge);
                edtName.setText(data.getStringExtra("Name"));
                edtFamilt.setText(data.getStringExtra("edtFamilt"));
                edtFmail.setText(data.getStringExtra("edtFmail"));
                edtAge.setText(data.getStringExtra("edtAge"));
            }
        }
    }

}
