package com.example.comestic;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {


    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

//
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.activity_main)
        {
            this.finish();
        }
        return  super.onOptionsItemSelected(item);
    }


}