/*
 * Class ScannerTest
 * Date 23.01.13
 */

package javaplus.inandout;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		
		//타입별로 읽어올 수 있음 게다가 읽은 값을 읽은 타입으로 반환해줌
		Scanner scanner = new Scanner(System.in);
		
		String name = scanner.nextLine();
		int num = scanner.nextInt();
		
		System.out.println(name);
		System.out.println(num);

	}

}
