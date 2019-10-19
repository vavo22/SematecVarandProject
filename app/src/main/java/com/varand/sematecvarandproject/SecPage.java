package com.varand.sematecvarandproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_page);
        Button btnReview = findViewById(R.id.btnReview);
        final EditText edtName = findViewById(R.id.edtName);
        final EditText edtFamilt = findViewById(R.id.edtFamilt);
        final EditText edtFmail = findViewById(R.id.edtFmail);
        final EditText edtAge = findViewById(R.id.edtAge);
        Button btnback = findViewById(R.id.btnback);
        Log.d("tag","varand55");
        String _Name = PreferenceManager.getDefaultSharedPreferences(SecPage.this).getString("Name","");
        String _edtFamilt = PreferenceManager.getDefaultSharedPreferences(SecPage.this).getString("edtFamilt","");
        String _edtFmail = PreferenceManager.getDefaultSharedPreferences(SecPage.this).getString("edtFmail","");
        String _Age15 = PreferenceManager.getDefaultSharedPreferences(SecPage.this).getString("Age15","");
        edtName.setText(_Name);
        edtFamilt.setText(_edtFamilt);
        edtFmail.setText(_edtFmail);
        edtAge.setText(_Age15);
        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SecPage.this,ThierdPage.class);

                intent.putExtra("Name",edtName.getText().toString());
                intent.putExtra("edtFamilt",edtFamilt.getText().toString());
                intent.putExtra("edtFmail",edtFmail.getText().toString());
                intent.putExtra("edtAge",edtAge.getText().toString());

                startActivityForResult(intent,2);



            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("TestNews",requestCode + "");
        Log.d("TestNews",resultCode + "");
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
                edtAge.setText(data.getStringExtra("Age15"));

            }
            else if (resultCode ==  12)
        {
            Toast.makeText(SecPage.this,"Save Success",Toast.LENGTH_LONG).show();
        }
        }
    }

}
