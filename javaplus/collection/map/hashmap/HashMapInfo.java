/*
 * Class HashMapInfo
 * Date 23.01.09
 */

package javaplus.collection.map.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapInfo {

	public static void main(String[] args) {
		
		Map<String, Integer> hashMap = new HashMap<String, Integer>();
		
		//객체 저장
		hashMap.put("자바 클래스", 501);
		hashMap.put("파이썬 클래스", 101);
		hashMap.put("스프링 클래스", 1001);
		
		//키 값이 중복되므로 덮어 씌워짐
		hashMap.put("자바 클래스", 505);
		
		//값 불러오기
		System.out.println(hashMap.get("자바 클래스"));
		
		//SentrySet을 가져와서 불러오기 - key와 value가 모두 필요할 때
		for (Entry<String, Integer> entrySet : hashMap.entrySet()) {
			String key = entrySet.getKey();
			int value = entrySet.getValue();
			System.out.println("KEY : " + key + ", VALUE : " + value);
		}
		
		//Iterator 활용
		Set<Entry<String, Integer>> entrySet = hashMap.entrySet();
		Iterator iterator = entrySet.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		//keySet을 가져와서 불러오기 - key값만 필요할 때
		for (String key : hashMap.keySet()) {
			System.out.println("KEY : " + key);
		}
		
		//Iterator 활용
		Set<String> keySet = hashMap.keySet();
		iterator = keySet.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		

	}

}
