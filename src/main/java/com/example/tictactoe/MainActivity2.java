package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.graphics.Color; // Import the Color class
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private TextView textViewStatus;
    private final Button[] buttons = new Button[9];
    private boolean playerXTurn = true;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textViewStatus = findViewById(R.id.textViewStatus);
        ImageButton buttonReset = findViewById(R.id.buttonReset);
        // Initialize buttons
        for (int i = 0; i < buttons.length; i++) {
            String buttonID = "button" + i;
            @SuppressLint("DiscouragedApi") int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i] = findViewById(resID);
            buttons[i].setOnClickListener(v -> onButtonClick((Button) v));
        }

        // Reset button listener
        buttonReset.setOnClickListener(v -> resetGame());

        updateStatus();
    }

    @SuppressLint("StringFormatInvalid")
    private void onButtonClick(Button button) {
        if (button.getText().toString().isEmpty()) {
            button.setText(playerXTurn ? "X" : "O");
            // Set text color based on the player
            button.setTextColor(playerXTurn ? Color.RED : Color.GREEN);
            if (checkForWin()) {
                String winner = playerXTurn ? "X" : "O";
                textViewStatus.setText(getString(R.string.given_player_win, winner));
                disableButtons(); // Disable buttons after a win
            } else {
                playerXTurn = !playerXTurn; // Switch turns
                updateStatus();
            }
        }
    }

    private boolean checkForWin() {
        // Winning combinations
        int[][] winningCombinations = {
                {0, 1, 2}, // Row 1
                {3, 4, 5}, // Row 2
                {6, 7, 8}, // Row 3
                {0, 3, 6}, // Column 1
                {1, 4, 7}, // Column 2
                {2, 5, 8}, // Column 3
                {0, 4, 8}, // Diagonal \
                {2, 4, 6}  // Diagonal /
        };

        for (int[] combination : winningCombinations) {
            String button1Text = buttons[combination[0]].getText().toString();
            String button2Text = buttons[combination[1]].getText().toString();
            String button3Text = buttons[combination[2]].getText().toString();

            if (!button1Text.isEmpty() && button1Text.equals(button2Text) && button1Text.equals(button3Text)) {
                return true;
            }
        }
        return false;
    }

    private void updateStatus() {
        String currentPlayer = playerXTurn ? "X" : "O"; // Change to "O" for player O
        textViewStatus.setText(getString(R.string.player_turn, currentPlayer));
    }

    private void resetGame() {
        for (Button button : buttons) {
            button.setText("");
            button.setEnabled(true);
        }
        playerXTurn = true; // Reset to Player X's turn
        updateStatus(); // Update the status to show Player X's turn
    }

    private void disableButtons() {
        for (Button button : buttons) {
            button.setEnabled(false);
        }
    }
}
