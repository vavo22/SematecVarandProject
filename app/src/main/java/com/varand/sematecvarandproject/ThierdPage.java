package com.varand.sematecvarandproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThierdPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thierd_page);
        Intent intent = getIntent();
        final TextView edtName = findViewById(R.id.txtName);
        final TextView edtFamilt = findViewById(R.id.txtFamilt);
        final TextView edtFmail = findViewById(R.id.txtFmail);
        final TextView edtAge = findViewById(R.id.txtAge);
        Button BtnEdit = findViewById(R.id.BtnEdit);
        Button BtnOk = findViewById(R.id.BtnOk);
        edtName.setText(intent.getStringExtra("Name"));
        edtFamilt.setText(intent.getStringExtra("edtFamilt"));
        edtFmail.setText(intent.getStringExtra("edtFmail"));
        edtAge.setText(intent.getStringExtra("edtAge"));

        BtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TestNews","10");
                Intent intent=new Intent();
                Log.d("TestNews","11");
                intent.putExtra("Name",edtName.getText());
                Log.d("TestNews","12");
                intent.putExtra("edtFamilt",edtFamilt.getText());
                Log.d("TestNews","13");
                intent.putExtra("edtFmail",edtFmail.getText());
                Log.d("TestNews","14");
                intent.putExtra("Age15",edtAge.getText());
                Log.d("TestNews","15");
                setResult(Activity.RESULT_OK,intent);
                Log.d("TestNews","16");
                finish();
            }
        });

        BtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("Name",edtName.getText());
                Log.d("TestNews","1");
                intent.putExtra("edtFamilt",edtFamilt.getText());
                Log.d("TestNews","2");
                intent.putExtra("edtFmail",edtFmail.getText());
                Log.d("TestNews","3");
                intent.putExtra("Age15",edtAge.getText());
                Log.d("TestNews","4");
                PreferenceManager.getDefaultSharedPreferences(ThierdPage.this).edit().putString("Name",edtName.getText().toString()).apply();
                Log.d("TestNews","5");
                PreferenceManager.getDefaultSharedPreferences(ThierdPage.this).edit().putString("edtFamilt",edtFamilt.getText().toString()).apply();
                Log.d("TestNews","6");
                PreferenceManager.getDefaultSharedPreferences(ThierdPage.this).edit().putString("edtFmail",edtFmail.getText().toString()).apply();
                PreferenceManager.getDefaultSharedPreferences(ThierdPage.this).edit().putString("Age15",edtAge.getText().toString()).apply();
                setResult(12,intent);
                Log.d("TestNews","7");
                finish();
                Log.d("TestNews","8");
            }
        });
    }
}
