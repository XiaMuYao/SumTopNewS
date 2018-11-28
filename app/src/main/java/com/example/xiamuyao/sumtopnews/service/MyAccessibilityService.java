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
import com.stericson.RootTools.RootTools;
import com.stericson.RootTools.RootToolsException;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

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
    private String getACtivity = "dumpsys activity | findstr mFocusedActivity";

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
    @SuppressLint("NewApi")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Log.e(TAG, "EventData ----> " + event);
        switch (event.getEventType()) {
            //界面ui的改变(跳转页面)
            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
                LL.e("当前Activity" + event.getPackageName() + "\n" + event.getClassName());
                String s = event.getClassName().toString();
                LL.e("shaomiao:" + s);
                try {
                    switch (s) {
                        // 东方头条主页
                        case XConstant.DONGFANG://  region description
                            LL.e("进入了主页");
                            String[] strings = new String[2];
                            strings[0] = "su";
                            strings[1] = "uiautomator dump /sdcard/dump.xml";
                            List<String> list = RootTools.sendShell(strings, 0, 5000);
                            LL.e(list.get(0));
                            LL.e("hhhhhh");
//                            List<AccessibilityNodeInfo> nodesById = findNodesById(event, XConstantID.DONGFANGFLUSH);
//
//                            if (nodesById != null && nodesById.size() > 0) {
//                                nodesById.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
//                            }
//
//                            Thread.sleep(2000);
//
//                            List<AccessibilityNodeInfo> infos = findNodesById(event, XConstantID.DONGFANGMAINITEM);
//                            if (infos != null && infos.size() > 0) {
//                                infos.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
//                            }
                            break;
                        // endregion description
                        //东方头条详情页
                        case XConstant.DONGFANGINFO://  region description
                            Thread.sleep(2000);
                            inputSehll(100, 1000, 100, 0, 16000);
                            //返回
                            performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK);
                            break;// endregion description
                        //东方头条详情页推送
                        case XConstant.DONGFANGPUSHDIALOG://  region description
                            List<AccessibilityNodeInfo> infods = findNodesById(event, XConstantID.DONGFANGPUSHDIALOGCANCLD);
                            if (infods != null && infods.size() > 0) {
                                infods.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
                                //返回
                                performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK);
                            }
                            break;// endregion description

                        case XConstant.ZHONGQINGALERT: //中青首页
                            //region description
                            List<AccessibilityNodeInfo> zhognqing_nodesById = findNodesById(event, XConstantID.ZHONGQING_id);
//                            performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK);
//                            if (zhognqing_nodesById != null && zhognqing_nodesById.size() > 0) {
//                                zhognqing_nodesById.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
//                            }
                            Thread.sleep(2000);
//                            List<AccessibilityNodeInfo> zhognqing_infos = findNodesById(event,XConstantID.ZHONGQING_REFRESH);
//                            if (zhognqing_infos !=null&& zhognqing_infos.size()>0){
//                                zhognqing_infos.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
//                            }
//                            Thread.sleep(5000);
                            List<AccessibilityNodeInfo> zhongqing_items = findNodesById(event, XConstantID.ZHONGNQING_ITEM);

                            if (zhongqing_items != null && zhongqing_items.size() > 0) {
                                LL.e("当前Activity" + zhongqing_items.get(0).getViewIdResourceName());
                                zhongqing_items.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
                            }
                            break;
                        // endregion description
                        case XConstant.ZHOGNQING_REDPACKET://中青红包页面
                            performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK);
                            break;
                        case XConstant.ZHONGQING_WEBVIEW:
                            // region description
                            Thread.sleep(2000);
                            inputSehll(100, 1000, 100, 0, 16000);
                            performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK);
                            // endregion description
                            break;
                        default:
                            break;
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (RootToolsException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
                break;

            default:
                break;
        }
    }

//       AccessibilityNodeInfo.ACTION_SCROLL_FORWARD 模拟滑动
//       AccessibilityService.performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK); 模拟返回按键
//       event.getSource().findAccessibilityNodeInfosByText("立即安装");

    @Override
    public void onInterrupt() {
        LL.d("无障碍服务被中断了。");
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
     * @param startX 开始X坐标
     * @param startY 开始Y坐标
     * @param endX   结束X坐标
     * @param endY   结束Y坐标
     */
    public String inputSehll(int startX, int startY, int endX, int endY, int time) {
        return RootCmd.execRootCmd("input swipe " + startX + " " + startY + " " + endX + " " + endY + " " + time);
    }

}
