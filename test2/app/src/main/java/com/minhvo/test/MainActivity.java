package com.minhvo.test;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void NhapLieu(View v){
        Intent iNhap=new Intent(this,Input.class);
        startActivityForResult(iNhap,8000);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode==8000){
            if(resultCode==RESULT_OK){
                String hoTenNhanDuoc=data.getStringExtra("HT");
                int namSinhNhanDuoc=data.getIntExtra("NS",2023);
                TextView tvName=(TextView)findViewById(R.id.Name);
                TextView tvBirth=(TextView)findViewById(R.id.Birth);
                tvName.setText(hoTenNhanDuoc);
                tvBirth.setText(String.valueOf(namSinhNhanDuoc));
            }
            else
                Toast.makeText(this,"Trả về thất bại",Toast.LENGTH_LONG);
        }
        else
            super.onActivityResult(requestCode,resultCode,data);
    }
}