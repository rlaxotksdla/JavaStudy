package JavaBasic;

public class J221227 {

	public static void main(String[] args) {
		System.out.println("****KBBank를 인터페이스에 적용****\n");
		
		J221227_Bank bank = new J221227_KBBank(); //implements 한 인터페이스 타입으로 자동형변환
		bank.withDraw(100); //KBBank 내에 구현된 메소드 호출
		bank.deposit(100);
		System.out.println("찾은 계좌 : "+bank.findDormancyAccount("김태산")); //인터페이스 내에 default 메소드 호출
		J221227_Bank.fingerAuth("김태산"); //인터페이스 내의 static 메소드 호출

		System.out.println("\n****SHBank를 인터페이스에 적용****\n");
		
		bank = new J221227_SHBank();
		bank.withDraw(100);
		bank.deposit(100);
		System.out.println("찾은 계좌 : "+bank.findDormancyAccount("김태산")); //인터페이스 내의 default 메소드를 SHBank내에서 재정의 한 메소드 호출
		J221227_Bank.fingerAuth("김태산");
		

		System.out.println("\n****KBBank를 인터페이스에 적용****\n");
		
		bank = new J221227_KBBank(); 
		bank.withDraw(20000);
		bank.deposit(1000);
		System.out.println("찾은 계좌 : "+bank.findDormancyAccount("김태산"));
		J221227_Bank.fingerAuth("김태산");
	}

}
