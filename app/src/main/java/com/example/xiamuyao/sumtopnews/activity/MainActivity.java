package com.example.xiamuyao.sumtopnews.activity;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.xiamuyao.sumtopnews.R;
import com.example.xiamuyao.sumtopnews.util.RootCmd;
import com.example.xiamuyao.sumtopnews.util.SystemManager;

public class MainActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
    }


    public void getRoot(View view) {
        RootCmd.haveRoot();
    }

    public void startTask(View mView) {
        Intent in = new Intent();
        in.setClassName("com.songheng.eastnews", "com.oa.eastfirst.activity.WelcomeActivity");
        startActivity(in);
    }
    public void settting(View mview){
        Intent accessibleIntent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
        startActivity(accessibleIntent);
    }


}
