/*
 * Class RandomAccessFileTest
 * Date 23.01.14
 * 읽고 쓰는것을 동시에 할 수 있는 RandomAccessFile 클래스 기초
 */

package javaplus.inandout;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public static void main(String[] args) throws IOException {

		String path = System.getProperty("user.dir") + "/javaplus/inandout/";
		
		RandomAccessFile rf = new RandomAccessFile(path + "Random.txt", "rw");
		rf.writeInt(100); //4바이트
		System.out.println(rf.getFilePointer());
		rf.writeDouble(3.14); //8
		System.out.println(rf.getFilePointer());
		rf.writeUTF("안녕하세요"); //3(한글자) * 5 + 2(null) = 17 
		System.out.println(rf.getFilePointer());
		
		//포인터 위치 0으로 옮김
		rf.seek(0);
		
		int i = rf.readInt();
		double d = rf.readDouble();
		String str = rf.readUTF();
		
		System.out.println(i);
		System.out.println(d);
		System.out.println(str);

	}

}
