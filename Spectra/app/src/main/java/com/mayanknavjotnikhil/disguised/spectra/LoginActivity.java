package com.mayanknavjotnikhil.disguised.spectra;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private FirebaseAuth auth;
    private Button btnLogin;
    private FirebaseAuth.AuthStateListener authStateListener;

    public void moveToRegister(View view) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent RegIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(RegIntent);
                finish();
            }
        }, 0);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();
        inputEmail = findViewById(R.id.editText2);
        inputPassword = findViewById(R.id.editText3);
        btnLogin = findViewById(R.id.button);

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if(user != null) {
                    Toast.makeText(LoginActivity.this, "User Logged In", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, Profile.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Login to continue", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }
}