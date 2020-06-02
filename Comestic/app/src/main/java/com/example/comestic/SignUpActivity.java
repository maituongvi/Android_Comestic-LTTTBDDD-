package com.example.comestic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText email, passWord,confirmPass;
    private Button btnSignUp;
    private TextView signIn, exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_signup);
        mAuth = FirebaseAuth.getInstance();

        email =findViewById(R.id.signin_email);
        passWord = findViewById(R.id.signin_password);
        confirmPass =findViewById(R.id.signup_confirmpassword);
        btnSignUp =findViewById(R.id.btn_sign_up);
        signIn = findViewById(R.id.sign_in_again);
        exit = findViewById(R.id.Exit);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email1 =email.getText().toString();
                String pass1 = passWord.getText().toString();
                String confirm1 = confirmPass.getText().toString();
                if(email1.isEmpty()){
                    email.setError("Please enter your Email");
                    email.requestFocus();
                }
                else if(pass1.isEmpty()){
                    passWord.setError("Please enter your password");
                    passWord.requestFocus();
                }
                else if(confirm1.isEmpty()){
                    confirmPass.setError("Please confirm your password");
                    confirmPass.requestFocus();
                }
                else if(!(email1.isEmpty() && pass1.isEmpty() && confirm1.isEmpty())){
                    if(pass1.equals(confirm1)){
                        mAuth.createUserWithEmailAndPassword(email1,pass1).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(SignUpActivity.this,"Sign Up Success!",Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(SignUpActivity.this,"Sign Up Unsuccessful!",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                    else {
                        Toast.makeText(SignUpActivity.this,"PassWord does not match with Confirm PassWord",Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(SignUpActivity.this,"Error!!!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_signIn = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent_signIn);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
