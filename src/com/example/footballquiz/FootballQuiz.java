package com.example.footballquiz;

import com.openfeint.api.OpenFeint;
import com.openfeint.api.OpenFeintDelegate;
import com.openfeint.api.OpenFeintSettings;
import com.openfeint.api.ui.Dashboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;


public class FootballQuiz extends Activity {
    /** Called when the activity is first created. */

    @Override
    public void onResume() {
    	super.onResume();
    	OpenFeint.setCurrentActivity(this);
    }
	public void launchFeint() {                  //show the OpenFeint log-in
	    Dashboard.open();
	}
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	OpenFeintSettings settings = new OpenFeintSettings("Football Quiz", "c0ChRXRiHHHXezU8H8YlFQ", "qvNFBKJUQYNuWE0pGtK860sMq2iGiwI6uHyuODSFs", "208892");
    	OpenFeint.initialize(this, settings, new OpenFeintDelegate() {});
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);        
        final ImageButton imageButton0 = (ImageButton) findViewById(R.id.ImageButton01);
        imageButton0.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(FootballQuiz.this, Teams.class));
			}					
		});
        final ImageButton imageButton1 = (ImageButton) findViewById(R.id.ImageButton02);
        imageButton1.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		//TODO Auto-generated method stub
        		launchFeint();
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