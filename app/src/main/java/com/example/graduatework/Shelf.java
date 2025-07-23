package com.example.graduatework;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class Shelf extends AppCompatActivity {

    MyDatabase dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shelf_layout);

        dbHelper = new MyDatabase(this);

        String contentType = getIntent().getStringExtra("content_type");
        String contentTypeTwo = getIntent().getStringExtra("content_type_two");

        Button back = findViewById(R.id.back);

        ImageView background = findViewById(R.id.background_shelf);

        ImageView exhibit1 = findViewById(R.id.exhibit_1);
        ImageView exhibit2 = findViewById(R.id.exhibit_2);
        ImageView exhibit3 = findViewById(R.id.exhibit_3);
        ImageView exhibit4 = findViewById(R.id.exhibit_4);
        ImageView exhibit5 = findViewById(R.id.exhibit_5);
        ImageView exhibit6 = findViewById(R.id.exhibit_6);
        ImageView exhibit7 = findViewById(R.id.exhibit_7);
        ImageView exhibit8 = findViewById(R.id.exhibit_8);
        ImageView exhibit9 = findViewById(R.id.exhibit_9);
        ImageView exhibit10 = findViewById(R.id.exhibit_10);
        ImageView exhibit11 = findViewById(R.id.exhibit_11);
        ImageView exhibit12 = findViewById(R.id.exhibit_12);
        ImageView exhibit13 = findViewById(R.id.exhibit_13);
        ImageView exhibit14 = findViewById(R.id.exhibit_14);
        ImageView exhibit15 = findViewById(R.id.exhibit_15);



        if (contentType != null) {
            switch (contentType) {
                case "shelf_content_one":

                    setExhibitImageFromDB("86", exhibit1);
                    setExhibitImageFromDB("165", exhibit2);
                    setExhibitImageFromDB("166", exhibit3);
                    setExhibitImageFromDB("211", exhibit4);
                    setExhibitImageFromDB("73", exhibit5);
                    setExhibitImageFromDB("67", exhibit6);
                    setExhibitImageFromDB("69", exhibit7);
                    setExhibitImageFromDB("101", exhibit8);
                    setExhibitImageFromDB("110", exhibit9);
                    setExhibitImageFromDB("106", exhibit10);
                    setExhibitImageFromDB("108", exhibit11);
                    setExhibitImageFromDB("244", exhibit12);
                    setExhibitImageFromDB("243", exhibit13);
                    exhibit14.setVisibility(View.GONE);
                    exhibit15.setVisibility(View.GONE);


                    background.setImageResource(R.drawable.shelf_background);
                    break;
                case "shelf_content_two":
                    setExhibitImageFromDB("100", exhibit1);
                    setExhibitImageFromDB("69", exhibit2);
                    setExhibitImageFromDB("212", exhibit3);
                    setExhibitImageFromDB("59", exhibit4);
                    setExhibitImageFromDB("48", exhibit5);
                    setExhibitImageFromDB("83", exhibit6);
                    setExhibitImageFromDB("57", exhibit7);
                    setExhibitImageFromDB("99", exhibit8);
                    setExhibitImageFromDB("111", exhibit9);
                    setExhibitImageFromDB("112", exhibit10);
                    setExhibitImageFromDB("97", exhibit11);
                    setExhibitImageFromDB("90", exhibit12);
                    exhibit13.setVisibility(View.GONE);
                    exhibit14.setVisibility(View.GONE);
                    exhibit15.setVisibility(View.GONE);

                    background.setImageResource(R.drawable.shelf_background);
                    break;
            }
        }

        if (contentTypeTwo != null) {
            switch (contentTypeTwo) {
                case "shelf_two_content_one":
                    setExhibitImageFromDB("87", exhibit1);
                    setExhibitImageFromDB("47", exhibit2);
                    setExhibitImageFromDB("53", exhibit3);
                    setExhibitImageFromDB("68", exhibit4);
                    setExhibitImageFromDB("50", exhibit5);
                    setExhibitImageFromDB("82", exhibit6);
                    setExhibitImageFromDB("60", exhibit7);
                    setExhibitImageFromDB("75", exhibit8);
                    setExhibitImageFromDB("49", exhibit9);
                    setExhibitImageFromDB("81", exhibit10);
                    setExhibitImageFromDB("84", exhibit11);
                    setExhibitImageFromDB("76", exhibit12);
                    setExhibitImageFromDB("58", exhibit13);
                    setExhibitImageFromDB("51", exhibit14);
                    setExhibitImageFromDB("52", exhibit15);

                    background.setImageResource(R.drawable.shelf_two_background);
                    break;
                case "shelf_two_content_two":
                    setExhibitImageFromDB("17", exhibit1);
                    setExhibitImageFromDB("78", exhibit2);
                    setExhibitImageFromDB("31", exhibit3);
                    setExhibitImageFromDB("236", exhibit4);
                    setExhibitImageFromDB("30", exhibit5);
                    setExhibitImageFromDB("23", exhibit6);
                    setExhibitImageFromDB("43", exhibit7);
                    setExhibitImageFromDB("42", exhibit8);
                    setExhibitImageFromDB("37", exhibit9);
                    setExhibitImageFromDB("33", exhibit10);
                    setExhibitImageFromDB("7", exhibit11);
                    setExhibitImageFromDB("36", exhibit12);
                    setExhibitImageFromDB("21", exhibit13);
                    setExhibitImageFromDB("22", exhibit14);
                    setExhibitImageFromDB("38", exhibit15);

                    background.setImageResource(R.drawable.shelf_two_background);
                    break;
                case "shelf_two_content_three":
                    setExhibitImageFromDB("239", exhibit1);
                    setExhibitImageFromDB("15", exhibit2);
                    setExhibitImageFromDB("35", exhibit3);
                    setExhibitImageFromDB("40", exhibit4);
                    setExhibitImageFromDB("44", exhibit5);
                    setExhibitImageFromDB("20", exhibit6);
                    setExhibitImageFromDB("14", exhibit7);
                    setExhibitImageFromDB("228", exhibit8);
                    setExhibitImageFromDB("4", exhibit9);
                    setExhibitImageFromDB("240", exhibit10);
                    setExhibitImageFromDB("25", exhibit11);
                    setExhibitImageFromDB("18", exhibit12);
                    setExhibitImageFromDB("41", exhibit13);
                    setExhibitImageFromDB("9", exhibit14);
                    setExhibitImageFromDB("5", exhibit15);

                    background.setImageResource(R.drawable.shelf_two_background);
                    break;
                case "shelf_two_content_four":
                    setExhibitImageFromDB("8", exhibit1);
                    setExhibitImageFromDB("6", exhibit2);
                    setExhibitImageFromDB("10", exhibit3);
                    setExhibitImageFromDB("28", exhibit4);
                    setExhibitImageFromDB("24", exhibit5);
                    setExhibitImageFromDB("37", exhibit6);
                    setExhibitImageFromDB("159", exhibit7);
                    setExhibitImageFromDB("114", exhibit8);
                    setExhibitImageFromDB("118", exhibit9);
                    setExhibitImageFromDB("3", exhibit10);
                    setExhibitImageFromDB("19", exhibit11);
                    setExhibitImageFromDB("12", exhibit12);
                    setExhibitImageFromDB("11", exhibit13);
                    setExhibitImageFromDB("226", exhibit14);
                    setExhibitImageFromDB("13", exhibit15);

                    background.setImageResource(R.drawable.shelf_two_background);
                    break;
                case "shelf_two_content_five":
                    setExhibitImageFromDB("142", exhibit1);
                    setExhibitImageFromDB("145", exhibit2);
                    setExhibitImageFromDB("146", exhibit3);
                    setExhibitImageFromDB("147", exhibit4);
                    setExhibitImageFromDB("148", exhibit5);
                    setExhibitImageFromDB("149", exhibit6);
                    setExhibitImageFromDB("150", exhibit7);
                    setExhibitImageFromDB("151", exhibit8);
                    setExhibitImageFromDB("152", exhibit9);
                    setExhibitImageFromDB("153", exhibit10);
                    setExhibitImageFromDB("154", exhibit11);
                    setExhibitImageFromDB("155", exhibit12);
                    setExhibitImageFromDB("156", exhibit13);
                    setExhibitImageFromDB("157", exhibit14);
                    setExhibitImageFromDB("158", exhibit15);

                    background.setImageResource(R.drawable.shelf_two_background);
                    break;
                case "shelf_two_content_six":
                    setExhibitImageFromDB("222", exhibit1);
                    setExhibitImageFromDB("221", exhibit2);
                    setExhibitImageFromDB("143", exhibit3);
                    setExhibitImageFromDB("237", exhibit4);
                    setExhibitImageFromDB("161", exhibit5);
                    setExhibitImageFromDB("241", exhibit6);
                    setExhibitImageFromDB("1", exhibit7);
                    setExhibitImageFromDB("34", exhibit8);
                    setExhibitImageFromDB("2", exhibit9);
                    setExhibitImageFromDB("39", exhibit10);
                    setExhibitImageFromDB("254", exhibit11);
                    setExhibitImageFromDB("64", exhibit12);
                    setExhibitImageFromDB("85", exhibit13);
                    setExhibitImageFromDB("80", exhibit14);
                    setExhibitImageFromDB("66", exhibit15);

                    background.setImageResource(R.drawable.shelf_two_background);
                    break;

                case "pedestal_one_content":
                    setExhibitImageFromDB("43", exhibit1);
                    setExhibitImageFromDB("44", exhibit2);
                    setExhibitImageFromDB("52", exhibit3);
                    setExhibitImageFromDB("35", exhibit4);
                    setExhibitImageFromDB("42", exhibit5);
                    setExhibitImageFromDB("120", exhibit6);
                    setExhibitImageFromDB("20", exhibit7);
                    setExhibitImageFromDB("83", exhibit8);
                    exhibit9.setVisibility(View.GONE);
                    exhibit10.setVisibility(View.GONE);
                    exhibit11.setVisibility(View.GONE);
                    exhibit12.setVisibility(View.GONE);
                    exhibit13.setVisibility(View.GONE);
                    exhibit14.setVisibility(View.GONE);
                    exhibit15.setVisibility(View.GONE);

                    background.setImageResource(R.drawable.pedestal_background);
                    break;
                case "pedestal_two_content":
                    setExhibitImageFromDB("51", exhibit1);
                    setExhibitImageFromDB("47", exhibit2);
                    setExhibitImageFromDB("62", exhibit3);
                    setExhibitImageFromDB("162", exhibit4);
                    setExhibitImageFromDB("63", exhibit5);
                    setExhibitImageFromDB("55", exhibit6);
                    setExhibitImageFromDB("116", exhibit7);
                    setExhibitImageFromDB("59", exhibit8);
                    setExhibitImageFromDB("223", exhibit9);
                    setExhibitImageFromDB("199", exhibit10);
                    setExhibitImageFromDB("224", exhibit11);
                    setExhibitImageFromDB("93", exhibit12);
                    setExhibitImageFromDB("18", exhibit13);
                    setExhibitImageFromDB("58", exhibit14);
                    setExhibitImageFromDB("80", exhibit15);

                    background.setImageResource(R.drawable.pedestal_background);
                    break;
            }
        }



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String source = getIntent().getStringExtra("source");
                Intent intent;

                if ("hall_two".equals(source)) {
                    intent = new Intent(Shelf.this, HallTwo.class);
                } else {
                    intent = new Intent(Shelf.this, Hall.class);
                }

                startActivity(intent);
                finish();
            }
        });
    }

    private void openExhibit(String exhibitId) {
        Intent intent = new Intent(Shelf.this, Exhibit.class);
        intent.putExtra("exhibit_id", exhibitId);
        intent.putExtra("content_type", getIntent().getStringExtra("content_type"));
        intent.putExtra("content_type_two", getIntent().getStringExtra("content_type_two"));
        startActivity(intent);
    }

    private void setExhibitImageFromDB(String exhibitId, ImageView imageView) {
        Cursor cursor = dbHelper.getExhibitById(exhibitId);
        if (cursor != null && cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex("PngExhibit");
            if (columnIndex != -1) {
                byte[] blob = cursor.getBlob(columnIndex);
                if (blob != null) {
                    Bitmap bitmap = BitmapFactory.decodeByteArray(blob, 0, blob.length);
                    imageView.setImageBitmap(bitmap);

                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            openExhibit(exhibitId);
                        }
                    });
                }
            }
            cursor.close();
        }
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

