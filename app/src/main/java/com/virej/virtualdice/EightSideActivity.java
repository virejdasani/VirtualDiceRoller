package com.virej.virtualdice;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Random;

public class EightSideActivity extends AppCompatActivity {

    private ObjectAnimator anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight_side);

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



        //This is a ClickListener for the about creator button. It opens CreatorActivity
        Button aboutbutton = findViewById(R.id.aboutbutton);
        aboutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EightSideActivity.this, CreatorActivity.class );
                startActivity(intent);
            }
        });

        //This is another Listener, it opens the ListActivity
        Button otherdicebutton = findViewById(R.id.otherdicebutton);
        otherdicebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(EightSideActivity.this, ListActivity.class);
                startActivity(intent1);
            }
        });


        final ImageView eightsidedice = (ImageView) findViewById(R.id.defaulteightdice);

        //This is an array of the faces of the dice
        final int[] eightdicearray = {
                R.drawable.eightside1,
                R.drawable.eightside2,
                R.drawable.eightside3,
                R.drawable.eightsided4,
                R.drawable.eightsided5,
                R.drawable.eightsided6,
                R.drawable.eightsided8,
                R.drawable.eightsided7,
                R.drawable.eightsided8
        };

        //This is an OnClickListener for the roll button. When it is clicked, a random picture from the array is taken
        Button rollbutton;
        rollbutton = findViewById(R.id.rollbutton);
        rollbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceSoundMP.start();

                anim = ObjectAnimator.ofFloat(eightsidedice, "rotation", 0, 360);
                anim.setDuration(565);
                anim.setRepeatCount(0);
                anim.setRepeatMode(ObjectAnimator.RESTART);
                startAnimation(eightsidedice);

                Log.d("virtualdice", "onClick:rollbutton pressed ");
                Random randomnumber = new Random();
                int number = randomnumber.nextInt(6);
                Log.d("virtualdice", "onClick: random number is: "+ number);

                eightsidedice.setImageResource(eightdicearray[number]);


            }
        });

    }
    public void startAnimation(View view) {
        anim.start();
    }
}