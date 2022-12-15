
/*다음 코드에서 첫번째 출력값이 30일 경우 두번째 출력값은 무엇인가?
--정답--
  4등급입니다.
else if 문의 순서때문에 3등급입니다. 는 출력될수가 없음.
*/
public class homeWork1215_2 {
	public static void main(String[] args) {
		int per =(int)(Math.random()*50+1);
		System.out.println(per);
		per=30;
		if (per<=10) {
			System.out.println("1등급입니다.");
		}
		else if (per<=20) {
			System.out.println("2등급입니다.");
		}
		else if ( per<=40) {
			System.out.println("4등급입니다.");
		}
		else if (per<=30) {
			System.out.println("3등급입니다.");
		}
		else {
			System.out.println("5등급입니다.");
		}
	}

}
