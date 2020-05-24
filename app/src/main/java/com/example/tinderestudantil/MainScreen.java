package com.example.tinderestudantil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreen extends AppCompatActivity {

    private Button Contato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        Contato = findViewById(R.id.button_contato);
        Contato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToContactScreen();
            }
        });
    }

    private void moveToContactScreen(){
        Intent moveContato = new Intent(MainScreen.this, Contato.class);
        startActivity(moveContato);
    }

}
