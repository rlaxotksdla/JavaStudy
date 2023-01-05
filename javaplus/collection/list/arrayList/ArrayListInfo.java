/*
 * Class ArrayListInfo
 * Date 23.01.04
 */

package javaplus.collection.list.arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ArrayListInfo{
	
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
		
		// clone 을 통해 깊은 복사 가능
		ArrayList<Integer> arrayList6 = (ArrayList<Integer>) arrayList5.clone();

		arrayList6.add(5);
		arrayList6.add(4);
		arrayList6.add(3);
		arrayList6.add(2);
		arrayList6.add(1);
		arrayList6.add(100);
		
		// removeall을 통해 다른 배열의 값과 같은 값을 전부 제거 가능
		arrayList6.removeAll(arrayList5);
		
		//contains로 해당 값과 같은 값이 존재하는지 확인 가능
		arrayList6.contains(arrayList5.get(0));

		//단순 출력을 위해서는 반복문을 사용해도 되고 오히려 더 빠르지만 Iterator를 통해서는 Collection의 List,Hash,Queue,Map 을 전부다 처리할 수 있는 장점이 있다.
		Iterator itr = arrayList6.iterator();
		
		itr.hasNext(); // 다음 값이 존재하는지 확인
		itr.next(); // 다음 값 반환; 
		itr.remove(); // next()에서 불러온 값 제거


	}
	
}
