package com.example.comestic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.myadapter.ImageAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    VideoView mvideoView;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private BottomNavigationView mainNav;
    private FrameLayout mainFrame;
    private static final String TAG ="Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG,"On Create");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dl = (DrawerLayout)findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        nv = (NavigationView)findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.trangchu:

                        Intent intents = new Intent(MainActivity.this,MainActivity.class);
                        startActivity(intents);
                        break;
                    case R.id.taikhoan:
                        Log.e(TAG, "ERROR");
                        Intent intent4 = new Intent(MainActivity.this,AccountActivity.class);
                        startActivity(intent4);
                        break;
                    case R.id.giohang:
                        Intent intent1= new Intent(MainActivity.this,OrderActivity.class);
                        startActivity(intent1);break;
                    case R.id.dangxuat:
                        Toast.makeText(MainActivity.this, "Đăng xuất", Toast.LENGTH_SHORT).show();break;
                    default:
                        return true;
                }
                return true;
            }
        });

        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPager);
        ImageAdapter adapter = new ImageAdapter(this);
        mViewPager.setAdapter(adapter);

        //load video
        mvideoView = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.nuochoagooggirl );
        try {
            mvideoView.setVideoURI(uri);
        } catch (NullPointerException techmaster1)
        {
            System.out.println("Couldn't load video" + techmaster1);
        }
        mvideoView.start();

        //bottom navigation

        mainNav = (BottomNavigationView) findViewById(R.id.main_nav);
        mainNav.setOnNavigationItemSelectedListener(navListener);
        //mainNav.clearFocus();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            // Fragment selectedFragment = null;

            switch (menuItem.getItemId()){
                case R.id.nav_home:
                    Intent intents = new Intent(MainActivity.this,MainActivity.class);
                    startActivity(intents);
                    break;
                case R.id.nav_cart:
                    Intent intent= new Intent(MainActivity.this,OrderActivity.class);
                    startActivity(intent);
                    break;
                case  R.id.nav_search:
                    Intent intent1 = new Intent(MainActivity.this,SearchActivity.class);
                    startActivity(intent1);
                    break;
                case  R.id.nav_promotion:
                    Intent intent2 = new Intent(MainActivity.this,PromotionActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.nav_account:
                    Intent intent4 = new Intent(MainActivity.this,AccountActivity.class);
                    startActivity(intent4);
            }
            //getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, selectedFragment).commit();

            return true;
        }
    };
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.e(TAG,"On Start");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        Log.e(TAG, "On Resume");
//    }


    @Override
    protected void onRestart() {
        super.onRestart();
//        Intent intents = new Intent(MainActivity.this,MainActivity.class);
//        startActivity(intents);
        //setContentView(R.layout.activity_main);
        mvideoView = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.nuochoagooggirl );
        try {
            mvideoView.setVideoURI(uri);
        } catch (NullPointerException techmaster1)
        {
            System.out.println("Couldn't load video" + techmaster1);
        }
        mvideoView.start();

    }



}
