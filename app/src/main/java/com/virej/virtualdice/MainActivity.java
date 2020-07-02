//MainActivity.java



package com.virej.virtualdice;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;



import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private ObjectAnimator anim;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this is for the sound of the dice it starts in the OnCLickListener in the roll button
        final MediaPlayer diceSoundMP = MediaPlayer.create(this, R.raw.dicerollvirtualdicesound);


        //This is the admob initialiser
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        //This is a placed an a dview
        AdView adView = (AdView) findViewById(R.id.adView);

        //This is to request an ad

        AdRequest adRequest = new AdRequest.Builder()
                .build();

        //This is to load ad
        adView.loadAd(adRequest);




        //This initialises a button to rollbutton variable
        Button rollbutton;
        rollbutton = (Button)findViewById(R.id.rollbutton);


        //This creates 2 variables leftdice and rightdice and stores the ids of the respective images
        final ImageView leftdice = (ImageView) findViewById(R.id.dice2_left);
        final ImageView rightdice = (ImageView) findViewById(R.id.dice1_right);

        //This is an array of the faces of the dice
        final int[] dicearray = {
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6
        };




        //This is an OnClickListener for the roll button. When it is clicked, a random picture from the array is taken
        //It happens for both the left and right dice
        rollbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                diceSoundMP.start();

                //animation left dice
                anim = ObjectAnimator.ofFloat(leftdice, "rotation", 0, 360);
                anim.setDuration(650);
                anim.setRepeatCount(0);
                anim.setRepeatMode(ObjectAnimator.RESTART);
                startAnimation(leftdice);

                //animation right dice
                anim = ObjectAnimator.ofFloat(rightdice, "rotation", 0, 360);
                anim.setDuration(650);
                anim.setRepeatCount(0);
                anim.setRepeatMode(ObjectAnimator.RESTART);
                startAnimation(rightdice);



                Log.d("dicee", "onClick:rollbutton pressed ");
                Random randomnumber = new Random();
                int number = randomnumber.nextInt(6);
                Log.d("dicee", "onClick: random number is: "+ number);


                leftdice.setImageResource(dicearray[number]);



                randomnumber = new Random();
                int newnumber = randomnumber.nextInt(6);

                rightdice.setImageResource(dicearray[newnumber]);



            }
        });
        //This is another ClickListener for the about creator button. It opens CreatorActivity
        Button aboutbutton = findViewById(R.id.aboutbutton);
        aboutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentcreator = new Intent(MainActivity.this, CreatorActivity.class );
                startActivity(intentcreator);
            }
        });




        //This is another Listener, it opens the ListActivity
        Button otherdicebutton = findViewById(R.id.otherdicebutton);
        otherdicebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentmainmenu = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intentmainmenu);
            }
        });



    }
    public void startAnimation(View view) {
        anim.start();
    }


}




