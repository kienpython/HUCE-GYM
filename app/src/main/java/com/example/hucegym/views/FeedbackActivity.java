package com.example.hucegym.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hucegym.R;
import com.example.hucegym.connect.ApiFeedBack;
import com.example.hucegym.retrofit.RetrofitClient;
import com.example.hucegym.utils.Utils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.internal.Util;
import retrofit2.Retrofit;

public class FeedbackActivity extends AppCompatActivity {

    EditText edtTenCoSo,editTenHoiVien,edtSoDienThoai,edtGmail,edtNoiDung;
    Button btnGopY;
    ApiFeedBack apiFeedBack;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        initView();
        initControl();

    }

    private void initControl(){
        btnGopY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guiGopY();
            }
        });
    }


    private void guiGopY(){
        String str_TenCoSo = edtTenCoSo.getText().toString().trim();
        String str_TenHoiVien = editTenHoiVien.getText().toString().trim();
        String str_SoDienThoai = edtSoDienThoai.getText().toString().trim();
        String str_Gmail = edtGmail.getText().toString().trim();
        String str_NoiDung = edtNoiDung.getText().toString().trim();
        Integer status = 1;
        //Kiểm tra các trường bắt buộc
        if(TextUtils.isEmpty(str_TenCoSo)){
            Toast.makeText(getApplicationContext(),"Bạn chưa nhập tên cơ sở",Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(str_TenHoiVien)) {
            Toast.makeText(getApplicationContext(),"Bạn chưa nhập tên hội viên",Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(str_SoDienThoai)) {
            Toast.makeText(getApplicationContext(),"Bạn chưa nhập số điện thoại",Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(str_Gmail)) {
            Toast.makeText(getApplicationContext(),"Bạn chưa nhập gmail",Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(str_NoiDung)) {
            Toast.makeText(getApplicationContext(),"Bạn chưa nhập nội dung",Toast.LENGTH_SHORT).show();
        }
        else{
            compositeDisposable.add(apiFeedBack.callFeedBack(str_NoiDung,str_Gmail,status,str_TenCoSo,str_TenHoiVien,str_SoDienThoai)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            feedBackModel -> {
                                if(feedBackModel.isSuccess()){
                                    Toast.makeText(getApplicationContext(),"thành công", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(getApplicationContext(),feedBackModel.getMessage(),Toast.LENGTH_SHORT).show();
                                }
                            },
                            throwable ->{
                                Toast.makeText(getApplicationContext(),throwable.getMessage(),Toast.LENGTH_SHORT).show();
                            }
                    ));
        }

    }
    private void initView(){
        apiFeedBack = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiFeedBack.class);
        btnGopY = findViewById(R.id.btnGopY);
        edtTenCoSo = findViewById(R.id.edtTenCoSo);
        editTenHoiVien = findViewById(R.id.editTenHoiVien);
        edtSoDienThoai = findViewById(R.id.edtSoDienThoai);
        edtGmail = findViewById(R.id.edtGmail);
        edtNoiDung = findViewById(R.id.edtNoiDung);

    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}