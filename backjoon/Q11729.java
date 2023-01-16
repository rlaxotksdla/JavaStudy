/*
 * Class Q11729
 * Date 23.01.16
 * 백준 11729번 - 하노이 탑 이동 순서 
 * 원판을 옮기는 함수를 move(N)이라 한다면 A에 원판 갯수 N개가 있다면 B를 거쳐 C 까지 옮기는 것을 공식화 하면
 * 가장 아래 원판을 제외하고 A -> B 옮기는 횟수는 (N - 1), 맨 아래판을 C로 옮기는 횟수 1, 다시 B에서 C로 옮기는 횟수 (N - 1) 
 * 따라서, * move(N) = 2 * move(N-1) + 1 이를 정리하여 n개의 원판을 옮긴 횟수를 k(n)이라 하고 
 * 일반항으로 표현하면 k(n) = 2^n - 1 가 된다
 * 
 */
package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11729 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int k = (int) (Math.pow(2, N) - 1 );
		sb.append(k + "\n");
		
		move(N, 1, 2, 3);
		System.out.println(sb);
		
		
	}
	
	static void move(int N, int a, int b, int c) {
		
		// 이동할 원반의 수가 1개라면
		if (N == 1) {
			sb.append(a + " " + c + "\n");
			return;
		}
		
		// A -> C로 옮길 때
		// N-1개를 A -> B로 이동
		move(N - 1, a, c, b);
		
		// 가장 아래 원판 1개를 A에서 C로 이동
		sb.append(a + " " + c + "\n");
		
		//N-1개를 B에서 C로 이동
		move(N - 1, b, a, c);
	}
}
