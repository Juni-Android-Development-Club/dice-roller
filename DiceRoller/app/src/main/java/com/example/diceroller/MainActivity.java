package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button diceButton = (Button) findViewById(R.id.rolldicebutton);
        ImageView diceImage = findViewById(R.id.diceImage);

        Random rand = new Random();

        diceButton.setOnClickListener(
            v -> {
                try {
                    int int_random = rand.nextInt(5) + 1;
                    int diceImageField = R.drawable.class
                            .getDeclaredField("dice_" + int_random)
                            .getInt(null);
                    diceImage.setImageResource(diceImageField);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        );
    }
}