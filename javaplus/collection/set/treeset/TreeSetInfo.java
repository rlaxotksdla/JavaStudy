/*
 * Class TreeSetInfo
 * Date 23.01.09
 * TreeSet 활용 기초
 * 루트 노드로 시작하여 새로 추가하는 값을 비교하여 자식을 2개까지 가지며 작은값은 왼쪽 큰값은 오른쪽으로 정렬하는 구조로 
 * 정렬이나 특정 값을 기준으로 값을 얻어낼 때 유용하다.
 */

package javaplus.collection.set.treeset;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetInfo {

	public static void main(String[] args) {
		
		//TreeSet을 Set클래스로 생성할 수 있지만 TreeSet의 메소드 사용을 위해 TreeSet으로 생성하였다.
		TreeSet<Integer> scores = new TreeSet<Integer>();
		scores.add(87);
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(80);

		//데이터 추가 순서와 상관없이 정렬된 모습
		System.out.println(scores);
		
		Integer score = null;
		
		score = scores.first();
		System.out.println("가장 낮은 점수 : " + score);
		
		score = scores.last();
		System.out.println("가장 높은 점수 : " + score);
		
		score = scores.lower(95);
		System.out.println("95 바로 아래 점수 : " + score);
		
		score = scores.higher(95);
		System.out.println("95 바로 위의 점수 : " + score);
		
		score = scores.floor(95);
		System.out.println("95 이하 점수 중 첫번째 : " + score);
		
		score = scores.ceiling(95);
		System.out.println("95 이상 점수 중 첫번째 : " + score);
		
		while(!scores.isEmpty()) {
			score = scores.pollFirst(); // 가장 낮은 값을 호출하고 Set에서 제거 , 반대로 pollLast();
			System.out.println(score + "남은 객체 수 : " + scores.size());
		}
		
		//다시 값 추가
		scores.add(87);
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(80);
		
		Iterator iterator = scores.descendingIterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		NavigableSet<Integer> descendingSet = scores.descendingSet();
		NavigableSet<Integer> ascendingSet = scores.descendingSet().descendingSet();
		
		System.out.println(descendingSet);
		System.out.println(ascendingSet);

		//범위 내의 NavigableSet 얻는법 80초과 100이하
		NavigableSet<Integer> ns1 = scores.subSet(Integer.valueOf(80), false, Integer.valueOf(100), true);
		//80이하
		NavigableSet<Integer> ns2 = scores.headSet(80, true);
		//80이상
		NavigableSet<Integer> ns3 = scores.tailSet(80, true);
		
		System.out.println(ns1);
		System.out.println(ns2);
		System.out.println(ns3);
	}

}
