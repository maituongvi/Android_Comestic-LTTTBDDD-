package com.example.comestic;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.model.SanPham;
import com.example.myadapter.CartAdapter;


import java.util.ArrayList;

public class GioHangActivity extends AppCompatActivity {
    public static ArrayList<SanPham> listSpOrders =new ArrayList<>();
    public static ArrayList<String> listSoLuongSP =new ArrayList<>();
    double tongTien = 0;
    public TextView total; //Tổng tiền hiện thị lên view
    SanPham sp ;
    RecyclerView recyclerView;
    CartAdapter cartAdapter;

    private Button btnDatHang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerViewGioHang1);
        cartAdapter = new CartAdapter(this,listSpOrders,listSoLuongSP);
        recyclerView.setAdapter(cartAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        total = findViewById(R.id.total);
        for(int i=0 ; i<listSpOrders.size() ;i++){
            SanPham p = listSpOrders.get(i);
            int soLuong1 = Integer.parseInt(listSoLuongSP.get(i)); // số lượng của từng sp trong list
            tongTien +=soLuong1*p.getGia();
        }
        total.setText(String.valueOf(tongTien));


        // Đặt hàng (Conduct Product)
        btnDatHang = findViewById(R.id.btn_dathang);
        btnDatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GioHangActivity.this, "Đặt hàng thành công", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
