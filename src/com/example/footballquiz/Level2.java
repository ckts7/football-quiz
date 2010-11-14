package com.example.footballquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Level2 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level2);
        String [] team  = new String[1000];
        final int index = (int)(Math.random()*4);
        team[0] = "How many league titles have they won?";
        team[1] = "What is the maximum attandence in 1 game for this club?";
        team[2] = "Who has made the most appearances for the club?";
        team[3] = "Who has scored the most goals?";
        TextView textView = (TextView) findViewById(R.id.TextView01);
        textView.setText(team[index]);
        final Button Button = (Button) findViewById(R.id.Button02);
		Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Level2.this, Level3.class));
			}
        });
    }
}
