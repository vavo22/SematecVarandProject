package com.varand.sematecvarandproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cz.msebera.android.httpclient.Header;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.TextHttpResponseHandler;
import com.squareup.picasso.Picasso;
import com.varand.sematecvarandproject.Movies.Search;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MDetail2Activity extends AppCompatActivity {
    MyMoviesViewAdapter adapter;
    ArrayList<Search> MoviesArry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mdetail2);
        Intent intent = getIntent();
        String MessageID = intent.getStringExtra("imdbCode");

        String Url = "http://www.omdbapi.com/?i="+MessageID+"&apikey=b80e72c2";// + intent.getStringExtra("ItemID");

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(Url, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d("salam4", String.valueOf(throwable));
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    JSONObject jsonSub = new JSONObject(responseString);
                    //jsonSub.getString("Poster"),jsonSub.getString("Title"),jsonSub.getString("Year")
                    //,jsonSub.getString("imdbID"),jsonSub.getString("Plot"),jsonSub.getString("Actors"),jsonSub.getString("Country")));
                    TextView txtTitle = findViewById(R.id.tvAnimalNamed);
                    TextView txtYear = findViewById(R.id.txtYeard);
                    TextView txtPlot = findViewById(R.id.txtPlotd);
                    TextView txtActors = findViewById(R.id.txtActorsd);
                    TextView txtCountry = findViewById(R.id.txtCountryd);
                    ImageView _ImageView = findViewById(R.id.ImageView);
                    Picasso.get().load(String.valueOf(jsonSub.get("Poster"))).into(_ImageView);
                    txtTitle.setText(String.valueOf(jsonSub.get("Title")));
                    txtYear.setText(String.valueOf(jsonSub.get("Year")));
                    txtPlot.setText(String.valueOf(jsonSub.get("Plot")));
                    txtActors.setText(String.valueOf(jsonSub.get("Actors")));
                    txtCountry.setText(String.valueOf(jsonSub.get("Country")));

                    Log.d("salam4","1" );
                } catch (JSONException e) {
                    e.printStackTrace();
                }





            }
        });

    }
}
