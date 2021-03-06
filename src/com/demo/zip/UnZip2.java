package com.demo.zip;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class UnZip2 {
	static final int BUFFER = 2048;
	public static void main (String argv[]) {
		new TestTemplate() {

			@Override
			public void testMethod() {
				test();
			}
		}.run(3,"test");
	}

	private static void test(){
		try {
			BufferedOutputStream dest = null;
			BufferedInputStream is = null;
			ZipEntry entry;
			ZipFile zipfile = new ZipFile(Constants.ZIP_FILE);
			Enumeration e = zipfile.entries();
			while(e.hasMoreElements()) {
				entry = (ZipEntry) e.nextElement();
//				System.out.println("Extracting: " +entry);
				is = new BufferedInputStream
						(zipfile.getInputStream(entry));
				int count;
				byte data[] = new byte[BUFFER];
				FileOutputStream fos = new 
						FileOutputStream(entry.getName());
				dest = new 
						BufferedOutputStream(fos, BUFFER);
				while ((count = is.read(data, 0, BUFFER)) 
						!= -1) {
					dest.write(data, 0, count);
				}
				dest.flush();
				dest.close();
				is.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
