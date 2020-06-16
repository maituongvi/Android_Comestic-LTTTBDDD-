package com.example.comestic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.model.LoaiSanPham;
import com.example.model.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AccountActivity extends AppCompatActivity {
    EditText txtNewPass;
    EditText txtNewPass2, txtName, txtAddress, txtPhone,txtEmail;
    CheckBox checkBox;
    User user;
    ImageView img;
    private Toolbar toolbar ;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account);


<<<<<<< Updated upstream
        accountNav = (BottomNavigationView) findViewById(R.id.account_nav);
        accountNav.setOnNavigationItemSelectedListener(navListener);
=======
        toolbar =findViewById(R.id.toolBar1);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("ACCOUNT");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


>>>>>>> Stashed changes
        // boolean check = false;
        txtNewPass = (EditText) findViewById(R.id.txtNewPass);
        txtNewPass2 = (EditText) findViewById(R.id.txtNewPass2);
        txtAddress =findViewById(R.id.txtAddress);
        txtName = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.editEmail);
        txtPhone =findViewById(R.id.txtPhoneNumber);
        checkBox = findViewById(R.id.checkBox);

        Intent intent = getIntent();
        if(intent.getExtras() !=null){
            user = (User) intent.getExtras().getSerializable("user");
            txtName.setText(user.getTen());
            txtPhone.setText(user.getSdt());
            txtEmail.setText(user.getEmail());
            txtAddress.setText(user.getDiaChi());
        }






        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()) {
                    txtNewPass.setVisibility(View.VISIBLE);
                    txtNewPass2.setVisibility(View.VISIBLE);
                } else {
                    txtNewPass.setVisibility(View.INVISIBLE);
                    txtNewPass2.setVisibility(View.INVISIBLE);
                }


            }
        });
    }







}
