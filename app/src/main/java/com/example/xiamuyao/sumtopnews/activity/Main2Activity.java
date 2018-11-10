package com.example.xiamuyao.sumtopnews.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.xiamuyao.sumtopnews.R;
import com.example.xiamuyao.sumtopnews.adapter.MyAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView = findViewById(R.id.mRecylerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(i + "");
        }
        recyclerView.setAdapter(new MyAdapter(this, list));

    }
}
