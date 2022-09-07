package com.example.multiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {


    ImageButton btn_calculator;
    ImageButton btn_clock ;
    ImageButton btn_tictactoe;
    ImageButton btn_cumpas;
    ImageButton btn_camera;
    ImageButton btn_note;
    ImageButton btn_calender;
    ImageButton btn_torch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
  btn_calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,calender.class);
                startActivity(intent);

            }
        });
        btn_clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                workIsGoingOn();

            }
        });
        btn_tictactoe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,tic_tac_toe.class );
                startActivity(intent);
            }
        });
        btn_cumpas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                workIsGoingOn();

            }
        });
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent= new Intent();
                    intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(intent);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
        btn_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                workIsGoingOn();

            }
        });
        btn_torch.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,Flash_light.class );
                startActivity(intent);
            }
        });


        btn_calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, Calculator_activity.class);
                startActivity(intent);
            }
        });


    }

    void init(){
         btn_calculator = findViewById(R.id.btn_calculator);
         btn_clock = findViewById(R.id.btn_clock);
         btn_tictactoe= findViewById(R.id.btn_tictactoe);
         btn_cumpas= findViewById(R.id.btn_cumpas);
         btn_camera= findViewById(R.id.btn_camera);
         btn_note= findViewById(R.id.btn_note);
         btn_calender= findViewById(R.id.btn_calender);
         btn_torch= findViewById(R.id.btn_torch);
    }


    void workIsGoingOn(){
        Intent intent= new Intent(MainActivity.this,WorkIsGoingOn.class );
        startActivity(intent);
    }
}