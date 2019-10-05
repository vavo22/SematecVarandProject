package com.varand.sematecvarandproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("VarandTags","onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("VarandTags","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("VarandTags","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("VarandTags","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("VarandTags","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("VarandTags","onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("VarandTags","onRestart");
    }
}
