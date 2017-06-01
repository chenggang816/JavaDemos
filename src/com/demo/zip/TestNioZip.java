package com.demo.zip;
import java.io.BufferedInputStream; 
import java.io.BufferedOutputStream; 
import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.nio.channels.Channels; 
import java.nio.channels.FileChannel; 
import java.nio.channels.ReadableByteChannel; 
import java.util.Enumeration; 
import java.util.zip.ZipEntry; 
import java.util.zip.ZipFile; 
import java.util.zip.ZipInputStream; 
public class TestNioZip {

	public static void extract(File zipFile,File destDir) throws Exception{ 
		ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile)); 
		ZipEntry zie; 

		while((zie = zis.getNextEntry()) != null){ 
			String entryName = zie.getName(); 
			File newFile = new File(destDir,entryName); 
			int count; 
			byte[] data = new byte[8192]; 
			if(zie.isDirectory()){ 
				newFile.mkdirs(); 
			}else{ 
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFile)); 
				while((count = zis.read(data)) != -1){ 
					bos.write(data,0,count); 
				} 
				bos.flush(); 
				bos.close(); 
			} 
		} 
		zis.close(); 
	} 
	public static void extractBuf(File zipFile, File destDir) throws Exception { 

		BufferedInputStream bi = new BufferedInputStream(new FileInputStream(zipFile)); 
		ZipInputStream zis = new ZipInputStream(bi); 
		ZipEntry zie; 
		int BUFFER_SIZE = 8192; 

		while ((zie = zis.getNextEntry()) != null) { 
			String entryName = zie.getName(); 
			// System.out.println("Extracting: " + zipentry.getName()); 
			File newFile = new File(destDir , entryName); 
			byte[] data = new byte[BUFFER_SIZE]; 
			int count; 
			if (zie.isDirectory()) { 
				newFile.mkdirs(); 
			} else { 
				FileOutputStream fos = new FileOutputStream(newFile); 
				BufferedOutputStream bos = new BufferedOutputStream(fos,BUFFER_SIZE); 
				while((count = zis.read(data,0,BUFFER_SIZE)) != -1){ 
					bos.write(data,0,count); 
				} 
				bos.flush(); 
				bos.close(); 
			} 
		} 

		zis.close(); 
	} 
	public static void extractNIO(File zipFile,File destDir)throws Exception{ 
		BufferedInputStream bi = new BufferedInputStream(new FileInputStream(zipFile)); 
		ZipInputStream zin = new ZipInputStream(bi); 
		ZipEntry zie; 
		ReadableByteChannel rc = Channels.newChannel(zin); 

		while((zie = zin.getNextEntry()) != null){ 
			String entryName = zie.getName(); 
			File newFile = new File(destDir,entryName); 
			if(zie.isDirectory()){ 
				newFile.mkdirs(); 
			}else{ 
				FileOutputStream fos = new FileOutputStream(newFile); 
				FileChannel fc = fos.getChannel(); 

				long count = 0; 
				long size = zie.getSize(); 
				// while(count // long written = fc.transferFrom(rc, count, size); 
				// count += written; 
				// } 
				fc.transferFrom(rc,0,zie.getSize()); 
				fos.close(); 
			} 
		} 
		zin.close(); 
	} 
	public static void extractNIOzf(File zipFile,File destDir) throws Exception{ 
		ZipFile zf = new ZipFile(zipFile); 
		ZipEntry zie = null; 
		Enumeration et = zf.entries(); 

		while(et.hasMoreElements()){ 
			zie = (ZipEntry)et.nextElement(); 
			File newFile = new File(destDir,zie.getName()); 
			ReadableByteChannel rc = Channels.newChannel(zf.getInputStream(zie)); 
			if(zie.isDirectory()){ 
				newFile.mkdirs(); 
			}else{ 
				FileOutputStream fos = new FileOutputStream(newFile); 
				FileChannel fc = fos.getChannel(); 
				fc.transferFrom(rc, 0, zie.getSize()); 
				fos.close(); 
			} 

		} 
		zf.close(); 
	} 

	

	
//	static abstract class Test{
//		String name;
//		public void run(){
//			try { 
//				long avg = 0; 
//				for(int i=0;i<10;i++){ 
//					long st = System.nanoTime(); 
//						testMethod();
//					long time = System.nanoTime()-st; 
////					System.out.println(time); 
//					avg += time; 
//				} 
//				System.out.println(this.name + "\t|\tavg time:" + avg/10/1000/1000 ); 
//			} catch (Exception e) { 
//				e.printStackTrace(); 
//			} 
//		}
//		abstract void testMethod();
//	}
//	
	public static void main(String[] args){ 
		final File fs = new File("test.zip"); 
		final File dest = new File(""); 
		new TestTemplate() {
			@Override
			public void testMethod() {
				try {
					extract(fs, dest);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.run(3,"extract");
		new TestTemplate() {
			@Override
			public void testMethod() {
				try {
					extractBuf(fs, dest);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.run(3,"extractBuf");
		new TestTemplate() {
			@Override
			public void testMethod() {
				try {
					extractNIO(fs, dest);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.run(3,"extractNIO");
		new TestTemplate() {
			@Override
			public void testMethod() {
				try {
					extractNIOzf(fs, dest);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.run(3,"extractNIOzf");
	} 
}
