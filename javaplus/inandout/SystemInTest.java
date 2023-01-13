/*
 * Class SystemInTest
 * Date 23.01.13
 */

package javaplus.inandout;

import java.io.IOException;

public class SystemInTest {

	public static void main(String[] args) {
		
		//System.in 바이트 단위로 읽음
		System.out.println("알파벳을 여러개 쓰고 엔터를 누르세요");
		int i = 0;
		try {
			while((i = System.in.read()) !='\n') { //int 반환
				System.out.print((char)i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
