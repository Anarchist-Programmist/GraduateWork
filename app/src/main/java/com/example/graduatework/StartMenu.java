package com.example.graduatework;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class StartMenu extends AppCompatActivity{

    private TextView textView;

    private final String[] texts = {"Приветствую, я - ИП! " +
            "\n Ваш интерактивный" + "\n путеводитель!",
            "Я предлагаю вам \n пройти " + " экскурсию \n по музею.",
            "Нажмите на кнопку " + "\n начать," + " если вы \n готовы!"};
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_menu_layout);

        textView = findViewById(R.id.guide_text);

        ImageView rightDialogArrow = findViewById(R.id.right_arrow);
        ImageView leftDialogArrow = findViewById(R.id.left_arrow);
        Button openNewLayoutButton = findViewById(R.id.open_new_layout_button);
        Button skipDialogButton = findViewById(R.id.skip_button);
        Button exit = findViewById(R.id.Exit);

        textView.setText(texts[currentIndex]);

        rightDialogArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex < texts.length) {
                    textView.setText(texts[currentIndex]);
                    currentIndex++;
                }
                if (currentIndex == texts.length) {
                    rightDialogArrow.setVisibility(View.GONE);

                    openNewLayoutButton.setVisibility(View.VISIBLE);
                    exit.setVisibility(View.VISIBLE);
                }
                if(currentIndex == 2){
                    skipDialogButton.setVisibility(View.GONE);
                }
            }
        });
        leftDialogArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex > 0) {
                    currentIndex--;
                    textView.setText(texts[currentIndex]);
                    rightDialogArrow.setVisibility(View.VISIBLE);
                    openNewLayoutButton.setVisibility(View.GONE);
                    exit.setVisibility(View.GONE);
                }
                if (currentIndex == 0){
                    textView = findViewById(R.id.guide_text);
                }
            }
        });

        openNewLayoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartMenu.this, Hall.class);
                startActivity(intent);

            }
        });

        skipDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartMenu.this, Hall.class);
                startActivity(intent);

            }
        });
    }

    public void clickexit(View v){
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    /*Скрыть навигационное меню*/
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                           | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}

