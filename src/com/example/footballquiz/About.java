package com.example.footballquiz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class About extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        TextView about = (TextView) findViewById(R.id.TextView01);
        about.setText("About");	
        TextView about0 = (TextView) findViewById(R.id.TextView02);
        about0.setText("I have a big interest for sports so I came up with the idea to do this fantastic, at least I hope, game. I am just a human, so it might be errors in the program and if you spot any, please let me know");
        
    }
}