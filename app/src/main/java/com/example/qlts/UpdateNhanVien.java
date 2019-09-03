package com.example.qlts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class UpdateNhanVien extends AppCompatActivity {
    String url = "http://192.168.1.8:81/qlsv/update.php";
    EditText maNV, tenNV, ngaySinh, diaChi, soDT, matKhau, phongBan;
    Button Sua, Huy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_vien_adapter);
        anhXa();

        Intent intent = getIntent();
        NhanVien nhanVien = (NhanVien) intent.getSerializableExtra("dataNhanVien");

        maNV.setText(nhanVien.getMaNV());
        tenNV.setText(nhanVien.getTenNV());
        ngaySinh.setText(nhanVien.getNgaySinh() + "");
        diaChi.setText(nhanVien.getSoDT());
        soDT.setText(nhanVien.getSoDT());
        matKhau.setText(nhanVien.getMatKhau());
        phongBan.setText(nhanVien.getPhongBan());

        Sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CapNhat(url);
            }
        });

        Huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void CapNhat(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("success")) {
                    Toast.makeText(UpdateNhanVien.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(UpdateNhanVien.this, MainActivity.class));

                } else {
                    Toast.makeText(UpdateNhanVien.this, "Lỗi", Toast.LENGTH_SHORT).show();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UpdateNhanVien.this, "Xảy ra lỗi", Toast.LENGTH_SHORT).show();
                        Log.d("AAA", "Lỗi!\n" + error.toString());
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();
                param.put("maNV", String.valueOf(maNV));
                param.put("tenNV", tenNV.getText().toString().trim());
                param.put("ngaySinh", ngaySinh.getText().toString().trim());
                param.put("diaChi", diaChi.getText().toString().trim());
                param.put("soDT", soDT.getText().toString().trim());
                param.put("matKhau", matKhau.getText().toString().trim());
                param.put("phongBan", phongBan.getText().toString().trim());
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void anhXa() {
        tenNV = (EditText) findViewById(R.id.edtHoTen);
        ngaySinh = (EditText) findViewById(R.id.edtNamSinh);
        diaChi = (EditText) findViewById(R.id.edtDiaChi);
        soDT = (EditText) findViewById(R.id.edtSDT);
        matKhau = (EditText) findViewById(R.id.edtmatKhau);
        phongBan = (EditText) findViewById(R.id.edtPhongBan);
        Sua = (Button) findViewById(R.id.btnSua);
        Huy = (Button) findViewById(R.id.btnhuy);
    }
}
