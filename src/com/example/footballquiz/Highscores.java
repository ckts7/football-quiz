package com.example.footballquiz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Highscores extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscores);
        TextView high = (TextView) findViewById(R.id.TextView01);
        high.setText("Highscores");
    }
}