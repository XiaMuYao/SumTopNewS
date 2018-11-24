package com.example.xiamuyao.sumtopnews.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.xiamuyao.sumtopnews.R;
import com.example.xiamuyao.sumtopnews.util.AbdShellUtil;

public class XActivity extends AppCompatActivity {

    private TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x);
        tvText = findViewById(R.id.tvText);
    }
    public void getActivity(View view) {
        String activity = AbdShellUtil.getActivity();
        tvText.setText(activity);
    }
}
