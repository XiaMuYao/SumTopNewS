package com.example.xiamuyao.sumtopnews.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.xiamuyao.sumtopnews.R;
import com.example.xiamuyao.sumtopnews.util.DOMTest;
import com.example.xiamuyao.sumtopnews.util.RootCmd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * created by tea9 at 2018/11/24
 */
public class DomTestActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn, btn1;
    private TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dom_test);
        btn = findViewById(R.id.btn);
        btn1 = findViewById(R.id.btn1);
        tv = findViewById(R.id.tv);

        btn.setOnClickListener(this);
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn:

                String xx = RootCmd.execRootCmd("cat /data/local/tmp/uidump.xml");
                ReadTxtFile("/data/local/tmp/uidump.xml");
                tv.setText(zz);
                break;
            case R.id.btn1:
                Map<String, Integer> coordinateWithResourceId = DOMTest.getCoordinateWithResourceId("cn.com.spdb.mobilebank.per:id/tv_login_register_acc", "/data/local/tmp/uidump.xml");
                System.out.println("aaa" + coordinateWithResourceId);
                tv.setText(coordinateWithResourceId.toString());
                break;
        }
    }

    private static List<String> newList;
    private static String zz;

    public static String ReadTxtFile(String strFilePath) {
        String path = strFilePath;
        newList = new ArrayList<String>();
        //打开文件
        File file = new File(path);
        //如果path是传递过来的参数，可以做一个非目录的判断
        if (file.isDirectory()) {
            Log.d("TestFile", "The File doesn't not exist.");
        } else {
            try {
                InputStream instream = new FileInputStream(file);
                if (instream != null) {
                    InputStreamReader inputreader = new InputStreamReader(instream);
                    BufferedReader buffreader = new BufferedReader(inputreader);
                    String line;
                    //分行读取
                    while ((line = buffreader.readLine()) != null) {
                        newList.add(line + "\n");
                        zz+=line;
                    }
                    instream.close();
                }
            } catch (FileNotFoundException e) {
                Log.d("TestFile", "The File doesn't not exist.");
            } catch (IOException e) {
                Log.d("TestFile", e.getMessage());
            }
        }
        return strFilePath;

    }
}
