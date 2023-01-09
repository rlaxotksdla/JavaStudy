/*
 * Class TreeMapInfo
 * Date 23.01.09
 * TreeMap 기본 활용
 * 예제가 점수를 Key값으로 두었는데 동일 점수를 받은 사람이 있을 가능성이 있다고 생각하면 좋지않은 예제인듯..
 */

package javaplus.collection.map.treemap;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapInfo {

	public static void main(String[] args) {
		TreeMap<Integer, String> scores = new TreeMap<Integer, String>();
		scores.put(87, "홍길동");
		scores.put(98, "이동수");
		scores.put(75, "박길순");
		scores.put(95, "신용권");
		scores.put(80, "김자바");
		
		//데이터 추가 순서와 상관없이 정렬된 모습
		System.out.println(scores);
		
		Map.Entry<Integer, String> entry = null;
		
		//가장 낮은 키값의 키와 값
		entry = scores.firstEntry();
		System.out.println("가장 낮은 점수 : " + entry.getKey() + ", 이름 : " + entry.getValue());
		
		//가장 높은 키 값의 키와 값
		entry = scores.lastEntry();
		System.out.println("가장 높은 점수 : " + entry.getKey() + ", 이름 : " + entry.getValue());
		
		//95점 바로 아래
		entry = scores.lowerEntry(95);
		System.out.println("95 바로 아래 점수 : " + entry.getKey() + ", 이름 : " + entry.getValue());
		
		//95점 바로 위
		entry = scores.higherEntry(95);
		System.out.println("95 바로 위 점수 : " + entry.getKey() + ", 이름 : " + entry.getValue());
		
		//95이상
		entry = scores.ceilingEntry(95);
		System.out.println("95 바로 이상 점수 : " + entry.getKey() + ", 이름 : " + entry.getValue());
		
		//95이하
		entry = scores.floorEntry(87);
		System.out.println("87 바로 이하 점수 : " + entry.getKey() + ", 이름 : " + entry.getValue());
		
		//이외의 방법은 TreeSet과 동일하므로 생략하였다.
	}

}
