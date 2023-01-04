package JavaBasic;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Person{
	int age;
	String name;
	
	Person(int age, String name){
		this.age = age;
		this.name = name;
	}
}

public class J230102_2 {
//백준 10814 문제 풀면서 Arrays.sort() 메소드와 오버라이드한 compare()를 이용한 문제풀이 정리
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		Person[] person = new Person[N];
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			person[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		
		Arrays.sort(person, new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {  //완벽히 이해하진 못했지만 사용법은 알게됨
				return p1.age - p2.age;
			}
			
		});
		
		
		
		for (int j = 0; j < N; j++) {
				sb.append(person[j].age + " " + person[j].name + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
