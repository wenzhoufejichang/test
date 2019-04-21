package com.hzm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileSplit {
	public static void main(String[] args) {

		try (FileInputStream f = new FileInputStream("E:\\音乐\\Alan Walker - Fade.flac");) {
			byte[] b = new byte[1024 * 1024];
			FileOutputStream fo = null;
			int index = 0;
			int name = 1;
			while ((index = f.read(b)) != -1) {

				File part = new File(new File("E:\\新建文件夹"), name++ + ".part");
				fo = new FileOutputStream(part);
				fo.write(b, 0, index);
				fo.flush();
				fo.close();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
