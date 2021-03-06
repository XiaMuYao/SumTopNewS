package com.example.xiamuyao.sumtopnews.util;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/11/24
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class DOMTest {
    public static void main(String[] args) {

        Map<String, Integer> coordinateWithResourceId = getCoordinateWithText("确认转账", "E:\\miao.xml");

//        Map<String, Integer> coordinateWithResourceId = getCoordinateWithText("1");

        System.out.println(coordinateWithResourceId);

    }

    /**
     * 根据资源id获取坐标
     */
    public static Map<String, Integer> getCoordinateWithResourceId(String resourceID, String fileUrl) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            File file = new File(fileUrl);
            Document document = db.parse(file);
            NodeList node = document.getElementsByTagName("node");
            int bookCnt = node.getLength();
            for (int i = 0; i < bookCnt; i++) {
                Node book = node.item(i);
                NamedNodeMap attrs = book.getAttributes();
                if (attrs.getNamedItem("resource-id").getNodeValue().equals(resourceID)) {
                    return getChildCoordnate(attrs.getNamedItem("bounds").getNodeValue());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据资源id获取坐标 返回集合List
     */
    public static Map<String, Map<String, Integer>> getCoordinateListWithResourceId(String resourceID, String fileUrl, List<String> shieldStr) {
        int index = 0;
        Map<String, Map<String, Integer>> childCoordnate = new HashMap<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();

            File file = new File(fileUrl);
            Document document = db.parse(file);
            NodeList node = document.getElementsByTagName("node");
            int bookCnt = node.getLength();

            for (int i = 0; i < bookCnt; i++) {
                Node book = node.item(i);
                NamedNodeMap attrs = book.getAttributes();
                if (attrs.getNamedItem("resource-id").getNodeValue().equals(resourceID)) {
                    Node item = node.item(i + 3);
                    NamedNodeMap attributes = item.getAttributes();
                    for (String s : shieldStr) {
                        if (!attributes.getNamedItem("text").getNodeValue().equals(s)) {
                            childCoordnate.put(index + "", getChildCoordnate(attrs.getNamedItem("bounds").getNodeValue()));
                            index++;
                        }
                    }

                }
            }

            return childCoordnate;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Integer> getCoordinateWithText(String text, String fileUrl) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder db = dbf.newDocumentBuilder();
            File file = new File(fileUrl);
            Document document = db.parse(file);
            NodeList node = document.getElementsByTagName("node");
            int bookCnt = node.getLength();

            for (int i = 0; i < bookCnt; i++) {
                Node book = node.item(i);
                NamedNodeMap attrs = book.getAttributes();
                if (attrs.getNamedItem("text").getNodeValue().equals(text)) {
                    return getChildCoordnate(attrs.getNamedItem("bounds").getNodeValue());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据坐标字符串获取精确坐标
     *
     * @param nodeValue
     * @return
     */
    private static Map<String, Integer> getChildCoordnate(String nodeValue) {
        Map<String, Integer> map = new HashMap<>();
        int x1, x2, y1, y2;

        x1 = Integer.parseInt(nodeValue.substring(1, nodeValue.indexOf(",")));
        y1 = Integer.parseInt(nodeValue.substring(nodeValue.indexOf(",") + 1, nodeValue.indexOf("]")));

        x2 = Integer.parseInt(nodeValue.substring(nodeValue.indexOf("]") + 2, nodeValue.lastIndexOf(",")));
        y2 = Integer.parseInt(nodeValue.substring(nodeValue.lastIndexOf(",") + 1, nodeValue.lastIndexOf("]")));

        map.put("x1", x1);

        map.put("x2", x2);

        map.put("y1", y1);

        map.put("y2", y2);

        return map;
    }
}