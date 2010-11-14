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
	private int index3;
	private int index1;
	private int index2;
	
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teams);     
        initImages();
        
        final OnClickListener onClickListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(v.getId() == R.id.ImageButton01){
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
        index1 = (int)(Math.random()*101);
        index2 = (int)(Math.random()*101);
        index3 = (int)(Math.random()*101);
    
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
        final Integer[] randomInts = getRandomOrderedArray(DataHolder.teamImages[index], DataHolder.teamImages[index3], DataHolder.teamImages[index2], DataHolder.teamImages[index1]);
        
        imageView.setImageResource(randomInts[0]);
        imageView0.setImageResource(randomInts[1]);
        imageView1.setImageResource(randomInts[2]);
        imageView2.setImageResource(randomInts[3]);
        
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