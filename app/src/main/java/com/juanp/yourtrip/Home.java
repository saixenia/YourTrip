package com.juanp.yourtrip;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Home extends Activity {
private  final int duracionsplash=2000;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
new Handler().postDelayed(new Runnable() {

    public void run() {
        Intent intent = new Intent(Home.this,Login.class);
        startActivity(intent);
        finish();
    }
},duracionsplash);

    }
}
///perrro
