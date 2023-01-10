/*
 * Class QueueInfo
 * Date 23.01.10
 * FIFO 자료구조인 Queue 인터페이스 기초 - 스레드풀에 활용됨
 */

package javaplus.lifoandfifo;

import java.util.LinkedList;
import java.util.Queue;

public class QueueInfo {

	public static void main(String[] args) {
		
		//Queue인터페이스가 구현되어있는 LinkedList로 생성함
		Queue<Integer> queue = new LinkedList<Integer>();
		
		//값 추가
		for (int i = 1; i <= 5; i++) {
			queue.offer(i);			
		}
		
		//제거하지않고 처음 추가한 값 리턴
		System.out.println(queue.peek());
		
		//값 제거하면서 추가한 순서대로 리턴
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}

	}

}
