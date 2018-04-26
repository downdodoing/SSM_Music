package com.cn.hnust.util.getandsavepicture;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import sun.misc.BASE64Decoder;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

public class GetAndSavePicture {
	// 获取图片
	@SuppressWarnings("deprecation")
	public static String getPicture(String folder, String name) {
		File file = new File(folder + name + ".jpg");
		byte[] bs = new byte[1024];
		FileInputStream input = null;
		ByteOutputStream bos = new ByteOutputStream();
		int len = -1;
		try {
			input = new FileInputStream(file);
			while ((len = input.read(bs)) != -1) {
				bos.write(bs, 0, len);
			}
			bs = bos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return Base64.encode(bs);
	}

	// 保存图片
	public static void savePicture(String folder, String name, String photo) {
		BASE64Decoder decoder = new BASE64Decoder();
		FileOutputStream output = null;
		File file = new File(folder + name + ".jpg");
		try {

			byte[] bytes1 = decoder.decodeBuffer(photo);
			output = new FileOutputStream(file);

			for (int i = 0; i < bytes1.length; i++) {
				output.write(bytes1[i]);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				output.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
