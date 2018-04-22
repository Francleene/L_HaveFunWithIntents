package com.google.alexander.havefunwithintents;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected static final int TEXT_ENTER_ACTIVITY_REQUEST_CODE = 43;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == TEXT_ENTER_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            String userText = data.getExtras().getString("userText");

            if (userText != null && !userText.equals("")) {
                TextView userTextView = findViewById(R.id.userTextView);
                userTextView.setText(userText);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button changeTextButton = findViewById(R.id.changeTextButton);
        changeTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText textEdit = findViewById(R.id.enterNameEditText);
                String userName = textEdit.getText().toString();

                if (!userName.equals("")) {
                    Intent intent = new Intent(MainActivity.this, TextEnterActivity.class);

                    intent.putExtra("userName", userName);

                    startActivityForResult(intent, TEXT_ENTER_ACTIVITY_REQUEST_CODE);
                } else {
                    Toast.makeText(MainActivity.this, "You didn't enter your name", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
