//MainActivity.java



package com.virej.virtualdice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;



import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





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


}




