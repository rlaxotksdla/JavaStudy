package JavaBasic;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J221230 {

	
	
	/*
	 * 백준 1929 문제 
	 * 에라토스테네스의 체 이해하고 풀이까지 오래걸림 다시한번 복습을 위해 정리
	 */

		public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		boolean[] checked = new boolean[b+1];
		
		for (int i = 2; i <= b; i++) {
			if (checked[i]) continue;
			if (i >= a) sb.append(i + "\n");
			
			for (int j = i + i; j <= b ; j += i) {
				checked[j] = true;
			}
		}
		
	    System.out.println(sb);
		
	}
		
	   
	

}
