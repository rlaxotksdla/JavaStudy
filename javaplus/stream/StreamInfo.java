/*
 * Class StreamInfo
 * Date 23.01.10
 */

package javaplus.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamInfo {

	public static void main(String[] args) {
		
		
		//기본 배열 Stream
		String[] arr = {"1", "2", "3", "4", "5"};
		Stream<String> stream = Arrays.stream(arr);
		stream = Arrays.stream(arr, 0, 2); // arr배열의 0~1 인덱스 요소
		
			
		List<String> list1 = Arrays.asList("사람", "고양이", "강아지", "물고기", "공룡");
		Stream<String> stream1 = list1.stream();
		
		//메소드 참조와 람다식_ Stream은 일회용
		//stream.forEach(StreamInfo :: print);
		stream1.forEach( s -> print(s));
		
		//Stream으로 숫자 모아서 평균 내기
		List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6 ,7 ,8 , 9, 10);
		Stream<Integer> stream2 = list2.stream();
		double avg = stream2.mapToInt(num -> num).average().getAsDouble();
		System.out.println(avg);
		
		
		//class 활용
		List<Person> list3 = new ArrayList<>();
		list3.add(new Person("김태산", 31));
		list3.add(new Person("김영광", 31));
		list3.add(new Person("장성태", 31));
		list3.add(new Person("김아이셰", 31));
		list3.add(new Person("양종석", 52));
		list3.add(new Person("조랑이", 19));
		Stream<Person> stream3 = list3.stream();
		avg = stream3.mapToInt(Person :: getAge).average().getAsDouble();
		System.out.println(avg);
		stream3 = list3.stream();
		stream3.forEach(t -> System.out.println(t.getName()));
		
		//reduce 메소드 사용
		stream2 = list2.stream();
		
		//초기값 주면 값을 반환
		double result1 = stream2.reduce(0, (x, y) -> x + y).doubleValue();
		System.out.println(result1);
		stream2 = list2.stream();
		//초기값 주지 않는 메소드는 Optional 객체로 반환
		Optional<Integer> result2 = stream2.reduce((x, y) -> x + y);
		//get 메소드를 통해 값 출력
		System.out.println(result2.get().doubleValue());
		
		
	}
	
	public static void print(String str) {
		System.out.println("무엇인가? : " + str);
	}

}

class Person{
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {return this.name;}
	public int getAge() {return this.age;}
}