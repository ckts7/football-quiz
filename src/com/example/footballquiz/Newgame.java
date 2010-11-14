package com.example.footballquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class Newgame extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newgame);
        final ImageButton imageButton = (ImageButton) findViewById(R.id.ImageButton03);
		imageButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Newgame.this, Teams.class));
			}
        });
        final ImageButton imageButton1 = (ImageButton) findViewById(R.id.ImageButton02);
		imageButton1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Newgame.this, TeamsTime.class));
			}
        });
    }
}

	