/*
 * Class ArrayListPlus
 * Date 23.01.04
 */

package javaPlus.collection.list.arrayList;

import java.lang.reflect.Field;
import java.util.*;

public class ArrayListPlus{
	
	public static void main(String[] args) throws Exception {
		/*
		제네릭을 쓰지 않고 인스턴스 생성이 가능하지만 그럴 경우 값이 저장될때 object 형으로 저장되기 때문에
		값을 빼내어 할당할때 형변환을 시켜야하기에 제네릭을 쓰는것이 권장된다.
		 */
		ArrayList arrayList1 = new ArrayList();
		ArrayList<String> arrayList2 = new ArrayList<String>();
		arrayList1.add("A");
		arrayList2.add("A");

		arrayList1.add(null); //일반 배열과 달리 null 값도 추가 가능;

		// 값을 호출할 때에는 get 메소드 사용
		String str1 = (String) arrayList1.get(0);
		String str2 = arrayList2.get(0);
		
		//초기 값 할당 가능
		ArrayList<String> arrayList3 = new ArrayList<String>(Arrays.asList("A", "B", "C"));
		ArrayList<String> arrayList4 = new ArrayList<String>(List.of("A", "B", "C"));

		//String.join("구분자", 배열_[일반 배열도 가능])을 통해 각 값 사이에 구분자를 넣은 문자열을 얻을 수 있다.
		System.out.println(String.join(",", arrayList3));

		ArrayList<Integer> arrayList5 = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
		// sort 메소드를 정렬 가능하고 오버라이딩 메소드를 통해 그 외 정렬 방법을 생성해서 사용가능하다.
		arrayList5.sort(Comparator.naturalOrder()); //오름차순
		System.out.println(arrayList5);
		arrayList5.sort(Comparator.reverseOrder()); //내림차순
		System.out.println(arrayList5);

		// remove 종류의 메소드를 통해 값 제거 가능 제거 후에 해당 인덱스 뒷부분이 앞으로 한칸씩 당겨짐
		arrayList5.remove(0); //인덱스 값
		arrayList5.remove(Integer.valueOf(1)); //int 배열에서 해당 값을 제거하고 싶을 때
		arrayList5.removeIf(n -> (n > 3)); //람다식을 통해 조건을 줘서 제거할 때
		System.out.println(arrayList5);

		arrayList5.add(null);
		System.out.println(arrayList5);


	}
	
}
