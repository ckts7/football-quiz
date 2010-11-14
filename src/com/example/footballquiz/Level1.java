package com.example.footballquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Level1 extends Activity {
	private int level = 1;	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level1);
        String [] team  = new String[1000];
        final int index = (int)(Math.random()*7);
        team[0] = "What year was the club founded?";
        team[1] = "What is the name of the clubs stadium?";
        team[2] = "What is the color of the teams home jersey?";
        team[3] = "Who is their current trainer?";
        team[4] = "What's the name of this player?";
        team[5] = "What's the teams nickname?";
        team[6] = "In which city does the team have their home stadium?";
        final String teamName = (String) getIntent().getSerializableExtra("team");
        
        TextView textView = (TextView) findViewById(R.id.TextView01);
        textView.setText(teamName);
        TextView textView1 = (TextView) findViewById(R.id.TextView02);
        textView1.setText(team[index]);
        setTitle("Level" + level);
        final OnClickListener onClickListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(v.getId() == R.id.Button03){
					startActivity(new Intent(Level1.this, Level2.class));
				} else {
					startActivity(new Intent(Level1.this, Teams.class));
				}
			}
        };
		final Button Button = (Button) findViewById(R.id.Button01);
		final Button Button0 = (Button) findViewById(R.id.Button02);
		final Button Button1 = (Button) findViewById(R.id.Button03);
		final Button Button2 = (Button) findViewById(R.id.Button04);

		Button.setOnClickListener(onClickListener);
		Button0.setOnClickListener(onClickListener);
		Button1.setOnClickListener(onClickListener);
		Button2.setOnClickListener(onClickListener);
    }
}
