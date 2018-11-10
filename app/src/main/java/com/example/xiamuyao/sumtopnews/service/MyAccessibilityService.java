package com.example.xiamuyao.sumtopnews.service;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;

import com.example.xiamuyao.sumtopnews.App;
import com.example.xiamuyao.sumtopnews.util.LL;
import com.example.xiamuyao.sumtopnews.util.RootCmd;
import com.example.xiamuyao.sumtopnews.util.ShellUtil;

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
                List<AccessibilityNodeInfo> infos = findNodesById(event, "com.songheng.eastnews:id/od");
                try {
                    if (infos != null && infos.size() > 0) {
                        Thread.sleep(2000);
                        infos.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
                        Thread.sleep(1000);
                        //模拟两次下滑
                        for (int i = 0; i < 2; i++) {
                            inputSehll(100, 500, 100, -2000, 3000);
                        }

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;

            default:
                break;
        }
    }

    @Override
    public void onInterrupt() {

    }

    @SuppressLint("NewApi")
    public List<AccessibilityNodeInfo> findNodesById(AccessibilityEvent event, String viewId) {
        AccessibilityNodeInfo nodeInfo = event.getSource();
        if (nodeInfo != null) {
            return nodeInfo.findAccessibilityNodeInfosByViewId(viewId);
        }
        return null;
    }

    /**
     * 移动点击屏幕
     *
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     */
    public void inputSehll(int startX, int startY, int endX, int endY, int time) {
        /*input swipe 100 500 100 -2000 1000*/
        RootCmd.execRootCmd("input swipe " + startX + " " + startY + " " + endX + " " + endY + " " + time);
    }

}
