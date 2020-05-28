package com.example.comestic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AccountActivity extends Activity {
    EditText txtNewPass;
    EditText txtNewPass2;
    CheckBox checkBox;
    ImageView img;
    private BottomNavigationView accountNav;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account);

        accountNav = (BottomNavigationView) findViewById(R.id.account_nav);
        accountNav.setOnNavigationItemSelectedListener(navListener);
        // boolean check = false;
        txtNewPass = (EditText) findViewById(R.id.txtNewPass);
        txtNewPass2 = (EditText) findViewById(R.id.txtNewPass2);
        checkBox = findViewById(R.id.checkBox);


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
        private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;

                switch (menuItem.getItemId()){
                    case R.id.nav_cart:
                        Intent intent1 = new Intent(AccountActivity.this,OrderActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_home:
                        Intent intent = new Intent(AccountActivity.this,MainActivity.class);
                        startActivity(intent);
                        break;

                    case  R.id.nav_search:
                        Intent intent2 = new Intent(AccountActivity.this,SearchActivity.class);
                        startActivity(intent2);
                        break;
//                case  R.id.nav_promotion:
//                    Intent intent3 = new Intent(OrderActivity.this,SearchActivity.class);
//                    startActivity(intent3);
//                    break;
                    case R.id.nav_account:
                        Intent intent4 = new Intent(AccountActivity.this,AccountActivity.class);
                        startActivity(intent4);
                }
                //getSupportFragmentManager().beginTransaction().replace(R.id.order_fragment, selectedFragment).commit();

                return true;
            }
        };







}
