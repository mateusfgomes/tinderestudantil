package com.example.tinderestudantil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Continue = findViewById(R.id.button_continue);
        Continue.setOnClickListener(this);
        Button sign = findViewById(R.id.tofirst);
        sign.setOnClickListener(this);

    }
    private void moveToMainScreen(){

        Intent move = new Intent(MainActivity.this, MainScreen.class);
        startActivity(move);

    }

    private void moveToFirstSignIn(){

        Intent sign = new Intent(MainActivity.this, FirstSignIn.class);
        startActivity(sign);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_continue:
                moveToMainScreen();
                break;
            case R.id.tofirst:
                moveToFirstSignIn();
                break;
        }
    }
}


