package com.varand.sematecvarandproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
        edtName.setText(intent.getStringExtra("Name"));
        edtFamilt.setText(intent.getStringExtra("edtFamilt"));
        edtFmail.setText(intent.getStringExtra("edtFmail"));
        edtAge.setText(intent.getStringExtra("edtAge"));

        BtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("Name",edtName.getText());
                intent.putExtra("edtFamilt",edtFamilt.getText());
                intent.putExtra("edtFmail",edtFmail.getText());
                intent.putExtra("Age15",edtAge.getText());
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}
