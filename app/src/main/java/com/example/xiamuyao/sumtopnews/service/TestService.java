package com.example.xiamuyao.sumtopnews.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.xiamuyao.sumtopnews.activity.DomTestActivity;
import com.example.xiamuyao.sumtopnews.util.RootCmd;

/**
 * created by tea9 at 2018/11/25
 */
public class TestService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        startActivity();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void startActivity() {
        Log.e(DomTestActivity.TAG,"start service activity");
        new Thread(new Runnable() {
            @Override
            public void run() {
                RootCmd.execRootCmdSilent("am start com.songheng.eastnews/com.oa.eastfirst.activity.WelcomeActivity");
            }
        }).start();

    }

    private void aaa() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                /**
                 * 启动目标app
                 * 生成文件
                 * 获取坐标
                 * 点击
                 * 模拟滑动
                 */
                try {
                    Log.e(DomTestActivity.TAG,"start service aaa");
                    RootCmd.execRootCmdSilent("am start com.songheng.eastnews/com.oa.eastfirst.activity.WelcomeActivity");
                    Log.e(DomTestActivity.TAG,"start service bbb");
                    Thread.sleep(3 * 1000);
                    Log.e(DomTestActivity.TAG,"start service ccc");
                    RootCmd.execRootCmd("uiautomator dump " + DomTestActivity.file_path);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
