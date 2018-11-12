package com.example.xiamuyao.sumtopnews.util;

import com.example.xiamuyao.sumtopnews.constant.XConstant;

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/11/12
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class PageUtil {
    public static int PageType(String className) {
        switch (className) {
            case XConstant.DONGFANGINFO:
                return XConstant.PAGETYPE = 0;
            default:
                return 0;
        }
    }
}
