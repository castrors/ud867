package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.jokeview.Constants;
import com.example.jokeview.JokeActivity;


public class MainActivity extends AppCompatActivity implements EndpointCallback {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progress);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        progressBar.setVisibility(View.VISIBLE);
        new EndpointsAsyncTask(this).execute(new Pair<Context, String>(this, "Manfred"));
    }


    @Override
    public void onResultOk(String value) {
        progressBar.setVisibility(View.GONE);

        Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra(Constants.PARAM_JOKE, value);
        this.startActivity(intent);
    }

    @Override
    public void onError(String error) {
        Toast.makeText(this, "Something is wrong: " + error, Toast.LENGTH_SHORT).show();
    }
}
