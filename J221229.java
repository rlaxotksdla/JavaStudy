import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class J221229 {

	 // 백준 1316번 풀이 - 어려워서 결국 검색해서 아이디어 보고 코딩함
	/*그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 
	 * 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, 
	 * aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
	 * 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
	 * 입력 예제
	 * 3
	 * happy
	 * new
	 * year
	 */
	public static void main(String[] args) throws IOException {
	    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());//3을 받아옴
        int count = 0;
        for (int i = 0; i < n; i++) {// 3번 반복
        	count = check(br, count);
        }
        bw.write(count+"\n");
        bw.flush();
        bw.close();
        
	}

	public static int check(BufferedReader br, int count) throws IOException {
		boolean result = true;
		boolean[] checker = new boolean[26];// boolean 배열에 각 소문자 알파벳 26자와 비교한 결과 저장예정 초기 false값으로 저장되어있음
		String str = br.readLine();
		int pre = 0;
		for (int j = 0; j < str.length(); j++) {
			int now = str.charAt(j);
			if (pre != now) { //이전 char랑 같은 아스키 코드값인지 확인하고 아니라면
				if (checker[now - 'a']) {
					result = false; 
					break; //prev가 현재 값이랑 다른데 check 배열내 해당 아스키코드-'a' 인덱스 위치가 이미 true라면 이미 나온 알파벳이므로 더이상 비교하지 않고 false를 반환함
				} else {
					checker[now - 'a'] = true; // check 배열 내  index 0번이 소문자 a로 설정한것이므로 현재 아스키코드값에 'a'뺀 곳이 false라면 (이전에 나오지 않았다면)//이제 처음 나온 알파벳이므로 true로 바꿔줌
					pre = now; //다음 비교를 위해 현재 아스키코드 값을 prev에 넣어줌
				}
			}
			
		}
		if (result) {
			count++; // 해당 문자열이 그룹 문자인지 확인하고 맞다면 count++함
		}
		return count;
	}
	
	

}
