/*
 * Class ComparatorInfo
 * Date 23.01.10
 * TreeMap, TreeSet에 넣을 Class에 Comparable을 구현하지않고 생성자에 Comparator를 매개변수로 줌으로써 정렬을 하는 방법
 */

package javaplus.collection.comparator;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

class StringLengthComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		if (o1.length() < o2.length()) return -1;
		else if (o1.length() == o2.length()) return 0;
		else return 1;
	}
	
}

public class ComparatorInfo {

	public static void main(String[] args) {
		
		TreeSet<String> treeSet = new TreeSet<String>(new StringLengthComparator());
		
		treeSet.add("글자하나");
		treeSet.add("두개의글자");
		treeSet.add("서너개의글자");
		treeSet.add("다으서으개의글자");
		treeSet.add("내맘대로막써");
		treeSet.add("이것이자유다");
		
		Iterator iterator = treeSet.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());  
		}
		
		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>(new StringLengthComparator());
		
		treeMap.put("글자하나", 1);
		treeMap.put("두개의글자", 2);
		treeMap.put("서너개의글자", 3);
		treeMap.put("다으서으개의글자", 4);
		treeMap.put("내맘대로막써", 5); //6글자인 Key 값은 이미 있으므로 Value가 덮어 씌워짐
		treeMap.put("이것이자유다", 6); //6글자인 Key 값은 이미 있으므로 Value가 덮어 씌워짐
		
		while(!treeMap.isEmpty()) {
			Map.Entry<String, Integer> temp = treeMap.pollFirstEntry();
			System.out.println(temp);
		}
	}

}
