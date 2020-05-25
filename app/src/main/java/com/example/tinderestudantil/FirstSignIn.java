package com.example.tinderestudantil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstSignIn extends AppCompatActivity {

    public String full_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_sign_in);

        final EditText editText = findViewById(R.id.fullname);

        Button next = findViewById(R.id.button_continue2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                full_name = editText.getText().toString();
                moveToSecondSignIn();
                finish();
                return;
            }
        });

    }

    private void moveToSecondSignIn(){
        Intent move = new Intent(FirstSignIn.this, SecondSignIn.class);
        move.putExtra("completename", full_name);
        startActivity(move);
    }
}
