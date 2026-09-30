package com.shailesh.chatapp;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText messageInput;
    Button sendButton;
    LinearLayout chatLayout;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
        );

        setContentView(R.layout.activity_main);

        messageInput = findViewById(R.id.messageInput);
        sendButton = findViewById(R.id.sendButton);
        chatLayout = findViewById(R.id.chatLayout);
        scrollView = findViewById(R.id.scrollView);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {

        String message = messageInput.getText().toString().trim();

        // Check if empty
        if (message.isEmpty()) {
            Toast.makeText(this, "Please type a message", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create a new TextView
        TextView textView = new TextView(this);

        textView.setText(message);
        textView.setTextSize(18);
        textView.setPadding(20, 20, 20, 20);

        // Add message to chat
        chatLayout.addView(textView);

        // Clear input box
        messageInput.setText("");

        // Scroll to latest message
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
    }
}