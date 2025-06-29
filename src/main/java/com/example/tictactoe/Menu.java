package com.example.tictactoe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {
    ImageButton instaButton;
    ImageButton linkedInButton;
    ImageButton githubButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Assuming EdgeToEdge is a custom implementation, ensure it's correctly set up
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);

        instaButton = findViewById(R.id.instaButton);
        instaButton.setOnClickListener(v -> openInstagramPage());

        githubButton = findViewById(R.id.githubButton);
        githubButton.setOnClickListener(v -> openGithub());

        linkedInButton = findViewById(R.id.linkedInButton);
        linkedInButton.setOnClickListener(v -> openLinkedInPage());
    }

    private void openInstagramPage() {
        String instagramUrl = "https://www.instagram.com/patel_yogesh__/";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(instagramUrl));
        startActivity(intent);
    }

    private void openLinkedInPage() {
        String linkedInUrl = "https://www.linkedin.com/in/yogesh-patel-834464202";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(linkedInUrl));
        startActivity(intent);
    }
    private void openGithub(){
        String githubURL = "https://github.com/YogeshPatelVlog";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(githubURL));
        startActivity(intent);
    }
}
