/*
 * Class FileCopyTest
 * Date 23.01.14
 * FileInputStream으로 읽고 FileOutputStream으로 쓰면 한바이트씩 해서 느린데
 * BufferedInputStream, BufferedOutputStream을 활용하면 훨씬 빠르게 읽고 쓸수 있다. 
 */

package javaplus.inandout;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopyTest {

	public static void main(String[] args) {
		
		String path = System.getProperty("user.dir") + "/javaplus/inandout/";
		
		long milliseconds = 0;
		
		try( FileInputStream fis = new FileInputStream(path + "Original.txt");
				FileOutputStream fos = new FileOutputStream(path + "CopyOfOriginal.txt");
				BufferedInputStream bis = new BufferedInputStream(fis);
				BufferedOutputStream bos = new BufferedOutputStream(fos);) {
			
			milliseconds = System.currentTimeMillis();
			int i;
			while((i = bis.read()) != -1) {
				bos.write(i);
			}
			byte[] copiedText = "\n이 파일은 원본이 아닙니다.".getBytes("utf-8");
			bos.write(copiedText);
			milliseconds = System.currentTimeMillis() - milliseconds;
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("걸린 시간 : " + milliseconds + " milliseconds");
	}

}
