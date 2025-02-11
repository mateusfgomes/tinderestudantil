package com.example.tinderestudantil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        Button contato = findViewById(R.id.button_contato);
        contato.setOnClickListener(new View.OnClickListener() {
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

    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
