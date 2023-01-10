/*
 * Class ComparableInfo
 * Date 23.01.10
 * TreeSet, TreeMap 사용시 Comparable 인터페이스를 구현하여  사용자 정의 정렬을 하는 방법
 */

package javaplus.collection.comparable;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

class Code implements Comparable<Code> {
	public String code;
	public String name;
	
	public Code(String code, String name) {
		this.code = code;
		this.name = name;
	}

	@Override
	public int compareTo(Code o) {
		if (this.code.length() < o.code.length()) return -1;
		else if (this.code.length() == o.code.length()) return 0;
		else return 1;
	}
	
	
}

public class ComparableInfo {

	public static void main(String[] args) {
		
		TreeSet<Code> treeSet = new TreeSet<Code>();
		
		treeSet.add(new Code("sadfklea","김태산"));
		treeSet.add(new Code("asefwae","김태산"));
		treeSet.add(new Code("awefaefaef","김태산"));
		treeSet.add(new Code("sdf","김태산"));
		treeSet.add(new Code("awsfsdf324","김태산")); //code의 길이가 동일해서 추가되지 않음
		treeSet.add(new Code("asdff","김태산"));
		
		
		System.out.println(treeSet.size());
		
		while(!treeSet.isEmpty()) {
			System.out.println(treeSet.pollFirst().code);  //길이 순으로 정렬되서 출력되는것을 알 수 있음.
		}
		
		TreeMap<Code, String> treeMap = new TreeMap<Code, String>();
		
		treeMap.put(new Code("sadfklea","김태산"), "1");
		treeMap.put(new Code("asefwae","김태산"), "2");
		treeMap.put(new Code("awefaefaef","김태산"), "3");
		treeMap.put(new Code("sdf","김태산"), "4");
		treeMap.put(new Code("awsfsdf324","김태산"), "5"); //key 값이 동일하다고 판단되어 3번째 Key에 Value값이 덮어 씌워짐
		treeMap.put(new Code("asdff","김태산"), "6");
		
		System.out.println(treeMap.size());
		
		while(!treeMap.isEmpty()) {
			Map.Entry<Code, String> temp = treeMap.pollFirstEntry();
			System.out.println("Key.code : " + temp.getKey().code + ", Value : " + temp.getValue()); //길이 순으로 정렬되는것을 알 수 있음.
		}

	}

}
