
public class J221227 {

	public static void main(String[] args) {
		System.out.println("****KBBank를 인터페이스에 적용****\n");
		
		J221227_Bank bank = new J221227_KBBank();
		bank.withDraw(100);
		bank.deposit(100);
		System.out.println("찾은 계좌 : "+bank.findDormancyAccount("김태산"));
		J221227_Bank.fingerAuth("김태산");

		System.out.println("\n****SHBank를 인터페이스에 적용****\n");
		
		bank = new J221227_SHBank();
		bank.withDraw(100);
		bank.deposit(100);
		System.out.println("찾은 계좌 : "+bank.findDormancyAccount("김태산"));
		J221227_Bank.fingerAuth("김태산");
		

		System.out.println("\n****KBBank를 인터페이스에 적용****\n");
		
		bank = new J221227_KBBank(); 
		bank.withDraw(20000);
		bank.deposit(1000);
		System.out.println("찾은 계좌 : "+bank.findDormancyAccount("김태산"));
		J221227_Bank.fingerAuth("김태산");
	}

}
