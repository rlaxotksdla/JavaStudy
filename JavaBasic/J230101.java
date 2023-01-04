package JavaBasic;

class StudentA implements Cloneable { //클론을 사용하기 위해서는 Cloneable 인터페이스를 구현 해야함
	String name;
	StudentA(String name){
		this.name = name;
	}
	public Object clone() throws CloneNotSupportedException { //clone() 은 private 메소드로 되어있기때문에 사용하려면 오버라이딩 하여 public으로 바꿔줘야함
		return super.clone();
	}
}


public class J230101 implements Cloneable {

	//enum 상수를 활용하기 위해 사용
	//변수 생성자 메소드 를 통해 기존의 상수보다 많은 역할을 할 수 있고 코드가 간결해짐
	
enum Legion {
	ASIA, US, UK
}

enum Item {
	ICECREAM("Cold"), HOT_COFFEE("Hot"), WATER("Normal");
	
	private String state;
	
	Item(String state){
		System.out.println("생성자");
		this.state = state;
	}
	
	String getState() {
		return this.state;
	}
	
}


    String[] strArray = {"A","B","C","D"};
    
	public Object clone() throws CloneNotSupportedException { //clone() 은 private 메소드로 되어있기때문에 사용하려면 오버라이딩 하여 public으로 바꿔줘야함
		return super.clone();
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		Item item = Item.HOT_COFFEE; // Item 변수를 만들면 Item enum내 모든 상수의 생성자가 실행됨
		
		switch(item) {
		case HOT_COFFEE:
			System.out.println("커피입니다. 상태는 : "+Item.HOT_COFFEE.state);
			break;
		case ICECREAM:
		    System.out.println("아이스크림입니다. 상태는 : "+Item.ICECREAM.state);
			break;
		case WATER:
			System.out.println("물입니다. 상태는 : "+Item.WATER.state);
			break;
		}
		
		for (Item i : Item.values()) {
			System.out.println(i + ", " + i.getState());
		}
		
		
		//---------------clone--------------
		
		StudentA s1 = new StudentA("KTS");
		try {
			StudentA s2 = (StudentA)s1.clone(); //오브젝트 타입을 반환하기때문에 형변환을 해줘야함
			System.out.println(s2.name);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		J230101 test1 = new J230101();
		J230101 test2 = (J230101)test1.clone();
		System.out.println(test1.strArray[0]);
		test1.strArray[0] = "B";
		System.out.println(test2.strArray[0]); //주의 인스턴스를 복제한다하더라도 인스턴스 내의 참조 변수는 주소값이 복제되기때문에 얕은 복사가 이루어짐
		
	}

}
