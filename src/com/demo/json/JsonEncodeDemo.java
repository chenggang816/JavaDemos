package com.demo.json;
import java.io.IOException;
import java.io.StringWriter;

import org.json.simple.JSONObject;
/*
 * JSON 语法是 JavaScript 对象表示法语法的子集。
 * 数据在名称/值对中
 * 数据由逗号分隔
 * 大括号保存对象
 * 中括号保存数组
 *
   例：	{
		"sites": [
		{ "name":"菜鸟教程" , "url":"www.runoob.com" }, 
		{ "name":"google" , "url":"www.google.com" }, 
		{ "name":"微博" , "url":"www.weibo.com" }
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
