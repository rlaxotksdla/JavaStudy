package javaplus.inandout;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {

	public static void main(String[] args) {
		String filePath = "C:/Users/user/git/JavaStudy/javaplus/inandout/InputStream.txt";
		
		//물론 애초에 FileReader를 사용하면 쉽게 문자를 가져올 수 있지만 바이트밖에 지원안하는 곳에서 데이터를 읽어올 때 필요함
		try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath))) {
			int i = 0;
			while( (i = isr.read()) != -1) {
				System.out.print((char)i);
			}
			
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
