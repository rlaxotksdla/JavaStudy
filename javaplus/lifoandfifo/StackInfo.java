/*
 * Class StackInfo
 * Date 23.01.10
 * LIFO 자료구조인 Stack 클래스 기초
 */

package javaplus.lifoandfifo;

import java.util.Stack;

public class StackInfo {

	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		//값 추가
		for (int i = 1; i <= 5; i++) {
			stack.push(i);
		}
		
		//값을 제거하지않고 마지막 push값 return
		System.out.println(stack.peek());
		
		//값을 제거하면서 마지막 push값 return
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
