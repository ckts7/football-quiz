package com.example.footballquiz;

import java.util.Collections;
import java.util.LinkedList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Teams extends Activity {
	
	private int index;
	
	private int correctImageButtonId;
	
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teams);     
        initImages();
        
        final OnClickListener onClickListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(correctImageButtonId == v.getId()){
					Intent intent = new Intent(Teams.this, Level1.class);
					intent.putExtra("team", DataHolder.teams[index]);
					startActivity(intent);
				} else {
					initImages();
				}
				
			}
        };
        
        final ImageButton imageButton = (ImageButton) findViewById(R.id.ImageButton01);
        final ImageButton imageButton0 = (ImageButton) findViewById(R.id.ImageButton02);
        final ImageButton imageButton1 = (ImageButton) findViewById(R.id.ImageButton03);
        final ImageButton imageButton2 = (ImageButton) findViewById(R.id.ImageButton04);
        
        imageButton.setOnClickListener(onClickListener);
        imageButton0.setOnClickListener(onClickListener);
        imageButton1.setOnClickListener(onClickListener);
        imageButton2.setOnClickListener(onClickListener);
		
    }

	private void initImages() {
		
		index = (int)(Math.random()*101);
        int index1 = (int)(Math.random()*101);
        int index2 = (int)(Math.random()*101);
        int index3 = (int)(Math.random()*101);
    
        while(index == index1){
        	index1 = (int)(Math.random()*101);
        }
        while(index == index2){
        	index2 = (int)(Math.random()*101);
        }
        while(index == index3){
        	index3 = (int)(Math.random()*101);
        }
        while(index1 == index2){
        	index2 = (int)(Math.random()*101);
        }
        while(index1 == index3){
        	index3 = (int)(Math.random()*101);
        }
        while(index2 == index3){
        	index3 = (int)(Math.random()*101);
        }        

        TextView textView = (TextView) findViewById(R.id.TextView01);
        textView.setText(DataHolder.teams[index]);
          
        ImageView imageView = (ImageView) findViewById(R.id.ImageButton01);
        ImageView imageView0 = (ImageView) findViewById(R.id.ImageButton02);
        ImageView imageView1 = (ImageView) findViewById(R.id.ImageButton03);
        ImageView imageView2 = (ImageView) findViewById(R.id.ImageButton04);
        
        // get a random list of image id's
        final Integer[] randomInts = getRandomOrderedArray(index, index3, index2, index1);
        
        
        if(randomInts[0] == index){
        	correctImageButtonId = R.id.ImageButton01;
        } else if(randomInts[1] == index){
        	correctImageButtonId = R.id.ImageButton02;
        }else if(randomInts[2] == index){
        	correctImageButtonId = R.id.ImageButton03;
        } else {
        	correctImageButtonId = R.id.ImageButton04;
        }
        
        imageView.setImageResource(DataHolder.teamImages[randomInts[0]]);
        imageView0.setImageResource(DataHolder.teamImages[randomInts[1]]);
        imageView1.setImageResource(DataHolder.teamImages[randomInts[2]]);
        imageView2.setImageResource(DataHolder.teamImages[randomInts[3]]);
        
	}

	private Integer[] getRandomOrderedArray(int i, int j, int k, int l) {
		final LinkedList<Integer> ll = new LinkedList<Integer>();  
		ll.add(i);
		ll.add(j);
		ll.add(k);
		ll.add(l);
	    Collections.shuffle(ll);  
	  
		return ll.toArray(new Integer[4]);
	}
    
}