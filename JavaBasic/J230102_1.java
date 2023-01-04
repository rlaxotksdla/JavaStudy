package JavaBasic;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class J230102_1 {
 // 백준 10989 문제 counting 정렬 배우면서 정리
	//카운팅 정렬은 정수의 범위가 비교적 적고 정렬해야하는 수가 많을때 속도를 줄일수있는 좋은 알고리즘이다.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		int[] counting = new int[10001]; // 수의 범위 + 1 만큼의 배열 선언
		int[] result = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		for (int j = 0; j < N; j++) {
			counting[nums[j]]++;  // 배열내 값을 인덱스로 참조하며 값이 나온 빈도수만큼 +1함
		}
		
		for (int k = 1; k < 10001; k++) {
			counting[k] += counting[k - 1];  // counting 배열의 값들을 전부 전 인덱스의 총합으로 변경
		}
		
		for (int m = N - 1; m >= 0; m--) {
			counting[nums[m]]--;             // 원래 배열의 마지막 값부터 하나씩 차감하면서 최종 배열에 반환
			result[counting[nums[m]]] = nums[m];
		}
		
		for (int o = 0; o < N; o ++) {
			bw.write(result[o] + "\n");
		}
	
		
		bw.flush();
		bw.close();
		
	}

}
