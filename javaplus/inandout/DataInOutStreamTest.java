/*
 * Class DataInOutStreamTest
 * Date 23.01.14
 */

package javaplus.inandout;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInOutStreamTest {

	public static void main(String[] args) {
		
		String path = System.getProperty("user.dir") + "/javaplus/inandout/";
		
		try( FileOutputStream fos = new FileOutputStream(path + "DataInOut.txt");
				DataOutputStream dos = new DataOutputStream(fos)){
			dos.writeInt(100);
			dos.writeInt(10);
			dos.writeChar('A');
			dos.writeUTF("안녕?");
		} catch (IOException e) {
			System.out.println(e);
		}
		
		//읽을 때 순서 맞춰서 읽어야함
		try( FileInputStream fis = new FileInputStream(path + "DataInOut.txt");
				DataInputStream dis = new DataInputStream(fis)) {
			System.out.println(dis.readInt());
			System.out.println(dis.readInt());
			System.out.println(dis.readChar());
			System.out.println(dis.readUTF());

		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
