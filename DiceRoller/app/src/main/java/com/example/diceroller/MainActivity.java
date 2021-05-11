package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button dice_button = (Button) findViewById(R.id.roll_dice_button); // You can cast
        ImageView dice_image = findViewById(R.id.dice_image); // But optional to cast

        Random rand = new Random();

        /*
        dice_button.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Do Button clicking stuff here
                }
            }
        );
        */

        dice_button.setOnClickListener(
            v -> {
                int int_random = rand.nextInt(5) + 1;
                                // 0 to BOUND, meaning 0 to 5 here, so 1 to 6 via +1
                try {
                    // This is a way to get a DRAWABLE in code
                    //  + ability to get the image we want via a string
                    //    because we want different dice between 1 to 6
                    int diceImageField = R.drawable.class
                                         .getDeclaredField("dice_" + int_random) // Gets a Java variable / function via a string call
                                         .getInt(null); // Get the ID number as integer (for now, just use null inside)
                    // Reason we cast to int is that this is a Drawable ID number
                    //  that Android uses
                    dice_image.setImageResource(diceImageField);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        );

    }
}
