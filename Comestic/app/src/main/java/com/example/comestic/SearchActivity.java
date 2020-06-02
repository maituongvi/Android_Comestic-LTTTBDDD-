package com.example.comestic;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SearchActivity<MaterialSearchView> extends AppCompatActivity {

    private BottomNavigationView searchNav;
    EditText searchText;
    Button btnDelete, btnBack;

    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        getSupportActionBar().hide();
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        searchNav = (BottomNavigationView) findViewById(R.id.search_nav);
        searchNav.setOnNavigationItemSelectedListener(navListener);

        searchText = (EditText) findViewById(R.id.editSearch);
        btnDelete =(Button) findViewById(R.id.btnDeleteSearch) ;
        btnBack =(Button) findViewById(R.id.btnBack);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchText.setText("");
            }
        });
        //MaterialSearchView searchView = (MaterialSearchView) findViewById(R.id.search_view);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()){
                case R.id.nav_cart:
                    Intent intent1 = new Intent(SearchActivity.this,OrderActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.nav_home:
                    Intent intent = new Intent(SearchActivity.this,MainActivity.class);
                    startActivity(intent);
                    break;

                case  R.id.nav_search:
                    Intent intent2 = new Intent(SearchActivity.this,SearchActivity.class);
                    startActivity(intent2);
                    break;
                case  R.id.nav_promotion:
                    Intent intent3 = new Intent(SearchActivity.this,PromotionActivity.class);
                    startActivity(intent3);
                    break;
                case R.id.nav_account:
                    Intent intent4 = new Intent(SearchActivity.this,AccountActivity.class);
                    startActivity(intent4);
            }
            //getSupportFragmentManager().beginTransaction().replace(R.id.order_fragment, selectedFragment).commit();

            return true;
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        int id = item.getItemId();
//        if(id == R.id.activity_main)
//        {
//            this.finish();
//        }
//        return  super.onOptionsItemSelected(item);
//    }


}