package com.varand.sematecvarandproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainPage extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {
    MyRecyclerViewAdapter adapter;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        ArrayList<DataModel> animalNames = new ArrayList<>();
        animalNames.add(new DataModel(R.drawable.dial,"Dial"));
        animalNames.add(new DataModel(R.drawable.profile,"Profile"));
        //
        RecyclerView recyclerView = findViewById(R.id.rvContacts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, animalNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        //
        ImageView img = findViewById(R.id.Imgbtn);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout = (DrawerLayout) findViewById(R.id.DrawerLayout);
                drawerLayout.openDrawer(Gravity.LEFT);
                TextView _TextView = findViewById(R.id.txtChange);
                _TextView.setText("varand");
            }
        });
    }

    @Override
    public void onItemClick(View view, int position) {
        //Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
        if (adapter.getItem(position).name == "Dial")
        {
            Intent intent = new Intent(MainPage.this,DialPlace.class);
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(MainPage.this,SecPage.class);
            startActivity(intent);
        }
    }
}
