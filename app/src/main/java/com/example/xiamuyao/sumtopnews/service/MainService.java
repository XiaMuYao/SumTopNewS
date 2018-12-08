package com.example.xiamuyao.sumtopnews.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.example.xiamuyao.sumtopnews.R;
import com.example.xiamuyao.sumtopnews.activity.MainActivity;
import com.example.xiamuyao.sumtopnews.util.Constant;
import com.example.xiamuyao.sumtopnews.util.DataCleanManager;
import com.example.xiamuyao.sumtopnews.util.ShellUtil;

/**
 * created by tea9 at 2018/11/25
 * <p>
 * TODO
 * 检测弹窗
 * 滑动边距检测
 * 检测首页
 * 清理后台通用方法
 * 前台服务
 */
///Users/shaomiao/Library/Android/sdk/tools/monitor

/**
 * home
 * 清理后台
 * 检测应用授权
 * 正在清理应用缓存
 * 正在检测应用授权情况
 * 正在清理应用缓存
 * 正在执行主页判断如果15秒后仍未成功打开主页，将开始检测弹窗
 * 主页判断成功
 * 点击任务
 * 主页判断
 * 当前循环芒果看点0次，还有10次未循环
 * 刷新
 * 点击item
 * 滑动
 * 距离下次滑动4457 坐标偏移量653
 * 距下次滑动3407 坐标偏移量9499
 * 3908 3237
 * 3908 5291
 * 点击展开全文
 * 3974 1077
 * 4990 2539
 * 返回
 * 正在执行主页判断
 * 主页判断成功
 * 刷新
 * 当前共循环阅读芒果看点1次还有9次未循环
 * 点击第1个item
 * 距下次 4714 3542
 * 4452 34
 * 3776 758
 */

/**
 * 东方头条、中青看点、趣头条、蚂蚁头条、头条多多、2345浏览器、海草公社、掌上头条、聚看点、芒果看点、值得看看、红包头条、聚合头条、大众看点、点点新闻
 */

/**
 * 红包
 * 签到
 * 滑动时间
 * 关后台
 * 授权码
 * 定时任务
 * 关弹窗
 */

/**
 * 微信小号
 *
 */

/**
 * 1.签到 ===
 * 2.领取红包  ===
 * 3.滑动速度 时间 每个软件在判断 1.5秒 ===
 * 4.点开展开全文 ===
 * 5.注册码授权  待确认
 * 6.更新 弹窗更新 ===
 * 7.定时 12小时 6个 9个 待确认app列表 ===
 * 8.清理后台 ===
 * 9.循环时间 每个软件执行时间 ===
 * 10.平台卡住 不能正常运行  在执行当前卡住的 时间待确认 ===
 * 11.来电时停止运行脚本 设置 ===
 * 12.设置列表里的
 * 13.悬浮窗控制脚本
 * 14.随机浏览 ===
 * 15.全局延时
 * 16.软件分身
 * 17.鼎盛科技 软件名
 * 18.界面好看一点
 *
 *  * 东方头条、中青看点、趣头条、蚂蚁头条、头条多多、2345浏览器、海草公社、掌上头条、聚看点、芒果看点、值得看看、红包头条、聚合头条、大众看点、点点新闻、微鲤看看
 *
 *  待确认
 *  微信号
 */
public class MainService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        // 前台服务
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("android_touch")
                .setContentText("android_touch")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .build();
        startForeground(1, notification);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    startDongFang();
//                    startZhongQing(); // 测试中青 刷新点击
                    startDongFang();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    // 打开东方头条
    private void startDongFang() throws InterruptedException {
        showToastByRunnable(getApplicationContext(), "返回桌面");
        ShellUtil.home();
        showToastByRunnable(getApplicationContext(), "清理缓存");
        ShellUtil.clear();
        Thread.sleep(3 * 1000);
        showToastByRunnable(getApplicationContext(), "打开应用");
        ShellUtil.startActivity(Constant.DongFang.ACTIVITY_PACKAGE);
        // 判断首页页面
        Thread.sleep(15 * 1000);
        boolean check_home = false;

        if (ShellUtil.checkPage(Constant.DongFang.RES_ID_RED)) { // 红包页面
            showToastByRunnable(getApplicationContext(), "红包页面");
            Thread.sleep(2 * 1000);
            ShellUtil.back(); //返回按钮
        }

        if (ShellUtil.checkPage(Constant.DongFang.RES_ID_BTN1)) { // 首页
            showToastByRunnable(getApplicationContext(), "判断首页成功");
            check_home = true;
        } else { // 不是首页
            showToastByRunnable(getApplicationContext(), "判断首页失败");
            Thread.sleep(15 * 1000); // 等待15秒 在判断首页 然后执行程序
            if (ShellUtil.checkPage(Constant.DongFang.RES_ID_BTN1)) {
                check_home = true;
            }
            check_home = false;
        }
        if (check_home) { // 点击循环
            showToastByRunnable(getApplicationContext(), "循环10次");
            for (int i = 0; i < 10; i++) {
                showToastByRunnable(getApplicationContext(), "循环第" + (i + 1) + "次");
//                            showToastByRunnable(getApplicationContext(), "点击刷新");
                ShellUtil.tapButton(Constant.DongFang.RES_ID_BTN1); // 点击刷新
                Thread.sleep(5 * 1000);
//                            showToastByRunnable(getApplicationContext(), "点击item1");
                ShellUtil.tapButton(Constant.DongFang.RES_ID_ITEM1); // 点击item1
                //////////////滑动////////////////////////
                Thread.sleep(3 * 1000);
//                            showToastByRunnable(getApplicationContext(), "返回");
                ShellUtil.back();
            }
            showToastByRunnable(getApplicationContext(), "循环结束");
        }
    }

    // 打开芒果看点
    private void startMangGuo() throws InterruptedException {
        showToastByRunnable(getApplicationContext(), "返回桌面");
        ShellUtil.home();
        showToastByRunnable(getApplicationContext(), "清理缓存");
        ShellUtil.clear();
        Thread.sleep(3 * 1000);
        showToastByRunnable(getApplicationContext(), "打开应用");
        ShellUtil.startActivity(Constant.DongFang.ACTIVITY_PACKAGE);  // 变量
        // 判断首页页面
        Thread.sleep(15 * 1000);
        boolean check_home = false;

        if (ShellUtil.checkPage(Constant.DongFang.RES_ID_RED)) { // 红包页面
            showToastByRunnable(getApplicationContext(), "红包页面");
            Thread.sleep(2 * 1000);
            ShellUtil.back(); //返回按钮
        }

        if (ShellUtil.checkPage(Constant.DongFang.RES_ID_BTN1)) { // 首页
            showToastByRunnable(getApplicationContext(), "判断首页成功");
            check_home = true;
        } else { // 不是首页
            showToastByRunnable(getApplicationContext(), "判断首页失败");
            Thread.sleep(15 * 1000); // 等待15秒 在判断首页 然后执行程序
            if (ShellUtil.checkPage(Constant.DongFang.RES_ID_BTN1)) {
                check_home = true;
            }
            check_home = false;
        }
        if (check_home) { // 点击循环
            showToastByRunnable(getApplicationContext(), "循环10次");
            for (int i = 0; i < 10; i++) {
                showToastByRunnable(getApplicationContext(), "循环第" + (i + 1) + "次");
//                            showToastByRunnable(getApplicationContext(), "点击刷新");
                ShellUtil.tapButton(Constant.DongFang.RES_ID_BTN1); // 点击刷新
                Thread.sleep(5 * 1000);
//                            showToastByRunnable(getApplicationContext(), "点击item1");
                ShellUtil.tapButton(Constant.DongFang.RES_ID_ITEM1); // 点击item1
                //////////////滑动////////////////////////
                Thread.sleep(3 * 1000);
//                            showToastByRunnable(getApplicationContext(), "返回");
                ShellUtil.back();
            }
            showToastByRunnable(getApplicationContext(), "循环结束");
        }
    }

    // 打开中青看点
    private void startZhongQing() throws InterruptedException {
        showToastByRunnable(getApplicationContext(), "返回桌面");
        ShellUtil.home();
        showToastByRunnable(getApplicationContext(), "清理缓存");
        ShellUtil.clear();
        Thread.sleep(3 * 1000);
        showToastByRunnable(getApplicationContext(), "打开应用");
        ShellUtil.startActivity(Constant.ZhongQing.ACTIVITY_PACKAGE);  // 变量
        // 判断首页页面
        Thread.sleep(15 * 1000);
        boolean check_home = false;

        if (ShellUtil.checkPage(Constant.ZhongQing.RES_ID_RED)) { // 红包页面 变量
            showToastByRunnable(getApplicationContext(), "红包页面");
            Thread.sleep(2 * 1000);
            ShellUtil.back(); //返回按钮
        }

        if (ShellUtil.checkPage(Constant.ZhongQing.RES_ID_BTN1)) { // 首页
            showToastByRunnable(getApplicationContext(), "判断首页成功");
            check_home = true;
        } else { // 不是首页
            showToastByRunnable(getApplicationContext(), "判断首页失败");
            Thread.sleep(15 * 1000); // 等待15秒 在判断首页 然后执行程序
            if (ShellUtil.checkPage(Constant.ZhongQing.RES_ID_BTN1)) {
                check_home = true;
            }
            check_home = false;
        }
        if (check_home) { // 点击循环
            showToastByRunnable(getApplicationContext(), "循环10次");
            for (int i = 0; i < 10; i++) {
                showToastByRunnable(getApplicationContext(), "循环第" + (i + 1) + "次");
                            showToastByRunnable(getApplicationContext(), "点击刷新");
                Thread.sleep(3 * 1000);
                ShellUtil.tapButton(Constant.ZhongQing.RES_ID_BTN1); // 点击刷新
                Thread.sleep(5 * 1000);
//                            showToastByRunnable(getApplicationContext(), "点击item1");
//                ShellUtil.tapButton(Constant.ZhongQing.RES_ID_ITEM1); // 点击item1 TODO 修改策略 点击 下一条 还要滑动一屏幕
                //////////////滑动////////////////////////
//                Thread.sleep(3 * 1000);
//                            showToastByRunnable(getApplicationContext(), "返回");
//                ShellUtil.back();
            }
            showToastByRunnable(getApplicationContext(), "循环结束");
        }
    }

    // 打开蚂蚁头条
    private void startMaYi() throws InterruptedException {
        showToastByRunnable(getApplicationContext(), "返回桌面");
        ShellUtil.home();
        Thread.sleep(3*1000);
        DataCleanManager.clearAllCache(getApplicationContext());
        Thread.sleep(3*1000);
        showToastByRunnable(getApplicationContext(), "清理缓存");
        ShellUtil.clear();
        Thread.sleep(3 * 1000);
        showToastByRunnable(getApplicationContext(), "打开应用");
        ShellUtil.startActivity(Constant.MaYi.ACTIVITY_PACKAGE);  // 变量
        // 判断首页页面
        Thread.sleep(15 * 1000);
        boolean check_home = false;

//        if (ShellUtil.checkPage(Constant.ZhongQing.RES_ID_RED)) { // 红包页面 变量
//            showToastByRunnable(getApplicationContext(), "红包页面");
//            Thread.sleep(2 * 1000);
//            ShellUtil.back(); //返回按钮
//        }
//
        if (ShellUtil.checkPage(Constant.MaYi.RES_ID_ITEM1)) { // 首页
            showToastByRunnable(getApplicationContext(), "判断首页成功");
            check_home = true;
        } else { // 不是首页
            showToastByRunnable(getApplicationContext(), "判断首页失败");
            Thread.sleep(15 * 1000); // 等待15秒 在判断首页 然后执行程序
            if (ShellUtil.checkPage(Constant.MaYi.RES_ID_ITEM1)) {
                check_home = true;
            }
            check_home = false;
        }
        if (check_home) { // 点击循环
            showToastByRunnable(getApplicationContext(), "循环10次");
            for (int i = 0; i < 10; i++) {
                showToastByRunnable(getApplicationContext(), "循环第" + (i + 1) + "次");
                showToastByRunnable(getApplicationContext(), "点击刷新");
                Thread.sleep(3 * 1000);
//                ShellUtil.swipeRefresh(); // 滑动刷新
                Thread.sleep(5 * 1000);
////                            showToastByRunnable(getApplicationContext(), "点击item1");
                ShellUtil.tapButton(Constant.MaYi.RES_ID_ITEM1); // 点击item1
//                //////////////滑动////////////////////////
                Thread.sleep(4 * 1000);
////                            showToastByRunnable(getApplicationContext(), "返回");
                ShellUtil.back();
            }
            showToastByRunnable(getApplicationContext(), "循环结束");
        }
    }

    private void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                /**
                 * 启动目标app  597 1758   1384
                 * 生成文件
                 * 获取坐标
                 * 点击
                 * 模拟滑动
                 */
                try {
                    ShellUtil.startActivity(Constant.DongFang.ACTIVITY_PACKAGE);
                    Thread.sleep(5 * 1000);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void showToastByRunnable(final Context context, final CharSequence text) {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
