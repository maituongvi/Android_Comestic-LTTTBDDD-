package com.example.comestic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
<<<<<<< Updated upstream
import android.widget.ScrollView;
=======
>>>>>>> Stashed changes
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.model.LoaiSanPham;
import com.example.model.SanPham;
import com.example.model.User;
import com.example.myadapter.CategoryAdapter;
import com.example.myadapter.ImageAdapter;
import com.example.myadapter.ProductAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    VideoView mvideoView;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private BottomNavigationView mainNav;
    private FrameLayout mainFrame;
    private static final String TAG ="Main Activity";
<<<<<<< Updated upstream
    private Button btnMakeUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        dl = (DrawerLayout)findViewById(R.id.activity_main);
//        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);
//
//        dl.addDrawerListener(t);
//        t.syncState();
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().hide();


//        nv = (NavigationView)findViewById(R.id.nv);
//        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                int id = item.getItemId();
//                switch(id)
//                {
//                    case R.id.trangchu:
//
//                        Intent intents = new Intent(MainActivity.this,MainActivity.class);
//                        startActivity(intents);
//                        break;
//                    case R.id.taikhoan:
//                        Log.e(TAG, "ERROR");
//                        Intent intent4 = new Intent(MainActivity.this,AccountActivity.class);
//                        startActivity(intent4);
//                        break;
//                    case R.id.giohang:
//                        Intent intent1= new Intent(MainActivity.this,OrderActivity.class);
//                        startActivity(intent1);break;
//                    case R.id.dangxuat:
//                        Toast.makeText(MainActivity.this, "Đăng xuất", Toast.LENGTH_SHORT).show();break;
//                    default:
//                        return true;
//                }
//                return true;
//            }
//        });


        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPager);
        ImageAdapter adapter = new ImageAdapter(this);
        mViewPager.setAdapter(adapter);
=======
    private static ArrayList<LoaiSanPham> listLoaiSP;
    private RecyclerView recyclerView;
    private DatabaseReference mDatabase;
    private CategoryAdapter categoryAdapter;
    private Toolbar toolbar ;
    public static String email ;
    TextView ten_nav , email_nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar =findViewById(R.id.toolBar);

        setSupportActionBar(toolbar);
        Intent intentLogin = getIntent();
//        email = intentLogin.getStringExtra("email");



        dl = (DrawerLayout)findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl,toolbar,R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();

>>>>>>> Stashed changes

        btnMakeUp =(Button) findViewById(R.id.btnMakeUp);

<<<<<<< Updated upstream
        btnMakeUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,ComesticsProduct.class);
                startActivity(intent);
=======

        // RecyclerView
        listLoaiSP = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerViewLoaiSP);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Categories");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren() ){
                    LoaiSanPham p = dataSnapshot1.getValue(LoaiSanPham.class);
                    listLoaiSP.add(p);
                }

                categoryAdapter = new CategoryAdapter(listLoaiSP,getApplicationContext());
                recyclerView.setAdapter(categoryAdapter);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this,"Something is wrong!!!",Toast.LENGTH_SHORT).show();
            }
        });

        nv = (NavigationView)findViewById(R.id.nv);
        nv.bringToFront();
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
                        if(email ==null){
                            Intent intent4 = new Intent(MainActivity.this,LoginActivity.class);
                            startActivity(intent4);
                            break;
                        }
                        else{

                            mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");
                            mDatabase.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren() ){
                                        User p = dataSnapshot1.getValue(User.class);
                                        if(p.getEmail().equals(email)){
                                            Intent intent4 = new Intent(MainActivity.this,AccountActivity.class);
                                            intent4.putExtra("user",p);
                                            startActivity(intent4);
                                            break;


                                        }
                                    }
                                }
                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                    Toast.makeText(MainActivity.this,"Something is wrong!!!",Toast.LENGTH_SHORT).show();
                                }
                            });
                            break;
                        }
                    case R.id.giohang:
                        if(email ==null){
                            Toast.makeText(MainActivity.this,"Vui lòng đăng nhập để xem giỏ hàng!",Toast.LENGTH_SHORT).show();
                            Intent intent4 = new Intent(MainActivity.this,LoginActivity.class);
                            startActivity(intent4);
                            break;
                        }
                        else {
                            Intent intent1 = new Intent(MainActivity.this, GioHangActivity.class);
                            startActivity(intent1);
                            break;
                        }
                    case R.id.khuyenmai:
                        Intent intent2 = new Intent(MainActivity.this,PromotionActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.dangxuat:
                        email =null;
                        Toast.makeText(MainActivity.this, "Đăng xuất", Toast.LENGTH_SHORT).show();break;
                    default:
                        return true;
                }
                return true;
>>>>>>> Stashed changes
            }
        });

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

//        mainNav = (BottomNavigationView) findViewById(R.id.pro_nav);
//        mainNav.setOnNavigationItemSelectedListener(navListener);
        //mainNav.clearFocus();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

<<<<<<< Updated upstream
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            // Fragment selectedFragment = null;

            switch (menuItem.getItemId()){
=======
//    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//            // Fragment selectedFragment = null;
//
//            switch (menuItem.getItemId()){
>>>>>>> Stashed changes
//                case R.id.nav_home:
//                    Intent intents = new Intent(MainActivity.this,MainActivity.class);
//                    startActivity(intents);
//                    break;
<<<<<<< Updated upstream
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
=======
//                case R.id.nav_cart:
//                    Intent intent= new Intent(MainActivity.this,GioHangActivity.class);
//                    startActivity(intent);
//                    break;
//                case  R.id.nav_search:
//                    Intent intent1 = new Intent(MainActivity.this,MainActivity.class);
//                    startActivity(intent1);
//                    break;
//                case  R.id.nav_promotion:
//                    Intent intent2 = new Intent(MainActivity.this,PromotionActivity.class);
//                    startActivity(intent2);
//                    break;
//                case R.id.nav_account:
//                    if(email ==null){
//                        Intent intent4 = new Intent(MainActivity.this,LoginActivity.class);
//                        startActivity(intent4);
//                        break;
//                    }
//                    else{
//
//                        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");
//                        mDatabase.addValueEventListener(new ValueEventListener() {
//                            @Override
//                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren() ){
//                                    User p = dataSnapshot1.getValue(User.class);
//                                    if(p.getEmail().equals(email)){
//                                        Intent intent4 = new Intent(MainActivity.this,AccountActivity.class);
//                                        intent4.putExtra("user",p);
//                                        startActivity(intent4);
//                                        break;
//
//
//                                    }
//                                }
//                            }
//                            @Override
//                            public void onCancelled(@NonNull DatabaseError databaseError) {
//                                Toast.makeText(MainActivity.this,"Something is wrong!!!",Toast.LENGTH_SHORT).show();
//                            }
//                        });
//                        break;
//                    }
//            }
//            //getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, selectedFragment).commit();
//
//            return true;
//        }
//    };
>>>>>>> Stashed changes
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
