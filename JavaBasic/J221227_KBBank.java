package JavaBasic;

public class J221227_KBBank implements J221227_Bank {

	@Override
	public void withDraw(int price) {
		System.out.println("KB은행의 인출 프로세스...");
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
		System.out.println("KB은행의 입금 프로세스...");
		if (price < 0) {
			System.out.println("입금 할 금액을 다시한번 확인해주세요.");
		} else {
			System.out.println(price+"원을 입금합니다.");
		}
	}

}
