package com.example.tinderestudantil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SecondSignIn extends AppCompatActivity {

    public String name, user, password, confirm;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_sign_in);

        Intent intent = getIntent();
        name = intent.getStringExtra("completename");

        final EditText field_username = (EditText) findViewById(R.id.username);
        final EditText field_password = (EditText) findViewById(R.id.password1);
        final EditText field_confirm = (EditText) findViewById(R.id.password2);
        final String finalName = name;

        Button next = findViewById(R.id.button_continue2);

        mAuth = FirebaseAuth.getInstance();
        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser loggingusr = FirebaseAuth.getInstance().getCurrentUser();
                if (loggingusr != null) {
                    Intent intent = new Intent(SecondSignIn.this, ThirdSignIn.class);
                    mAuth.signOut();
                    finish();
                    moveToThirdSignIn(intent);
                    return;
                }
            }
        };

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = field_username.getText().toString();
                password = field_password.getText().toString();
                confirm = field_confirm.getText().toString();
                mAuth.createUserWithEmailAndPassword(user, password).addOnCompleteListener(SecondSignIn.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(SecondSignIn.this, "Erro no Cadastro", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    private void moveToThirdSignIn(Intent intent) {
        intent.putExtra("completename", name);
        intent.putExtra("usr", user);
        startActivity(intent);
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