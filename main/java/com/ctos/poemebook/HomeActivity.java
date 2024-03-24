package com.ctos.poemebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity {
    CircleImageView circleImageViewDiscover;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        circleImageViewDiscover = findViewById(R.id.DiscovermyCircleImageButton);
        circleImageViewDiscover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DiscoverActivity.class);
                startActivity(intent);
            }
        });
    }
}