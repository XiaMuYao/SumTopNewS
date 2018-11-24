package com.example.xiamuyao.sumtopnews.util;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * created by tea9 at 2018/11/24
 */
public class DOMTest {
    public static void main(String[] args) {

        Map<String, Integer> coordinateWithResourceId = getCoordinateWithResourceId("cn.com.spdb.mobilebank.per:id/tv_login_register_acc","/Users/shaomiao/Desktop/uidump.xml");
        System.out.println(coordinateWithResourceId);

    }

    /**
     * 根据资源id获取坐标
     */
    public static Map<String, Integer> getCoordinateWithResourceId(String resourceID, String url) {
        Map<String, Integer> childCoordnate = new HashMap<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
//            Document document = db.parse("E:\\uidump.xml");
            File file = new File(url);
            Document document = db.parse(file);
            NodeList node = document.getElementsByTagName("node");
            int bookCnt = node.getLength();
            System.out.println("获取了" + bookCnt + "节点");
            for (int i = 0; i < bookCnt; i++) {
                Node book = node.item(i);
                NamedNodeMap attrs = book.getAttributes();
                for (int j = 0; j < attrs.getLength(); j++) {
                    Node attr = attrs.item(j);
                    if ("bounds".equals(attr.getNodeName())) {
                        childCoordnate = getChildCoordnate(attr.getNodeValue());
                    }
                    if (resourceID.equals(attr.getNodeValue())) {
                        return childCoordnate;
                    }
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
        x2 = Integer.parseInt(nodeValue.substring(nodeValue.indexOf(",") + 1, nodeValue.indexOf("]")));

        y1 = Integer.parseInt(nodeValue.substring(nodeValue.indexOf("]") + 2, nodeValue.lastIndexOf(",")));
        y2 = Integer.parseInt(nodeValue.substring(nodeValue.lastIndexOf(",") + 1, nodeValue.lastIndexOf("]")));
        map.put("x1", x1);
        map.put("x2", x2);
        map.put("y1", y1);
        map.put("y2", y2);

        return map;
    }
}
