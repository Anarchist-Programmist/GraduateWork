package com.example.graduatework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class HallTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hall_two_layout);

        ImageView HallDownArrow = findViewById(R.id.down_arrow);

        Button shelfTwoButtonOne = findViewById(R.id.shelf_one_hall_two);
        Button shelfTwoButtonTwo = findViewById(R.id.shelf_two_hall_two);
        Button shelfTwoButtonThree = findViewById(R.id.shelf_three_hall_two);
        Button shelfTwoButtonFour = findViewById(R.id.shelf_four_hall_two);
        Button shelfTwoButtonFive = findViewById(R.id.shelf_five_hall_two);
        Button shelfTwoButtonSix = findViewById(R.id.shelf_six_hall_two);

        Button pedestalButtonOne = findViewById(R.id.pedestal_one_hall_two);
        Button pedestalButtonTwo = findViewById(R.id.pedestal_two_hall_two);

        shelfTwoButtonOne.setOnClickListener(v -> openTargetActivity("shelf_two_content_one"));
        shelfTwoButtonTwo.setOnClickListener(v -> openTargetActivity("shelf_two_content_two"));
        shelfTwoButtonThree.setOnClickListener(v -> openTargetActivity("shelf_two_content_three"));
        shelfTwoButtonFour.setOnClickListener(v -> openTargetActivity("shelf_two_content_four"));
        shelfTwoButtonFive.setOnClickListener(v -> openTargetActivity("shelf_two_content_five"));
        shelfTwoButtonSix.setOnClickListener(v -> openTargetActivity("shelf_two_content_six"));

        pedestalButtonOne.setOnClickListener(v -> openTargetActivity("pedestal_one_content"));
        pedestalButtonTwo.setOnClickListener(v -> openTargetActivity("pedestal_two_content"));

        HallDownArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HallTwo.this, Hall.class);
                startActivity(intent);
            }
        });
    }

    private void openTargetActivity(String type) {
        Intent intent = new Intent(this, Shelf.class);
        intent.putExtra("content_type_two", type);
        intent.putExtra("source", "hall_two");
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
