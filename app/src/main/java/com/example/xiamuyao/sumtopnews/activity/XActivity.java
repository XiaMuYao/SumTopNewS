package com.example.xiamuyao.sumtopnews.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.xiamuyao.sumtopnews.R;
import com.example.xiamuyao.sumtopnews.constant.XConstant;
import com.example.xiamuyao.sumtopnews.util.AdbShellUtil;
import com.example.xiamuyao.sumtopnews.util.DOMTest;
import com.example.xiamuyao.sumtopnews.util.LL;
import com.stericson.RootTools.RootTools;
import com.stericson.RootTools.RootToolsException;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class XActivity extends AppCompatActivity {

    private TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x);
        tvText = findViewById(R.id.tvText);
        findViewById(R.id.saveid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {
                    List<String> list = null;

                    String[] strings = new String[2];
                    strings[0] = "su";
                    strings[1] = "uiautomator dump /sdcard/dump.xml";
                    list = RootTools.sendShell(strings, 0, 300000);
                    LL.e("shaomiao");
                    LL.e(list.get(0));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (RootToolsException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }


//                    RootCmd.execRootCmd("uiautomator dump /sdcard/dump.xml");


            }
        });
    }

    public void getActivity(View view) {
        String str = AdbShellUtil.getActivity();
        tvText.setText(str);
    }

    public void getTextByText(View view) {
        Map<String, Integer> ddddd = DOMTest.getCoordinateWithText("获取当前Activity", XConstant.UIFILE);
        tvText.setText(ddddd.toString());
    }


}