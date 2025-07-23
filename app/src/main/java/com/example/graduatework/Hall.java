package com.example.graduatework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Hall extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hall_layout);

        ImageView hallTwoArrow = findViewById(R.id.hall_two_arrow);
        Button shelfButtonOne = findViewById(R.id.shelf_one);
        Button shelfButtonTwo = findViewById(R.id.shelf_two);

        shelfButtonOne.setOnClickListener(v -> openTargetActivity("shelf_content_one"));
        shelfButtonTwo.setOnClickListener(v -> openTargetActivity("shelf_content_two"));


        hallTwoArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Hall.this, HallTwo.class);
                startActivity(intent);
            }
        });
    }

    private void openTargetActivity(String type) {
        Intent intent = new Intent(this, Shelf.class);
        intent.putExtra("content_type", type);
        intent.putExtra("source", "hall");
        startActivity(intent);
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}