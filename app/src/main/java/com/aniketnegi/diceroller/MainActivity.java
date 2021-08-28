package com.aniketnegi.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnRollDice;
//    TextView textNumber;
    ImageView imgDice;
    LottieAnimationView diceAnimView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRollDice = findViewById(R.id.btnRollDice);
        //textNumber = findViewById(R.id.textNumber);
        imgDice = findViewById(R.id.imgDice);
        diceAnimView = findViewById(R.id.diceAnimView);

        btnRollDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceAnimView.setVisibility(View.VISIBLE);
                diceAnimView.playAnimation();

            }
        });

        diceAnimView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                imgDice.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                imgDice.setVisibility(View.VISIBLE);
                diceAnimView.setVisibility(View.GONE);
                rollDice();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

    }

    private void rollDice() {
        Random randomNum = new Random();
        int diceNum = randomNum.nextInt(6) + 1;
//        textNumber.setText(String.valueOf(diceNum));
        switch(diceNum) {
            case 1: imgDice.setImageResource(R.drawable.dice1);
                break;
            case 2: imgDice.setImageResource(R.drawable.dice2);
                break;
            case 3: imgDice.setImageResource(R.drawable.dice3);
                break;
            case 4: imgDice.setImageResource(R.drawable.dice4);
                break;
            case 5: imgDice.setImageResource(R.drawable.dice5);
                break;
            case 6: imgDice.setImageResource(R.drawable.dice6);
                break;
        }
    }
}