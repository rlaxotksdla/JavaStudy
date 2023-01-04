package JavaBasic;

public class J221221_Car {
//필드
	static String company ="현대자동차";
	static String date="221221";
	static String info;//static 필드변수도 변스타입만 선언하고 값을 넣지 않을 수 있으나 이렇게 사용하는 경우는 static 필드를 통해 연산을 해서 집어넣어준다.
	String model;
	String color;
	static {
		info=date+"-"+company; //static 필드변수를 가져올때는 this.를 쓰지않는다. 그리고 static 블록내에서는 this.model같이 static변수가 아닌것은 사용하지못한다.
	}
	
	int maxSpeed;
	J221221_Car(){}	//기본 생성자 작성 안해도 기본적으로 자바는 이 기본 생성자를 추가함
	J221221_Car(String model){
		// 인스턴스 생성시 매개변수를 모델명만 입력했을 경우 기본적으로 색상과 스피드를 은색과 250으로 지정하게함 이런경우 생성자 명이 같은걸 이용해서 this.()를 이용해 다시 아래쪽 생성자로 넘겨줌으로써
	    //3줄짜리 코드를 1줄로 바꿀수있음.
		this(model,"은색",250); 
	}
	J221221_Car(String model,String color){
		this(model,color,250);
	}
	J221221_Car(String model,String color,int maxSpeed){
		this.model=model; //혼동하지 말아야하기에 클래스 변수엔 꼭 this를 붙여줘야함 매개변수를 클래스변수와 같은 변수명을 지정하지 않아도 됨
		this.color=color;
		this.maxSpeed=maxSpeed;
	}
	
    static void companyinfo() {
    	System.out.println(company); //static 필드변수는 this.으로 불러올 수 없음. 값이 고정되있기때문
    }
}
