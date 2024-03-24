package com.ctos.poemebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DiscoverActivity extends AppCompatActivity {

    CardView cardViewHaiku, cardViewFreeVerse,cardViewSonnet, cardViewAcrostic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);

        cardViewHaiku = findViewById(R.id.cardViewHaiku);
        cardViewHaiku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HaikuActivity.class);
                startActivity(intent);
            }
        });
        cardViewFreeVerse = findViewById(R.id.cardViewFreeVerse);
        cardViewFreeVerse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        cardViewSonnet = findViewById(R.id.cardViewSonnet);
        cardViewSonnet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        cardViewAcrostic = findViewById(R.id.cardViewAcrostic);
        cardViewAcrostic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}