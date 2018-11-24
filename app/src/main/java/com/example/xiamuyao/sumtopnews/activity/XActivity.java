package com.example.xiamuyao.sumtopnews.activity;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.xiamuyao.sumtopnews.R;
import com.example.xiamuyao.sumtopnews.util.AdbShellUtil;
import com.example.xiamuyao.sumtopnews.util.DOMTest;
import com.example.xiamuyao.sumtopnews.util.RootCmd;

import java.util.Map;

public class XActivity extends AppCompatActivity {

    private TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x);
        tvText = findViewById(R.id.tvText);
    }
    public void getActivity(View view) {
        String str = AdbShellUtil.getActivity();
        tvText.setText(str);
    }

    public void getTextByText(View view) {
        Map<String, Integer> ddddd = DOMTest.getCoordinateWithText("获取当前Activity", Environment.getExternalStorageDirectory().getPath()+"/uidump.xml");
        tvText.setText(ddddd.toString());
    }

    public void saveXmlToLocal(View view) {
        String s = RootCmd.execRootCmd("uiautomator dump /sdcard/uidump.xml");
        tvText.setText(s);
    }
}
