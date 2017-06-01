package com.demo.zip;

import java.io.*;
import java.nio.file.Files;
import java.util.zip.*;
public class Zip {
   static final int BUFFER = 2048;
   public static void main (String argv[]) {
      new TestTemplate() {
		@Override
		public void testMethod() {
			zipBuffer();
		}
	}.run(1,"zipBuffer");
   }
   
   private static void zipBuffer(){
	   try {
	         BufferedInputStream origin = null;
	         FileOutputStream dest = new 
	           FileOutputStream(Constants.RAWDAT_ZIP);
	         ZipOutputStream out = new ZipOutputStream(new 
	           BufferedOutputStream(dest));
	         //out.setMethod(ZipOutputStream.DEFLATED);
	         byte data[] = new byte[BUFFER];
	         // get a list of files from current directory
	         File f = new File(Constants.RAWDAT_DIR);
	         File files[] = f.listFiles();
	         for (int i=0; i < files.length; i++) {
	            System.out.println("Adding: "+files[i]);
	            FileInputStream fi = new 
	              FileInputStream(files[i]);
	            origin = new 
	              BufferedInputStream(fi, BUFFER);
	            ZipEntry entry = new ZipEntry(files[i].getName());
	            out.putNextEntry(entry);
	            int count;
	            while((count = origin.read(data, 0, 
	              BUFFER)) != -1) {
	               out.write(data, 0, count);
	            }
	            origin.close();
	         }
	         out.close();
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
   }
}
