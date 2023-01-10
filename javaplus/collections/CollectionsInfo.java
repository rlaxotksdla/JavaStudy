/*
 * Class CollectionsInfo
 * Date 23.01.10
 * 동기화되지 않은 Collection인 ArrayList, HashSet, HashMap은 동기화 되지 않아 멀티스레드환경에서 안전하지 않다
 * 경우에 따라 동기화될 필요가 있는경우 Collections의 메소드로 동기화 시킨 List, Map , Set을 얻을 수 있다.
 */

package javaplus.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class CollectionsInfo {

	public static void main(String[] args) {
		
		ArrayList<String> arrayList = new ArrayList<String>();
		HashSet<String> hashSet = new HashSet<String>();
		HashMap<String, String> hashMap = new HashMap<String, String>();
		
		Collections.synchronizedList(arrayList);
		Collections.synchronizedSet(hashSet);
		Collections.synchronizedMap(hashMap);
		

	}

}
