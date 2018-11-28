package com.example.xiamuyao.sumtopnews.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.xiamuyao.sumtopnews.R;
import com.example.xiamuyao.sumtopnews.service.TestService;
import com.example.xiamuyao.sumtopnews.util.DOMTest;
import com.example.xiamuyao.sumtopnews.util.RootCmd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;

/**
 * created by tea9 at 2018/11/24
 */
public class DomTestActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7;
    private TextView tv;
    public static String TAG = "teaaaaa";
    public static String file_path = "/sdcard/dump.xml";
    private String file_path1 = "/storage/sdcard0/dump.xml";

    private static Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dom_test);
        btn2 = findViewById(R.id.btn2);
        btn1 = findViewById(R.id.btn1);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        tv = findViewById(R.id.tv);

        btn2.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn2: //生成文件
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        RootCmd.execRootCmd("uiautomator dump " + file_path);
                        Log.e(TAG, "aaa");
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                tv.setText("使用Handler.post在工作线程中发送一段执行到消息队列中，在主线程中执行。");
                            }
                        });
                    }
                }).start();
                break;
            case R.id.btn1: //输出文件
                String xx = RootCmd.execRootCmd("cat " + file_path);
                tv.setText(xx);
                break;
            case R.id.btn3: //根据文字获取坐标
                new Thread(new Runnable() {
                    @Override
                    public void run() {
//                Map<String, Integer> ddddd = DOMTest.getCoordinateWithText("com.example.xiamuyao.sumtopnews:id/btn3", XConstant.UIFILE);
                        Map<String, Integer> ddddd = DOMTest.getCoordinateWithResourceId("com.example.xiamuyao.sumtopnews:id/btn3", file_path);
//                        tv.setText(ddddd.toString());
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                tv.setText("使用Handler.post在工作线程中发送一段执行到消息队列中，在主线程中执行。");
                                if (ddddd != null) {
                                    tv.setText(ddddd.toString());
                                }
                            }
                        });
                    }
                }).start();
                break;
            case R.id.btn4: // 判断文件是否存在
                File file = new File(file_path);
                tv.setText(file.getAbsolutePath() + "  " + file.isFile());

                break;
            case R.id.btn5: //读取文件
                try {
                    String zz = fileRead(file_path);
                    tv.setText(zz);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
            case R.id.btn6: // 解析文件
                Log.e(TAG, "跳转");
                RootCmd.execRootCmdSilent("am start com.songheng.eastnews/com.oa.eastfirst.activity.WelcomeActivity");
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                RootCmd.execRootCmdSilent("am start cn.youth.news/com.weishang.wxrd.activity.SplashActivity");
//                String[] strings = new String[2];
//                strings[0] = "su";
//                strings[1] = "am start cn.youth.news/com.weishang.wxrd.activity.SplashActivity";
//                try {
//                    List<String> list = RootTools.sendShell(strings, 0, 5000);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } catch (RootToolsException e) {
//                    e.printStackTrace();
//                } catch (TimeoutException e) {
//                    e.printStackTrace();
//                }
//                    }
//                }).start();
                break;
            case R.id.btn7:// 开启服务
                Log.e(TAG, "start service");
                Intent i = new Intent(this, TestService.class);
                startService(i);
                break;
        }
    }

    private String fileRead(String file_path) throws Exception {
        File file = new File(file_path);
        FileReader reader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        String s = "";
        while ((s = bReader.readLine()) != null) {
            sb.append(s + "\n");
        }
        bReader.close();
        return sb.toString();
    }
}
