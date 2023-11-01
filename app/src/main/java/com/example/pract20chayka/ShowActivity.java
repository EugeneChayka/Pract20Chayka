package com.example.pract20chayka;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
public class ShowActivity extends AppCompatActivity {
    private TextView tvName,tvSName,tvMail;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_layout);
        init();
        getIntentMain();
    }
    private void init()
    {
        tvName=findViewById(R.id.tvName);
        tvSName=findViewById(R.id.tvSName);
        tvMail=findViewById(R.id.tvMail);
    }
    private  void getIntentMain()
    {
        Intent i=getIntent();
        if(i !=null)
        {
            tvName.setText(i.getStringExtra(Constant.USER_Name));
            tvSName.setText(i.getStringExtra(Constant.USER_SName));
            tvMail.setText(i.getStringExtra(Constant.USER_Mail));

        }
    }
}
