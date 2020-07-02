package com.virej.virtualdice;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.Image;
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

public class TenSidedActivity extends AppCompatActivity {

    private ObjectAnimator anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ten_sided);

        final MediaPlayer diceSoundMP = MediaPlayer.create(this, R.raw.dicerollvirtualdicesound);


        //This is the admob initialiser
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        //This is a placed an adview
        AdView adView = (AdView) findViewById(R.id.adView);

        //This is to request an ad

        AdRequest adRequest = new AdRequest.Builder()
                .build();

        //This is to load ad
        adView.loadAd(adRequest);


        //This is another ClickListener for the about creator button. It opens CreatorActivity
        Button aboutbutton = findViewById(R.id.aboutbutton);
        aboutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TenSidedActivity.this, CreatorActivity.class );
                startActivity(intent);
            }
        });

        //This is another Listener, it opens the ListActivity
        Button otherdicebutton = findViewById(R.id.otherdicebutton);
        otherdicebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(TenSidedActivity.this, ListActivity.class);
                startActivity(intent1);
            }
        });

        //array for all ten sided dice images
        final int[] tensidedicearray = {
                R.drawable.tensided1,
                R.drawable.tensided2,
                R.drawable.tensided3,
                R.drawable.tensided4,
                R.drawable.tensided5,
                R.drawable.tensided6,
                R.drawable.tensided7,
                R.drawable.tensided8,
                R.drawable.tensided9,
                R.drawable.tensided10
        };
        final ImageView tensideddicedefault =(ImageView) findViewById(R.id.tensidedicedefault);
        Button rollbutton;
        rollbutton = findViewById(R.id.rollbutton);
        rollbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                anim = ObjectAnimator.ofFloat(tensideddicedefault, "rotation", 0, 360);
                anim.setDuration(600);
                anim.setRepeatCount(0);
                anim.setRepeatMode(ObjectAnimator.RESTART);
                startAnimation(tensideddicedefault);

                diceSoundMP.start();

                Log.d("virtualdice", "onClick:rollbutton pressed ");
                Random randomnumber = new Random();
                int number = randomnumber.nextInt(10);
                Log.d("virtualdice", "onClick: random number is: "+ number);
                tensideddicedefault.setImageResource(tensidedicearray[number]);



    }
});
    }
    public void startAnimation(View view) {
        anim.start();
    }
}