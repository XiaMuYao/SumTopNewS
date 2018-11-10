package com.example.xiamuyao.sumtopnews.util;

import android.util.Log;

import com.example.xiamuyao.sumtopnews.BuildConfig;

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/11/10
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class LL {
    private static final boolean DEBUG = BuildConfig.DEBUG;
    /**
     * 类名
     */
    static String className;
    /**
     * 方法名
     */
    static String methodName;
    /**
     * 行数
     */
    static int lineNumber;

    private LL() {
    }


    private static String createLog(String log) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("方法名==>  ");
        buffer.append(methodName);
        buffer.append("  ClassName==>");
        buffer.append("(").append(className).append(":").append(lineNumber).append(")");
        buffer.append("  打印信息==>  ");
        buffer.append(log);
        return buffer.toString();
    }

    private static void getMethodNames(StackTraceElement[] sElements) {
        className = sElements[1].getFileName();
        methodName = sElements[1].getMethodName();
        lineNumber = sElements[1].getLineNumber();
    }


    public static void e(String message) {
        if (!DEBUG)
            return;

        // Throwable instance must be created before any methods
        getMethodNames(new Throwable().getStackTrace());
        Log.e(className, createLog(message));
    }


    public static void i(String message) {
        if (!DEBUG)
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.i(className, createLog(message));
    }

    public static void d(String message) {
        if (!DEBUG)
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.d(className, createLog(message));
    }

    public static void v(String message) {
        if (!DEBUG)
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.v(className, createLog(message));
    }

    public static void w(String message) {
        if (!DEBUG)
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.w(className, createLog(message));
    }

    public static void wtf(String message) {
        if (!DEBUG)
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.wtf(className, createLog(message));
    }

}