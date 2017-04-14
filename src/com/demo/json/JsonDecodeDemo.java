package com.demo.json;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;

import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonDecodeDemo {
	public static void main(String[] args)
	{
		JSONParser parser=new JSONParser();
		String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
		try{
			Object obj = parser.parse(s);
			JSONArray array = (JSONArray)obj;
			System.out.println("The 2nd element of array");
			System.out.println(array.get(1));
			System.out.println();
			JSONObject obj2 = (JSONObject)array.get(1);
			System.out.println("Field \"1\"");
			System.out.println(obj2.get("1"));

			s = "{}";
			obj = parser.parse(s);
			System.out.println(obj);

			s= "[5,]";
			obj = parser.parse(s);
			System.out.println(obj);

			s= "[5,,2]";
			obj = parser.parse(s);
			System.out.println(obj);
		}catch(ParseException pe){
			System.out.println("position: " + pe.getPosition());
			System.out.println(pe);
		}
		InputStreamReader isr;
		try {
			isr = new InputStreamReader(new FileInputStream("sites.json"),"UTF8");
			int c;
			StringWriter sw = new StringWriter();
			while((c = isr.read()) != -1){
				sw.write(c);
			}
			String s1 = sw.toString();
			System.out.println(s1);
			JSONObject jsonObj = (JSONObject) parser.parse(s1);
			JSONArray jsonArray = (JSONArray)jsonObj.get("sites");
			for(Object o:jsonArray){
				JSONObject item = (JSONObject)o;
				System.out.println("name:\t" + item.get("name"));
				System.out.println("url:\t" + item.get("url"));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}catch (ParseException pe) {
			System.out.println("position: " + pe.getPosition());
			pe.printStackTrace();
		}
		
		
	}
}
