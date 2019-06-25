package com.example.footballquiz;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.openfeint.api.OpenFeint;
import com.openfeint.api.resource.Leaderboard;
import com.openfeint.api.resource.Score;
import android.widget.Toast; // Used for presenting diagnostic messages. 

public class Teams extends Activity {
	public int index;	
	private int correctImageButtonId;
	private int question;
	private int correctButtonId;
	
	private Timer timer;
	private TextView counterView;
	
	
	private final Handler handler = new Handler() {
		
        public void  handleMessage(Message msg) {
             //update your view from here only.
        	if(msg.what == 0){
        		cancelGame();
        	} else {
        		counterView.setText(String.valueOf(msg.what));
        	}
        }
   };
	
		
    @Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
    	startActivity(new Intent(this, FootballQuiz.class));
		super.onBackPressed();
		DataHolder.points = 0;
		finish();
	}
    
    @Override
    public void onResume() {
    	OpenFeint.setCurrentActivity(this);
    	super.onResume();
    } 

    public void cancelGame() {
		if(timer != null){
			timer.cancel();
		}
	    counterView.setText("0");
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Do you want to submit your score?")
			.setCancelable(false)
			.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					long scoreValue = DataHolder.points;
					// Second parameter is null to indicate that custom display text is not used.
					Score s = new Score(scoreValue, null);
					Leaderboard l = new Leaderboard("593104");
					s.submitTo(l, new Score.SubmitToCB() {
					    @Override public void onSuccess(boolean newHighScore) { // sweet, score was posted
					         Teams.this.setResult(Activity.RESULT_OK);
					         Teams.this.finish();
					    }
					    @Override public void onFailure(String exceptionMessage) {
					          Toast.makeText(Teams.this,
					               "Error (" + exceptionMessage + ") posting score.",
					               Toast.LENGTH_SHORT).show();
					          Teams.this.setResult(Activity.RESULT_CANCELED);
					          Teams.this.finish();
					     }
					});
					DataHolder.points = 0;
					startActivity(new Intent(Teams.this, FootballQuiz.class));
					finish();
				}
			})
			.setNegativeButton("No", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					DataHolder.points = 0;
					startActivity(new Intent(Teams.this, FootballQuiz.class));
					finish();
					
				}
			}).show();

	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);   
	    setContentView(R.layout.teams);  
	    initImages();
 	    Typeface face1=Typeface.createFromAsset(getAssets(),
		"fonts/varsity_regular.ttf");
	    visibility(true);
	    TextView points = (TextView) findViewById(R.id.TextView02);
	    points.setText(String.valueOf(DataHolder.points));
	    counterView = (TextView) findViewById(R.id.TextView03);
	    counterView.setText("");
	    counterView.setTypeface(face1);
	    points.setTypeface(face1);
	    final OnClickListener onClickListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(correctImageButtonId == v.getId()){
					//right.start();
					visibility(false);
					DataHolder.points = DataHolder.points + 50;
					TextView textView2 = (TextView) findViewById(R.id.TextView03);
			        textView2.setText(String.valueOf(DataHolder.points));
			        level1();
				} else {
					//wrong.start();
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
	    
	    timer();
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
	
	private void setUpLevel(final int level) {
		if(level == 1) {
			question = (int)(Math.random()*3);
		}
		else {	
			question = (int)((Math.random()*3)+ 3);
		}
        setTitle("Level " + level);
		answers();
        TextView textView1 = (TextView) findViewById(R.id.TextView04);
        textView1.setText(DataHolder.question[question]);
		
	}
    private void level1() {
        TextView textView = (TextView) findViewById(R.id.TextView01);
        textView.setText(DataHolder.teams[index]);
        final TextView textView2 = (TextView) findViewById(R.id.TextView02);
        textView2.setText(String.valueOf(DataHolder.points));
        final Typeface face=Typeface.createFromAsset(getAssets(),
		"fonts/varsity_regular.ttf");
		textView2.setTypeface(face);
		final OnClickListener onClickListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(v.getId() == correctButtonId){
					//right.start();
					DataHolder.points += 100;
			        textView2.setText(String.valueOf(DataHolder.points));
					level2();
				} else {
					//wrong.start();
					visibility(true);
					initImages();
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
	    
		setUpLevel(1);		
	}
	
	private void level2() {
		setUpLevel(2);
        final OnClickListener onClickListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(v.getId() == correctButtonId){
					//right.start();
					DataHolder.points = DataHolder.points + 200;
			        TextView textView2 = (TextView) findViewById(R.id.TextView02);
			        textView2.setText(String.valueOf(DataHolder.points));
			        visibility(true);
			        initImages();
				} else {
					//wrong.start();
					visibility(true);
					initImages();
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
		
		ImageView imageView = (ImageView) findViewById(R.id.ImageButton01);
	    ImageView imageView0 = (ImageView) findViewById(R.id.ImageButton02);
	    ImageView imageView1 = (ImageView) findViewById(R.id.ImageButton03);
	    ImageView imageView2 = (ImageView) findViewById(R.id.ImageButton04);
	     
	    imageView.setVisibility(View.INVISIBLE);
	    imageView0.setVisibility(View.INVISIBLE);
	    imageView1.setVisibility(View.INVISIBLE);
	    imageView2.setVisibility(View.INVISIBLE);
    }
	
	private void answers() {
    	int index1 = (int)(Math.random()*101);
    	int index2 = (int)(Math.random()*101);
    	int index3 = (int)(Math.random()*101);
    	
    	if(question == 4) {
       		index = DataHolder.titles[index];
       		index1 = (int)(Math.random()*45);
       		index2 = (int)(Math.random()*45);
       		index3 = (int)(Math.random()*45);
       		
       		while(index == index1){
           		index1 = (int)(Math.random()*45);
            }
           	while(index == index2){
           		index2 = (int)(Math.random()*45);
           	}
           	while(index == index3){
           		index3 = (int)(Math.random()*45);
           	}
           	while(index1 == index2){
           		index2 = (int)(Math.random()*45);
            }
           	while(index1 == index3){
           		index3 = (int)(Math.random()*45);
           	}
           	while(index2 == index3){
           		index3 = (int)(Math.random()*45);
           	}
       	}
       	if(question == 5) {
       		index = DataHolder.year1[index];
       		index1 = (int)(Math.random()*132 + 1863);
       		index2 = (int)(Math.random()*132 + 1863);
       		index3 = (int)(Math.random()*132 + 1863);
       		
       		while(index == index1){
           		index1 = (int)(Math.random()*132 + 1863);
            }
           	while(index == index2){
           		index2 = (int)(Math.random()*132 + 1863);
           	}
           	while(index == index3){
           		index3 = (int)(Math.random()*132 + 1863);
           	}
           	while(index1 == index2){
           		index2 = (int)(Math.random()*132 + 1863);
            }
           	while(index1 == index3){
           		index3 = (int)(Math.random()*132 + 1863);
           	}
           	while(index2 == index3){
           		index3 = (int)(Math.random()*132 + 1863);
           	}
       	}
    	
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

        TextView textView2 = (TextView) findViewById(R.id.Button01);
        TextView textView2a = (TextView) findViewById(R.id.Button02);
        TextView textView2b = (TextView) findViewById(R.id.Button03);
        TextView textView2c = (TextView) findViewById(R.id.Button04);
        
        final Integer[] randomInts = getRandomOrderedArray1(index, index3, index2, index1);
        if(randomInts[0] == index){
        	correctButtonId = R.id.Button01;
        } else if(randomInts[1] == index){
        	correctButtonId = R.id.Button02;
        }else if(randomInts[2] == index){
        	correctButtonId = R.id.Button03;
        } else {
        	correctButtonId = R.id.Button04;
        }
        
        if(question == 0) {
        	textView2.setText(DataHolder.player[randomInts[0]]);
        	textView2a.setText(DataHolder.player[randomInts[1]]);
        	textView2b.setText(DataHolder.player[randomInts[2]]);
        	textView2c.setText(DataHolder.player[randomInts[3]]);
        }
        else if(question == 1) {
            textView2.setText(DataHolder.stadium[randomInts[0]]);
            textView2a.setText(DataHolder.stadium[randomInts[1]]);
            textView2b.setText(DataHolder.stadium[randomInts[2]]);
            textView2c.setText(DataHolder.stadium[randomInts[3]]);
        }
        else if(question == 2) {
            textView2.setText(DataHolder.trainer[randomInts[0]]);
            textView2a.setText(DataHolder.trainer[randomInts[1]]);
            textView2b.setText(DataHolder.trainer[randomInts[2]]);
            textView2c.setText(DataHolder.trainer[randomInts[3]]);
        }
        else if(question == 3) {
            textView2.setText(DataHolder.capacity[randomInts[0]]);
            textView2a.setText(DataHolder.capacity[randomInts[1]]);
            textView2b.setText(DataHolder.capacity[randomInts[2]]);
            textView2c.setText(DataHolder.capacity[randomInts[3]]);
        }
        else if(question == 4) {
            textView2.setText(Integer.toString(randomInts[0]));
            textView2a.setText(Integer.toString(randomInts[1]));
            textView2b.setText(Integer.toString(randomInts[2]));
            textView2c.setText(Integer.toString(randomInts[3]));
        }
        else if(question == 5) {
            textView2.setText(Integer.toString(randomInts[0]));
            textView2a.setText(Integer.toString(randomInts[1]));
            textView2b.setText(Integer.toString(randomInts[2]));
            textView2c.setText(Integer.toString(randomInts[3]));
        }
        else if(question == 6) {
            textView2.setText(DataHolder.games[randomInts[0]]);
            textView2a.setText(DataHolder.games[randomInts[1]]);
            textView2b.setText(DataHolder.games[randomInts[2]]);
            textView2c.setText(DataHolder.games[randomInts[3]]);
        }
        else if(question == 7) {
            textView2.setText(DataHolder.goals[randomInts[0]]);
            textView2a.setText(DataHolder.goals[randomInts[1]]);
            textView2b.setText(DataHolder.goals[randomInts[2]]);
            textView2c.setText(DataHolder.goals[randomInts[3]]);
        }        

	}
	private Integer[] getRandomOrderedArray1(int a, int b, int c, int d) {
		final LinkedList<Integer> ll = new LinkedList<Integer>();  
		ll.add(a);
		ll.add(b);
		ll.add(c);
		ll.add(d);
	    Collections.shuffle(ll);  
	  
		return ll.toArray(new Integer[4]);
	}
	
	private void visibility(boolean teams) {
		if(teams == true) {
			final Button Button = (Button) findViewById(R.id.Button01);
			final Button Button0 = (Button) findViewById(R.id.Button02);
			final Button Button1 = (Button) findViewById(R.id.Button03);
			final Button Button2 = (Button) findViewById(R.id.Button04);
			
			ImageView imageView = (ImageView) findViewById(R.id.ImageButton01);
	        ImageView imageView0 = (ImageView) findViewById(R.id.ImageButton02);
	        ImageView imageView1 = (ImageView) findViewById(R.id.ImageButton03);
	        ImageView imageView2 = (ImageView) findViewById(R.id.ImageButton04);
	        
		    imageView.setVisibility(View.VISIBLE);
		    imageView0.setVisibility(View.VISIBLE);
		    imageView1.setVisibility(View.VISIBLE);
		    imageView2.setVisibility(View.VISIBLE);
		    
			Button.setVisibility(View.INVISIBLE);
			Button0.setVisibility(View.INVISIBLE);
			Button1.setVisibility(View.INVISIBLE);
			Button2.setVisibility(View.INVISIBLE);
			
			TextView textView1 = (TextView) findViewById(R.id.TextView04);
	        textView1.setVisibility(View.INVISIBLE);
		}
		else {
			Button Button = (Button) findViewById(R.id.Button01);
			Button Button0 = (Button) findViewById(R.id.Button02);
			Button Button1 = (Button) findViewById(R.id.Button03);
			Button Button2 = (Button) findViewById(R.id.Button04);
			
			ImageView imageView = (ImageView) findViewById(R.id.ImageButton01);
		    ImageView imageView0 = (ImageView) findViewById(R.id.ImageButton02);
		    ImageView imageView1 = (ImageView) findViewById(R.id.ImageButton03);
		    ImageView imageView2 = (ImageView) findViewById(R.id.ImageButton04);
		    
			Button.setVisibility(View.VISIBLE);
			Button0.setVisibility(View.VISIBLE);
			Button1.setVisibility(View.VISIBLE);
			Button2.setVisibility(View.VISIBLE);
			
			TextView textView1 = (TextView) findViewById(R.id.TextView04);
	        textView1.setVisibility(View.VISIBLE);
		     
		    imageView.setVisibility(View.INVISIBLE);
		    imageView0.setVisibility(View.INVISIBLE);
		    imageView1.setVisibility(View.INVISIBLE);
		    imageView2.setVisibility(View.INVISIBLE);
		    
		}	
	}
	private void timer() {
		timer = new Timer(false);
		final AtomicInteger counter = new AtomicInteger(60); 
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				
				final int decrementAndGet = counter.decrementAndGet();
				final Message message = new Message();
				message.what = decrementAndGet;
				handler.sendMessage(message);
			}
		}, 1000L, 1000L);


	}

}