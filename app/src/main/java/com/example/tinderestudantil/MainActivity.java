package com.example.tinderestudantil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Continue = findViewById(R.id.button_continue);

        Button sign = findViewById(R.id.tofirst);
;
        final EditText refLogin = findViewById(R.id.email);
        final EditText refPass = findViewById(R.id.password);


        mAuth = FirebaseAuth.getInstance();
        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser loggingusr = FirebaseAuth.getInstance().getCurrentUser();
                if (loggingusr != null) {
                    Intent intent = new Intent(MainActivity.this, MainScreen.class);
                    moveToMainScreen(intent);
                    finish();
                }
            }
        };


        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = refLogin.getText().toString();
                String password = refPass.getText().toString();
                mAuth.signInWithEmailAndPassword(login, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Logged In", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToFirstSignIn();
            }
        });

    }
    private void moveToMainScreen(Intent intent){
        startActivity(intent);
    }

    private void moveToFirstSignIn(){

        Intent sign = new Intent(MainActivity.this, FirstSignIn.class);
        startActivity(sign);

    }
    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(firebaseAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(firebaseAuthListener);
    }
}





