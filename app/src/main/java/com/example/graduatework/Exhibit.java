package com.example.graduatework;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Exhibit extends AppCompatActivity {

    MyDatabase dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exhibit_layout);

        String exhibitId = getIntent().getStringExtra("exhibit_id");
        String contentType = getIntent().getStringExtra("content_type");
        String contentTypeTwo = getIntent().getStringExtra("content_type_two");

        dbHelper = new MyDatabase(this);

        ImageView exhibitImage = findViewById(R.id.image_exhibit);
        setExhibitImageFromDB(exhibitId, exhibitImage);

        Button back = findViewById(R.id.back);

        TextView numberAndName = findViewById(R.id.number_and_name_exhibit);
        TextView countryAndYear = findViewById(R.id.country_and_year);
        TextView sizeAndMaterial = findViewById(R.id.size_and_material);
        TextView descriptionText = findViewById(R.id.description);

        Cursor cursor = dbHelper.getExhibitById(exhibitId);
        if (cursor != null && cursor.moveToFirst()) {
            String fullName = cursor.getString(cursor.getColumnIndexOrThrow("FullNameExhibit"));
            String country = cursor.getString(cursor.getColumnIndexOrThrow("Country"));
            String year = cursor.getString(cursor.getColumnIndexOrThrow("Year"));
            String size = cursor.getString(cursor.getColumnIndexOrThrow("Size"));
            String material = cursor.getString(cursor.getColumnIndexOrThrow("Material"));
            String description = cursor.getString(cursor.getColumnIndexOrThrow("Description"));

            numberAndName.setText("№" + exhibitId + ". " + "Наименование: " + (isNullOrEmpty(fullName) ? "Данные отсутствуют" : fullName));
            countryAndYear.setText("Страна: " +(isNullOrEmpty(country) ? "Данные отсутствуют" : country) + ". "
                    + "Год: " + (isNullOrEmpty(year) ? "Данные отсутствуют" : year));
            sizeAndMaterial.setText("Размер: " + (isNullOrEmpty(size) ? "Данные отсутствуют" : size) + ". " +
                    "Материал: " + (isNullOrEmpty(material) ? "Данные отсутствуют" : material));
            descriptionText.setText("Описание: " + (isNullOrEmpty(description) ? "Данные отсутствуют" : description));

            cursor.close();
        }


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Exhibit.this, Shelf.class);
                intent.putExtra("content_type", contentType);
                intent.putExtra("content_type_two", contentTypeTwo);
                startActivity(intent);
            }
        });
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
                }
            }
            cursor.close();
        }
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
