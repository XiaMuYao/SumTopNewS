package com.example.xiamuyao.sumtopnews.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.xiamuyao.sumtopnews.R;
import com.example.xiamuyao.sumtopnews.constant.XConstant;
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
                String xx = RootCmd.execRootCmd("cat /storage/emulated/0/uidump.xml");
//                ReadTxtFile("/storage/emulated/0/uidump.xml");
                String xml1 = RootCmd.execRootCmd("cat " + "/storage/emulated/0/uidump.xml");
                Log.e("shaomiao",xml1);
                tv.setText(xml1);
                break;
            case R.id.btn1:
//                String file_path = "/sdcard/uidump.xml";
                String file_path = "/storage/sdcard0/aaa/xx.xml";
                RootCmd.execRootCmd("uiautomator dump " + XConstant.UIFILE);
                String xml = RootCmd.execRootCmd("cat " + XConstant.UIFILE);
                Log.e("shaomiao",xml);
                tv.setText(xml);
//                Map<String, Integer> coordinateWithResourceId = DOMTest.getCoordinateWithText("asdklhasldjlasjd", XConstant.UIFILE);
//                Map<String, Integer> coordinateWithResourceId = DOMTest.getCoordinateWithResourceId("com.songheng.eastnews:id/ak", file_path);
//                System.out.println("aaa" + coordinateWithResourceId);
//                tv.setText(coordinateWithResourceId.toString());
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
