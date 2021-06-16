package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button diceButton = (Button) findViewById(R.id.roll_dice_button);
        ImageView diceImage = findViewById(R.id.dice_image);

        Random rand = new Random();

        diceButton.setOnClickListener(
            v -> {
                try {
                    int int_random = rand.nextInt(5) + 1;
                    int diceImageField = R.drawable.class
                            .getDeclaredField("dice_" + int_random)
                            .getInt(null);
                    diceImage.setImageResource(diceImageField);
                    modifyResultText(int_random);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        );
    }

    void modifyResultText(int diceResult) {
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

        TextView result_text_view = (TextView) findViewById(R.id.dice_result_textView);

        String result = "The result of your dice is: " + diceResult;

        result_text_view.setText(result);
    }
}