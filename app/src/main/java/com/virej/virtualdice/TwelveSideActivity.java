package com.virej.virtualdice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class TwelveSideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twelve_side);


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



        final ImageView twelvesidedice = (ImageView) findViewById(R.id.defaulttwelvedice);

        //This is an array of the faces of the dice
        final int[] twelvedicearray = {
                R.drawable.twelveside1,
                R.drawable.twelveside2,
                R.drawable.twelveside3,
                R.drawable.twelveside4,
                R.drawable.twelveside5,
                R.drawable.twelveside6,
                R.drawable.twelveside7,
                R.drawable.twelveside8,
                R.drawable.twelveside9,
                R.drawable.twelveside10,
                R.drawable.twelveside11,
                R.drawable.twelveside12
        };

        //This is an OnClickListener for the roll button. When it is clicked, a random picture from the array is taken
        Button rollbutton;
        rollbutton = findViewById(R.id.rollbutton);
        rollbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("virtualdice", "onClick:rollbutton pressed ");
                Random randomnumber = new Random();
                int number = randomnumber.nextInt(12);
                Log.d("virtualdice", "onClick: random number is: "+ number);

                twelvesidedice.setImageResource(twelvedicearray[number]);


            }
        });



        //This is a ClickListener for the about creator button. It opens CreatorActivity
        Button aboutbutton = findViewById(R.id.aboutbutton);
        aboutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TwelveSideActivity.this, CreatorActivity.class );
                startActivity(intent);
            }
        });

        //This is another Listener, it opens the ListActivity
        Button otherdicebutton = findViewById(R.id.otherdicebutton);
        otherdicebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(TwelveSideActivity.this, ListActivity.class);
                startActivity(intent1);
            }
        });
    }
}