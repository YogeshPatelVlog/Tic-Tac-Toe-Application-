package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button buttonStartGame;
    Button buttonExit;
    ImageButton menuBtn;
    Button buttonStartGameOnline;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        buttonStartGame = findViewById(R.id.buttonStartGame);
        buttonExit = findViewById(R.id.buttonExit);
        menuBtn = findViewById(R.id.menuBtn);
        buttonStartGameOnline = findViewById(R.id.buttonStartGameOnline);

        buttonStartGameOnline.setOnClickListener(v -> { // play online game
//            Intent intent = new Intent(MainActivity.this, PlayOnline.class);
//            startActivity(intent);
            Toast.makeText(this, "Will Come in New Update", Toast.LENGTH_SHORT).show();
        });
        menuBtn.setOnClickListener(new View.OnClickListener() { // got to menu
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Menu.class);
                startActivity(intent);
            }
        });
        buttonExit.setOnClickListener(v -> finishAffinity()); // exit the game
        buttonStartGame.setOnClickListener(v -> { // play offline game
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        });
    }
}