//ListActivity.java



package com.virej.virtualdice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


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

        //This will redirect to MainActivity which is classic 6-sided dice when that button is pressed
        final Button sixsided = findViewById(R.id.sixsided);
        sixsided.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentfoursided = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intentfoursided);
            }
        });

        //This redirects to the EightSidedActivity when eightsided button is pressed
        final Button eightsided = findViewById(R.id.eightsided);
        eightsided.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenteightsided = new Intent(ListActivity.this, EightSideActivity.class);
                startActivity(intenteightsided);
            }
        });

        final Button tensided = findViewById(R.id.tensidedbutton);
        tensided.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenttensided = new Intent(ListActivity.this, TenSidedActivity.class);
                startActivity(intenttensided);
            }
        });

        //This will redirect to TwelveSideActivity
        Button twelvesided = findViewById(R.id.twelvesidedbutton);
        twelvesided.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent twelvesideintent = new Intent(ListActivity.this, TwelveSideActivity.class);
                startActivity(twelvesideintent);
            }
        });

        //This will redirect to TwentyfourSideActivity
        Button twentyfourside = findViewById(R.id.twentyfoursidedbutton);
        twentyfourside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent twentyfoursideintent = new Intent(ListActivity.this, TwentyfourSideActivity.class);
                startActivity(twentyfoursideintent);
            }

        });

    }
}