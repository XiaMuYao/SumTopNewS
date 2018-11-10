package com.example.xiamuyao.sumtopnews;

import android.app.Application;

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/11/10
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class App extends Application {
    private static App app =null;
    @Override
    public void onCreate() {
        super.onCreate();
        app =this;
    }

    public static App getApp() {
        return app;
    }
}

