package com.example.qlts;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

public class NhanVienAdapter extends AppCompatActivity implements ListAdapter {

    private MainActivity context;
    private int layout;
    private List<NhanVien> arrayList;

    public NhanVienAdapter(MainActivity context, int layout, List<NhanVien> arrayList){
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int i) {
        return false;
    }

    private class ViewHolder{
        TextView txtNhanVien, txtPhong;
        ImageView imgDelete, imgUpdate;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        NhanVienAdapter.ViewHolder holder;
        if (convertView == null){
            holder = new NhanVienAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.txtNhanVien = (TextView) convertView.findViewById(R.id.txtNhanVien);
            holder.txtPhong = (TextView) convertView.findViewById(R.id.txtPhong);
            holder.imgDelete = (ImageView) convertView.findViewById(R.id.btndelete);
            holder.imgUpdate = (ImageView) convertView.findViewById(R.id.btnupdate);
            convertView.setTag(holder);
        }else {
            holder = (NhanVienAdapter.ViewHolder) convertView.getTag();
        }
        final NhanVien student = arrayList.get(position);
        holder.txtNhanVien.setText(student.getTenNV());
        holder.txtPhong.setText(student.getPhongBan());
//
//        holder.imgUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(context, UpdateNhanVien.class);
//                i.putExtra("dataSinhVien", student);
//                context.startActivity(i);
//            }
//        });
//        holder.imgdel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                XacNhanXoa(student.getHoTen(), student.getMaSV());
//            }
//        });
        return convertView;
    }

    @Override
    public int getItemViewType(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

//    private void XacNhanXoa(String ten, final int id){
//        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
//        dialog.setMessage("Bạn có muốn xoá sinh viên "+ten+" không?");
//        dialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                context.deleteStudent(id);
//            }
//        });
//        dialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//        dialog.show();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_vien_adapter);
    }
}
