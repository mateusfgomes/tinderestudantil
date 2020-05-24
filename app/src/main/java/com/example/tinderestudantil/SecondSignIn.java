package com.example.tinderestudantil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SecondSignIn extends AppCompatActivity {

    public String name, user, password, confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_sign_in);

        Intent intent = getIntent();
        name = intent.getStringExtra("completename");

        final EditText field_username = (EditText) findViewById(R.id.username);
        final EditText field_password = (EditText) findViewById(R.id.password1);
        final EditText field_confirm = (EditText) findViewById(R.id.password2);

        Button next = findViewById(R.id.button_continue2);
        
        final String finalName = name;
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = field_username.getText().toString();
                password = field_password.getText().toString();
                confirm = field_confirm.getText().toString();
                moveToThirdSignIn();
            }
        });
    }

    private void moveToThirdSignIn(){
        Intent intent = new Intent(SecondSignIn.this, ThirdSignIn.class);
        intent.putExtra("completename", name);
        intent.putExtra("usr", user);
        intent.putExtra("pass1", password);
        startActivity(intent);
    }
}
