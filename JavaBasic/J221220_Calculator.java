package JavaBasic;
import java.util.Random;

public class J221220_Calculator {
	boolean power;
	int batteryMax=10;
	int battery=5;
	String name;
	
	public J221220_Calculator() {
    System.err.println("계산기의 이름이 지정되지 않았습니다. 랜덤으로 생성됩니다.");
    this.name=randomName();
    System.out.println("생성된 계산기의 이름은 "+name+" 입니다.");
	}
    String randomName() {
    	  int leftLimit = 97; // letter 'a'
    	    int rightLimit = 122; // letter 'z'
    	    int targetStringLength = 10;
    	    Random random = new Random();
    	    String generatedString = random.ints(leftLimit, rightLimit + 1)
    	                                   .limit(targetStringLength)
    	                                   .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
    	                                   .toString();
		return generatedString;
	}
    public J221220_Calculator(String a) {
        this.name=a;
        System.out.println("생성된 계산기의 이름은 "+name+" 입니다.");
        }
	void powerOn() {
		if (this.power&& this.battery>0) {
			System.out.println("전원이 이미 켜져있습니다.");
		}
		else if(this.battery<=0) {
			System.out.println("배터리가 없습니다.");		
		}
		else {
		System.out.println("전원을 켰습니다.");
		this.power=true;
		}
	}
	void powerOff() {
		if (this.power) {
		System.out.println("전원을 종료합니다.");
		this.power=false;
		}
		else {
	    System.out.println("전원이 이미 꺼져있습니다.");
		}
	}
	void charge() {
		System.out.println("배터리를 충전하였습니다.");
		this.battery=this.batteryMax;
	}
	void batteryCheck() {
		System.out.println("현재 배터리는 "+(int)((double)this.battery/this.batteryMax*100)+"% 입니다.");
	}

	int add(int x,int y) {
		if (this.power) {
			this.battery--;
			System.out.println("계산 결과는 "+(x+y)+ "입니다. 결과값이 반환됩니다.");
			return x+y;
		}
		else if(this.battery<=0) {
			System.out.println("배터리가 없습니다.");		
			this.powerOff();
			return 0;		
		}
		else {
			System.out.println("먼저 전원을 켜주세요.");
			return 0;
		}
	}
	int multiple(int x,int y) {
		if (this.power&& this.battery>0) {
			this.battery--;
			System.out.println("계산 결과는 "+(x*y)+ "입니다. 결과값이 반환됩니다.");
			return x*y;
		}
		else if(this.battery<=0) {
			System.out.println("배터리가 없습니다.");		
			this.powerOff();
			return 0;		
		}
		else {
			System.out.println("먼저 전원을 켜주세요.");
			return 0;
		}
	}
	double divide(double x, double y) {
		if (this.power && this.battery>0) {
			this.battery--;
			System.out.println("계산 결과는 "+(x/y)+ "입니다. 결과값이 반환됩니다.");
			return x/y;
		}
		else if(this.battery<=0) {
			System.out.println("배터리가 없습니다.");		
			this.powerOff();
			return 0;		
		}
		else {
			System.out.println("먼저 전원을 켜주세요.");
			return 0;
		}
	}
	int adds(int ...values)  {// 혹은(int[] values)   -매개변수의 갯수가 정해져있지 않을때
		if (this.power&& this.battery>0) {
			this.battery--;
			int sum=0;
			for (int value:values) {
				sum+=value;
			}
			System.out.println("계산 결과는 "+sum+ "입니다. 결과값이 반환됩니다.");
			return sum;
		}
		else if(this.battery<=0) {
			System.out.println("배터리가 없습니다.");		
			this.powerOff();
			return 0;		
		}
		else {
			System.out.println("먼저 전원을 켜주세요.");
			return 0;
		}
	}
	
}
