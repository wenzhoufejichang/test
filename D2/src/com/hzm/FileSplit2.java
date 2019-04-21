package com.hzm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileSplit2 {
	public static void main(String[] args) {
		FileOutputStream fos=null;
		try {
			File f = new File("E:\\新建文件夹");

			File[] ff = f.listFiles();
			 fos = new FileOutputStream("E:\\Alan Walker - Fade.flac", true);
			byte[] b = new byte[1024];
			int number = 0;
			for (File file : ff) {
				FileInputStream fis = new FileInputStream(file);
				while ((number = fis.read(b)) > 0) {
					fos.write(b, 0, number);
					fos.flush();
				}
				fis.close();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

	}
}
