/*
 * Class FileInputStreamTest
 * Date 23.01.13
 */

package javaplus.inandout;

import java.io.FileInputStream;

public class FileInputStreamTest {

	public static void main(String[] args) {
		
		//FileInputStream 바이트로 읽어옴
		try (FileInputStream fis = new FileInputStream("C:/Users/user/git/JavaStudy/javaplus/inandout/FileInput.txt")){
			int i = 0;
			
			//파일 끝에 도달하면 -1 반환함
			while((i = fis.read()) != -1) {
				System.out.print((char)i);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		//특정 바이트 수 단위로 읽는 법
		try (FileInputStream fis = new FileInputStream("C:/Users/user/git/JavaStudy/javaplus/inandout/FileInput.txt")){
			int j = 0;
			byte[] bs = new byte[10];
			
			//파일 끝에 도달하면 -1 반환함
			while((j = fis.read(bs)) != -1) {
				
				for (int m = 0; m < j; m++) {
					System.out.print((char)bs[m]);
				}
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
