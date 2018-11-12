package com.example.xiamuyao.sumtopnews.service;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import com.example.xiamuyao.sumtopnews.constant.XConstant;
import com.example.xiamuyao.sumtopnews.constant.XConstantID;
import com.example.xiamuyao.sumtopnews.util.LL;
import com.example.xiamuyao.sumtopnews.util.RootCmd;

import java.util.List;

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/11/6
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class MyAccessibilityService extends AccessibilityService {
    public static final String TAG = "MyAccessibilityService";

// 获得Activity adb shell dumpsys activity | findstr "mFocusedActivity"
// 移动屏幕      adb shell input swipe 100 500 100 -2000 3000

    private String ex1Input = "input swipe 100 500 100 -2000 1000";
    private String getACtivity = "dumpsys activity | findstr \"mFocusedActivity\"";

    public MyAccessibilityService() {

    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
    }

    /**
     * 任何界面的改变 都可以在这里知道 通过event来区分 然后识别 模拟
     * 这个也是咱们操作最多方法了
     *
     * @param event
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Log.d(TAG, "EventData ----> " + event);
        switch (event.getEventType()) {
            //界面ui的改变(跳转页面)
            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
                LL.d("当前Activity" + event.getPackageName() + "\n" + event.getClassName());
                String s = event.getClassName().toString();
                try {
                    switch (s) {
                        // 东方头条主页
                        case XConstant.DONGFANG:
                            List<AccessibilityNodeInfo> nodesById = findNodesById(event, "com.songheng.eastnews:id/jo");

                            if (nodesById != null && nodesById.size() > 0) {
                                nodesById.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
                            }

                            Thread.sleep(2000);

                            List<AccessibilityNodeInfo> infos = findNodesById(event, XConstantID.DONGFANGMAINITEM);
                            if (infos != null && infos.size() > 0) {
                                infos.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
                            }
                            break;
                        //东方头条详情页
                        case XConstant.DONGFANGINFO:
                            Thread.sleep(2000);
                            inputSehll(100, 500, 100, 0, 8000);
                            Thread.sleep(3000);
                            inputSehll(100, 500, 100, 0, 8000);
                            //返回
                            performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK);
                            break;
                        //东方头条详情页推送
                        case XConstant.DONGFANGPUSHDIALOG:
                            List<AccessibilityNodeInfo> infods = findNodesById(event, XConstantID.DONGFANGPUSHDIALOGCANCLD);
                            if (infods != null && infods.size() > 0) {
                                infods.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
                                //返回
                                performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK);
                            }
                            break;
                        default:
                            break;
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                int i1 = PageUtil.PageType(event.getClassName().toString());

                //如果是东方头条首页
//                List<AccessibilityNodeInfo> infos = findNodesById(event, "com.songheng.eastnews:id/od");
                //检测主页成功
                //等待2秒
                //点击进入
                //等待3秒
                //模拟下滑一次
                //等待3秒
                //模拟下滑一次
                //检测一下查看全文的位置 并点击
                //等待3秒
                //模拟下滑一次
                //等待3秒
                //模拟下滑一次
                //等待3秒
                //模拟下滑一次
                //模拟back按键
//                try {
//                    if (infos != null && infos.size() > 0) {
//                        Thread.sleep(2000);
//                        infos.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
//                        Thread.sleep(2000);
//                        List<AccessibilityNodeInfo> nodesById = findNodesById(event, "com.songheng.eastnews:id/ks");
////                        nodesById.get(0).performAction(AccessibilityNodeInfo.ACTION_SCROLL_FORWARD);
////                        inputSehll(100, 500, 100, -500, 3000);
////                        List<AccessibilityNodeInfo> lookAll = event.getSource().findAccessibilityNodeInfosByText("点击查看全文");
////                        lookAll.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
//
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                break;

            default:
                break;
        }
    }

    //    AccessibilityNodeInfo.ACTION_SCROLL_FORWARD 模拟滑动
//    AccessibilityService.performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK); 模拟返回按键
    @Override
    public void onInterrupt() {

    }

    //event.getSource().findAccessibilityNodeInfosByText("立即安装");
    @SuppressLint("NewApi")
    public List<AccessibilityNodeInfo> findNodesById(AccessibilityEvent event, String viewId) {
        AccessibilityNodeInfo nodeInfo = event.getSource();
        if (nodeInfo != null) {
            return nodeInfo.findAccessibilityNodeInfosByViewId(viewId);
        }
        return null;
    }

//    inputSehll(100, 500, 100, -2000, 3000);

    /**
     * 移动点击屏幕
     *
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     */
    public String inputSehll(int startX, int startY, int endX, int endY, int time) {
        /*input swipe 100 500 100 -2000 1000*/
        String s = RootCmd.execRootCmd("input swipe " + startX + " " + startY + " " + endX + " " + endY + " " + time);
        return s;

    }

}
