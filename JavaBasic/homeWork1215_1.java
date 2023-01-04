package JavaBasic;


/*다음 코드의 출력 결과를 순서대로 나열하시오.
 * 
--정답--
true
false
true
false
A와 B는 같습니까? true

*/
public class homeWork1215_1 {

	public static void main(String[] args) {
		String A="501";
		String B="501";
		String C=new String("501");
	    System.out.println(A==B);
	    System.out.println(A==C);
	    System.out.println(A.equals(C));
	    System.out.println("A와 B는 같습니까? "+A==B); //연산 순서에 따라 "A와 B는 같습니까? "+A 가 더해져서 "A와 B는 같습니까? 501"과 "501"을 비교하게 되어 False가 나옴
	    System.out.println("A와 B는 같습니까? "+A.equals(B));

	}

}
