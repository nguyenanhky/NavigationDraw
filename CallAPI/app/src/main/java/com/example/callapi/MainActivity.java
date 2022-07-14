package com.example.callapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.callapi.Api.ApiService;
import com.example.callapi.model.Curroncy;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView tv_term, tv_source, tv_usdvnd;
    private Button btn_call_api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Gson dung de chuyen tu obj==> json
        tv_term = findViewById(R.id.tv_term);
        tv_source = findViewById(R.id.tv_source);
        tv_usdvnd = findViewById(R.id.tv_undvnd);

        btn_call_api = findViewById(R.id.btn_call_api);

        btn_call_api.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickcallapi();
            }
        });


    }

    private void clickcallapi() {
        // buocs 1 : khai bao permisson
        // buoc 2 : Apiservice
        // truyen key
//        // cach 1
//        ApiService.apiService.convertUsdtoVND("843d4d34ae72b3882e3db642c51e28e6",
//                "VND", "USD", 1).enqueue(new Callback<Curroncy>() {
//            @Override
//            public void onResponse(Call<Curroncy> call, Response<Curroncy> response) {
//                // neu call api thanh cong thi no se tra ve day
//                Toast.makeText(MainActivity.this, "call api successs", Toast.LENGTH_SHORT).show();
//                Curroncy curroncy = response.body();
//                if(curroncy!=null && curroncy.isSuccess()){
//                    tv_term.setText(curroncy.getTerms());
//                    tv_source.setText(curroncy.getSource());
//                    tv_usdvnd.setText(String.valueOf(curroncy.getQuotes().getUSDVND()));
//                }else{
//                    Toast.makeText(MainActivity.this, "loi roi ban oi ", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Curroncy> call, Throwable t) {
//                // neu call api error thi return here
//                Toast.makeText(MainActivity.this, "Call Api Error", Toast.LENGTH_SHORT).show();
//
//            }
//        });
        // cach 2
        ApiService.apiService.convertUSDtoVND1().enqueue(new Callback<Curroncy>() {
            @Override
            public void onResponse(Call<Curroncy> call, Response<Curroncy> response) {
                // neu call api thanh cong thi no se tra ve day
                Toast.makeText(MainActivity.this, "call api successs", Toast.LENGTH_SHORT).show();
//                Curroncy curroncy = response.body();
//                if(curroncy!=null && curroncy.isSuccess()){
//                    tv_term.setText(curroncy.getTerms());
//                    tv_source.setText(curroncy.getSource());
//                    tv_usdvnd.setText(String.valueOf(curroncy.getQuotes().getUSDVND()));
//                }else{
//                    Toast.makeText(MainActivity.this, "loi roi ban oi ", Toast.LENGTH_SHORT).show();
//                }
            }

            @Override
            public void onFailure(Call<Curroncy> call, Throwable t) {
                // neu call api error thi return here
                Toast.makeText(MainActivity.this, "Call Api Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}