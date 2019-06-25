package com.example.footballquiz;

import com.openfeint.api.OpenFeint;

import android.app.Activity;
import android.os.Bundle;

public class About extends Activity {
    @Override
    public void onResume() {
    	super.onResume();
    	OpenFeint.setCurrentActivity(this);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
  }
}