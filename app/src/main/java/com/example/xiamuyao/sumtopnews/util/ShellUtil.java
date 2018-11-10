package com.example.xiamuyao.sumtopnews.util;

import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/11/10
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class ShellUtil {

    public static void execShellCmd(String cmd) {

        try {
            Process process = Runtime.getRuntime().exec("su");
            OutputStream outputStream = process.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeBytes(cmd);
            dataOutputStream.flush();
            dataOutputStream.close();
            outputStream.close();
            int i = process.waitFor();
            LL.d("0 是成功执行->"+i);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }


}
