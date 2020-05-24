package com.example.tinderestudantil;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ThirdSignIn extends AppCompatActivity {

    public String username, password, name, state, city, div, st, number, comp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_sign_in);

        Intent intent = getIntent();
        name = intent.getStringExtra("completename");
        username = intent.getStringExtra("usr");
        password = intent.getStringExtra("pass1");


        final Spinner field_state = findViewById(R.id.state);
        final EditText field_city = findViewById(R.id.city);
        final EditText field_div = findViewById(R.id.div);
        final EditText field_st = findViewById(R.id.st);
        final EditText field_number = findViewById(R.id.number);
        final EditText field_comp = findViewById(R.id.comp);

        Button finish = findViewById(R.id.button_continue2);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state = field_state.getSelectedItem().toString();
                city = field_city.getText().toString();
                div = field_div.getText().toString();
                st = field_st.getText().toString();
                number = field_number.getText().toString();
                comp = field_comp.getText().toString();
                finish();
            }
        });
    }

    public void finish(){
        Intent setup = new Intent(ThirdSignIn.this, MainActivity.class);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference dref = database.getReference(username);

        dref.child("full_name").setValue(name);
        dref.child("state").setValue(state);
        dref.child("city").setValue(city);

        final DatabaseReference adref = database.getReference(username).child("address");

        adref.child("neighborhood").setValue(div);
        adref.child("street").setValue(st);
        adref.child("number").setValue(number);
        adref.child("comp").setValue(comp);

        dref.child("password").setValue(password);

        startActivity(setup);
    }
}
