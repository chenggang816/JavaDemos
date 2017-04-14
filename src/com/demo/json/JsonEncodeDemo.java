package com.demo.json;
import java.io.IOException;
import java.io.StringWriter;

import org.json.simple.JSONObject;
/*
 * JSON �﷨�� JavaScript �����ʾ���﷨���Ӽ���
 * ����������/ֵ����
 * �����ɶ��ŷָ�
 * �����ű������
 * �����ű�������
 *
   ����	{
		"sites": [
		{ "name":"����̳�" , "url":"www.runoob.com" }, 
		{ "name":"google" , "url":"www.google.com" }, 
		{ "name":"΢��" , "url":"www.weibo.com" }
		]
	}
 * http://wiki.jikexueyuan.com/project/json/with-java.html
 */
public class JsonEncodeDemo {
	public static void main(String[] args) throws IOException{
		JSONObject obj = new JSONObject();
		obj.put("name", "foo");
        obj.put("num", new Integer(100));
        obj.put("balance", new Double(1000.21));
        obj.put("is_vip", new Boolean(true));

        StringWriter out = new StringWriter();
        obj.writeJSONString(out);
        String jsonText = out.toString();
        System.out.print(jsonText);
	}
}
