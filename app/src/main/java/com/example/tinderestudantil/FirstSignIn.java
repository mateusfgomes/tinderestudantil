package com.example.tinderestudantil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirstSignIn extends AppCompatActivity {

    public String full_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_sign_in);

        final EditText editText = (EditText) findViewById(R.id.fullname);


        /*
        Chama a funcao para apertao o botao pra segunda tela
         */
        Log.d("aa1a", "full_name");
        Button next = findViewById(R.id.button_continue2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                full_name = editText.getText().toString();
                moveToSecondSignIn();
            }
        });

    }

    private void moveToSecondSignIn(){
        Intent move = new Intent(FirstSignIn.this, SecondSignIn.class);
        move.putExtra("completename", full_name);
        startActivity(move);
    }
}
