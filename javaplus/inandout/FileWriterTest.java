/*
 * Class FileWriterTest
 * Date 23.01.13
 */

package javaplus.inandout;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public static void main(String[] args) {

		String path = System.getProperty("user.dir") + "/javaplus/inandout/";
		
	    try (FileWriter fw = new FileWriter(path + "FileWriter.txt")) {
			fw.write("A");
			char[] bcd = {'B', 'C', 'D'};
			fw.write(bcd);
			fw.write("타입별로 오버로딩메소드로 저장해주는 FileWriter");
			fw.write(bcd, 1, 2);
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
