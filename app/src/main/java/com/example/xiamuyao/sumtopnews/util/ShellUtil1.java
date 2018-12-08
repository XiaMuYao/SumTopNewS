package com.example.xiamuyao.sumtopnews.util;

import java.util.Map;

/**
 * created by tea9 at 2018/11/25
 */
public class ShellUtil1 {

    /**
     * 打开app
     * @param package_activity  com.songheng.eastnews/com.oa.eastfirst.activity.WelcomeActivity
     */
    public static void startActivity(String package_activity) {
        //com.songheng.eastnews/com.oa.eastfirst.activity.WelcomeActivity
        RootCmd.execRootCmdSilent("am start "+package_activity); // 打开app
    }

    /**
     * 生成文件
     * @param file_path 文件路径 /sdcard/dump.xml
     */
    public static void createXMLFile(String file_path) {
        RootCmd.execRootCmd("uiautomator dump " + file_path); // 生成文件
    }

    /**
     * 获取坐标系
     * @param res_id 资源id com.songheng.eastnews:id/a8e
     * @param file_path 文件路径 /sdcard/dump.xml
     * @return
     */
    public static Map<String, Integer> getCoordinate(String res_id,String file_path) {
        /**
         * int x1 = ddddd.get("x1");
         * int y1 = ddddd.get("x2");
         * **/
        return DOMTest.getCoordinateWithResourceId(res_id, file_path);
    }

    /**
     * 获取坐标然后点击
     * @param res_id
     * @param file_path
     */
    public static void getCoordinateAndClick(String res_id,String file_path){
        Map<String, Integer> zzz = DOMTest.getCoordinateWithResourceId(res_id, file_path);
        int x1 = zzz.get("x1");
        int y1 = zzz.get("x2");
        clickMethod(x1,y1);
    }

    /**
     * 点击事件
     * @param x
     * @param y
     */
    public static void clickMethod(int x,int y) {
        RootCmd.execRootCmd("input tap " + x + " " + y);
    }

    //RootCmd.execRootCmd("input swipe 100 1000 100 0  500 ");

    /**
     * 向下滑动
     */
    public static void swipeDownMethod() {
        RootCmd.execRootCmd("input swipe 100 1000 100 0  500");
    }

    /**
     * webview 向下滑动
     */
    public static void swipeByWebViewMethod() {
//        adb shell input keyevent 92 #向上翻页键

//        adb shell input keyevent 93 #向下翻页键
        RootCmd.execRootCmd("input keyevent 93 ");
        RootCmd.execRootCmd("input keyevent 93 ");
        RootCmd.execRootCmd("input keyevent 93 ");
        RootCmd.execRootCmd("input keyevent 93 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 19 ");
        RootCmd.execRootCmd("input keyevent 19 ");
        RootCmd.execRootCmd("input keyevent 19 ");
        RootCmd.execRootCmd("input keyevent 19 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 19 ");
        RootCmd.execRootCmd("input keyevent 19 ");
        RootCmd.execRootCmd("input keyevent 19 ");
        RootCmd.execRootCmd("input keyevent 19 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
    }

    public static void back() {
        RootCmd.execRootCmd("input keyevent 4");
    }

    public static void home() {
        RootCmd.execRootCmd("input keyevent 3");
        RootCmd.execRootCmd("input keyevent 3");
    }

    public static void clear() throws InterruptedException {
        RootCmd.execRootCmd("input tap 771 1852");
        Thread.sleep(2*1000);
        RootCmd.execRootCmd("input swipe 597 1758 597 1384");
    }


    public static boolean checkPage(String id) {
        createXMLFile(Constant.FILE_PATH);
        Map<String, Integer> map = getCoordinate(id,Constant.FILE_PATH);
        if (map != null) {
            return true;
        }
        return false;
    }

    public static void tapButton(String id) {
        Map<String, Integer> map = getCoordinate(id,Constant.FILE_PATH);
        if (map != null) {
            int zx1 = map.get("x1");
            int zy1 = map.get("x2");
            ShellUtil1.clickMethod(zx1,zy1);
        }
    }


    public static boolean checkHomeByDongfang() {
        createXMLFile(Constant.FILE_PATH);
        Map<String, Integer> map = getCoordinate(Constant.DongFang.RES_ID_BTN1,Constant.FILE_PATH);
        if (map != null) {
            return true;
        }
        return false;
    }

}
