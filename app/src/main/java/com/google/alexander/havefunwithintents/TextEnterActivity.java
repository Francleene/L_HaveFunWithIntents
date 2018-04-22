package com.google.alexander.havefunwithintents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class TextEnterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.activity_enter_text);

        String userName = getIntent().getExtras().getString("userName");

        TextView titleTextView = findViewById(R.id.titleTextView);
        titleTextView.setText(userName + ", enter your text:");

        Button setTextButton = findViewById(R.id.button);
        setTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText userEditText = findViewById(R.id.userEditText);
                String userText = userEditText.getText().toString();

                if (userText.equals("")) {
                    Toast.makeText(TextEnterActivity.this, "You didn't enter text", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent output = new Intent();

                output.putExtra("userText", userText);

                setResult(Activity.RESULT_OK, output);
                finish();
            }
        });
    }
}
