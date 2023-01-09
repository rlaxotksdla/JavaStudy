/*
 * Class HashSetInfo
 * Date 23.01.09
 */

package javaplus.collection.set.hashset;

import java.util.HashSet;
import java.util.Set;

public class HashSetInfo {

	public static void main(String[] args) {

		Set<String> hashSet = new HashSet<String>();
		
		//add 메소드는 boolean을 리턴한다 중복값 없을 때 true 있을때 false
		hashSet.add("Java");
		hashSet.add("Java");
		hashSet.add("Python");
		hashSet.add("Python");
		
		//중복값을 저장하지 않는다
		System.out.println(hashSet.size());
		
		
	}

}
