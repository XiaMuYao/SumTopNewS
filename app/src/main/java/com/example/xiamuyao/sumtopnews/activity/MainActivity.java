package com.example.xiamuyao.sumtopnews.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.xiamuyao.sumtopnews.R;
import com.example.xiamuyao.sumtopnews.util.RootCmd;

/**
 * MyAccessibilityService
 * 东方头条、中青看点、趣头条、蚂蚁头条、头条多多、2345浏览器、
 * 海草公社、掌上头条、聚看点、芒果看点、值得看看、红包头条、
 * 聚合头条、大众看点、点点新闻、掌上头条
 *
 * /Users/shaomiao/Library/Android/sdk/tools/moitor
 */
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

    // 打开东方头条
    public void startTask(View mView) {
        Intent in = new Intent();
        in.setClassName("com.songheng.eastnews", "com.oa.eastfirst.activity.WelcomeActivity");
        startActivity(in);
    }

    public void settting(View mview){
        Intent accessibleIntent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
        startActivity(accessibleIntent);
    }

    public void outShell(View view) {
        if (RootCmd.haveRoot()) {
            String str = RootCmd.execRootCmd("dumpsys activity");
            Log.e(RootCmd.TAG,str);
        }
    }

    // 打开中青看点
    public void startZhongQing(View view) {
        Intent in = new Intent();
        in.setClassName("cn.youth.news","com.weishang.wxrd.activity.SplashActivity");
        startActivity(in);
    }

    // 打开蚂蚁头条
    public void startMaYiTouTiao(View view) {
        Intent in = new Intent();
        in.setClassName("com.cashnews.spicy","com.cashnews.spicy.splash.activity.SplashActivity");
        startActivity(in);
    }

    //打开趣头条
    public void startQuTouTiao(View view) {
        Intent in = new Intent();
        in.setClassName("com.jifen.qukan","com.jifen.qkbase.main.MainActivity");
        startActivity(in);
    }

    //打开2345浏览器
    public void start2345(View view) {
        Intent in = new Intent();
        in.setClassName("com.browser2345","com.browser2345.BrowserActivity");
        startActivity(in);
    }

    // 打开海草公社
    public void startHaiCao(View view) {
        Intent in = new Intent();
        in.setClassName("com.billionstech.grassbook","com.billionstech.grassbook.business.launcher.welcome.WelComeActivity");
        startActivity(in);
    }

    // 打开红包头条
    public void startHongBaoTouTiao(View view) {
        Intent in = new Intent();
        in.setClassName("com.martian.hbnews","com.martian.hbnews.activity.MartianAppStart");
        startActivity(in);
    }

    // 打开聚看点
    public void startJuKanDian(View view) {
        Intent in = new Intent();
        in.setClassName("com.xiangzi.jukandian","com.xiangzi.jukandian.activity.V2WelcomeActivity");
        startActivity(in);
    }

    // 打开芒果看点
    public void startMangGuoKandian(View view) {
        Intent in = new Intent();
        in.setClassName("com.kuaixun.mgkd","com.kuaixun.mgkd.module.main.start.StartActivity");
        startActivity(in);
    }

    // 打开微鲤看看
    public void startWeiLiKanKan(View view) {
        Intent in = new Intent();
        in.setClassName("cn.weli.story","cn.etouch.ecalendar.LoadingActivity");
        startActivity(in);
    }


    // 打开值得看看
    public void startZhiDeKanKan(View view) {
        Intent in = new Intent();
        in.setClassName("com.weikuai.wknews","com.weikuai.wknews.ui.activity.MainActivity");
        startActivity(in);
    }

    // 打开点点新闻
    public void startDianDianXinWen(View view) {
        Intent in = new Intent();
        in.setClassName("com.yingliang.clicknews","com.yingliang.clicknews.module.splash.SplashActivity");
        startActivity(in);
    }
}
