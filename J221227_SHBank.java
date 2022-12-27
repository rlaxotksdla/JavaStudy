
public class J221227_SHBank implements J221227_Bank {

	@Override
	public void withDraw(int price) {
		System.out.println("SH은행의 인출 프로세스...");
		if (price <= J221227_Bank.MAX_MONEY) {
			System.out.println(price+"원을 인출합니다.");
		} else if (price < 0) {
			System.out.println("인출 할 금액을 다시한번 확인해주세요.");
		} else {
			System.out.println("한번에 "+J221227_Bank.MAX_MONEY+"보다 많은 금액을 인출할 수 없습니다.");
		}
		
	}

	@Override
	public void deposit(int price) {
		System.out.println("SH은행의 입금 프로세스...");
		if (price < 0) {
			System.out.println("입금 할 금액을 다시한번 확인해주세요.");
		} else {
			System.out.println(price+"원을 입금합니다.");
		}
	}
	
	@Override
	public String findDormancyAccount (String customerName) {
		System.out.println("SH은행의 메소드를 실행합니다.");
		System.out.println(customerName+"님의 휴면 계좌를 찾는 중입니다...");
		return "00은행 000-00-0000-00";
		
	}

}
