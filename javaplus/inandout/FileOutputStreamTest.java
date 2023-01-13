/*
 * Class FileOutputStreamTest
 * Date 23.01.13
 */

package javaplus.inandout;

import java.io.FileOutputStream;

public class FileOutputStreamTest {

	public static void main(String[] args) {
		
		byte[] bs = new byte[26];
		for( int i = 65; i < 65 + bs.length; i++) {
			bs[i-65] = (byte) i;
		}
		
		//바이트 단위로 입력됨
		try (FileOutputStream fos = new FileOutputStream("C:/Users/user/git/JavaStudy/javaplus/inandout/FileOutput.txt")) {
			fos.write(bs);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("end");

	}

}
