package JavaBasic;

public interface J221227_Bank {
	
	//여러 은행사에서 서비스를 하기위한 최소한의 메소드를 인터페이스로 구현하여 연습
	
	
	public int MAX_MONEY = 10000000; // 최대 인출 금액
	
	//인출 메소드
	void withDraw(int price);
	
	//입금 메소드
	void deposit(int price);
	
	//JAVA8 이상에서 가능한 default 메소드 -추상메소드가 아니므로 implements 받은 클래스를 모두 수정할 필요 없음
	//휴면 계좌를 찾아주는 메소드
	default String findDormancyAccount(String customerName) {
		System.out.println("전 은행사 공통인 인터페이스 내의 메소드를 실행합니다.");
		System.out.println(customerName+"님의 휴면 계좌를 찾는 중입니다...");
		return "00은행 000-00-0000-00";
	}   
	//JAVA8 이상에서 가능한 static 메소드 인터페이스. 으로 호출해서 사용
	static void fingerAuth(String customerName) {
		System.out.println("전 은행사 공통인 인터페이스 내의 메소드를 실행합니다.");
		System.out.println(customerName+"님의 지문인식을 진행중입니다...");
	}

}
