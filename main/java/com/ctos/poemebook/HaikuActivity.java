package com.ctos.poemebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HaikuActivity extends AppCompatActivity {
    TextView textViewMoon, textViewButterfly, textViewPuddle, textViewSecret, textViewDragon, textViewFrog, textViewSneaky, textViewRanbow, textViewWhale, textViewGarden;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haiku);

        textViewMoon = findViewById(R.id.editTextText1);
        textViewMoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HaikuMoonlitActivity.class);
                startActivity(intent);
            }
        });

        textViewButterfly = findViewById(R.id.editTextText2);
        textViewButterfly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HaikuButterflyActivity.class);
                startActivity(intent);
            }
        });
        textViewPuddle = findViewById(R.id.editTextText3);
        textViewPuddle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HaikuPuddleActivity.class);
                startActivity(intent);
            }
        });
        textViewSecret = findViewById(R.id.editTextText4);
        textViewSecret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HaikuSecretActivity.class);
                startActivity(intent);
            }
        });
        textViewDragon = findViewById(R.id.editTextText5);
        textViewDragon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HaikuDragonActivity.class);
                startActivity(intent);
            }
        });
        textViewFrog = findViewById(R.id.editTextText6);
        textViewFrog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HaikuFrogActivity.class);
                startActivity(intent);
            }
        });
        textViewSneaky = findViewById(R.id.editTextText7);
        textViewSneaky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HaikuSquirrelActivity.class);
                startActivity(intent);
            }
        });
        textViewRanbow = findViewById(R.id.editTextText8);
        textViewRanbow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HaikuRainbowActivity.class);
                startActivity(intent);
            }
        });
        textViewWhale = findViewById(R.id.editTextText9);
        textViewWhale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HaikuWhaleActivity.class);
                startActivity(intent);
            }
        });
        textViewGarden = findViewById(R.id.editTextText10);
        textViewGarden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HaikuGardenActivity.class);
                startActivity(intent);
            }
        });
    }
}