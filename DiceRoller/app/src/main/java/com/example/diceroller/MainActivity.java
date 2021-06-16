package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

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

                    modifyResultText(int_random);

                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        );
    }

    void modifyResultText(int diceResult) {
        // Check whether or not to invert the result of the Dice here
        ToggleButton invert_result_toggleButton = (ToggleButton) findViewById(R.id.invert_result_toggleButton);
        if (invert_result_toggleButton.isChecked()) {
            switch (diceResult) {
                case 1:
                    diceResult = 6;
                    break;
                case 2:
                    diceResult = 5;
                    break;
                case 3:
                    diceResult = 4;
                    break;
                case 4:
                    diceResult = 3;
                    break;
                case 5:
                    diceResult = 2;
                    break;
                case 6:
                    diceResult = 1;
                    break;
                default:
                    diceResult = -1;
                    System.out.println("Should not reach here");
                    break;
            }
        }

        // We get the specific TextView of the Result Text
        TextView result_text_view = (TextView) findViewById(R.id.dice_result_textView);

        // Make the text to show what was rolled
        String result = "The result of your dice is: " + diceResult;

        // Present the text to the viewer as a modified text of the TextView
        result_text_view.setText(result);
    }
}
