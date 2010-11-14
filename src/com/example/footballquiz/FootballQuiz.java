package com.example.footballquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class FootballQuiz extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        
        final ImageButton imageButton = (ImageButton) findViewById(R.id.ImageButton01);
        imageButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(FootballQuiz.this, Newgame.class));
			}					
		});
        final ImageButton imageButton1 = (ImageButton) findViewById(R.id.ImageButton02);
        imageButton1.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		//TODO Auto-generated method stub
        		startActivity(new Intent(FootballQuiz.this, Highscores.class));
        	}
        });
        final ImageButton imageButton2 = (ImageButton) findViewById(R.id.ImageButton03);
        imageButton2.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		//TODO Auto-generated method stub
        		startActivity(new Intent(FootballQuiz.this, About.class));
        	}
        });
    }
}