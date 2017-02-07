package com.example.jokeview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        String joke = getIntent().getStringExtra(Constants.PARAM_JOKE);

        TextView textViewJoke = (TextView) findViewById(R.id.text_joke);
        textViewJoke.setText(joke);
    }
}
