package JavaBasic;


public class J221223 {

	public static void main(String[] args) {
		 J221222_Parent polyParent=new J221222_Child(); //상속받은 자식 인스턴스는 부모 타입으로 자동 형변환 할 수 있다.
		 //부모 클래스로 형변환 한 뒤의 인스턴스는 
		 System.out.println(polyParent.sameValueName);// 당연하게도 기존 Parent 필드에 접근 가능
		 System.out.println(polyParent.parentValue);// 당연하게도 기존 Parent 필드에 접근 가능하고 Child 필드값엔 접근을 못함
//		 System.out.println(polyParent.privateValue);//주의할점은 자동 형 변환 후에도 Parent의 private 필드에는 접근을 못함
//		 polyParent.privateParentMethod(); //마찬가지로 private 메소드에도 접근을 못함
		 polyParent.printResult("A");// 오버라이드된 메소드가 실행됨
		 J221222_Child polyParentToChild=(J221222_Child) polyParent; //다시 자식인스턴스의 메소드나 변수의 접근하기 위해서는 강제 형변환을 할 수 있음;
		 System.out.println(polyParentToChild instanceof J221222_Child); //우측 클래스값 왼쪽 인스턴스값을 넣어 왼쪽 인스턴스의 참조하는 클래스가 맞는지 확인할수있음(형변환 후에도 형변환 전 초기 클래스르 참조함)
		 
		 
		 
		 
	//책 예제 연습  - 따라해보니 run()함수를 통해 각 인스턴스의 roll() 순차적으로 바퀴의 수명을 줄이고 수명이 0인 인스턴스가 생긴 즉시 return하여 그 뒤순서의 바퀴의 수명을 줄이지않음
		 //게다가 순차적으로 처리하다보니 만약 수명이 동시에 0이되야하는 상황이 와도 먼저 하나 바퀴를 갈고 다시 함수를 작동해야 다른바퀴를 교체하는 문제점이 있음
		 J221223_Car car= new J221223_Car();
		 for(int i=1; i<=5; i++) {
			 int problemLocation=car.run();
			 switch(problemLocation) {
			 case 1:
				 System.out.println("앞왼쪽 HankookTire로 교체");
				 car.tires[0]=new J221223_HankookTire("앞왼쪽",15);
				 break;
			 case 2:
				 System.out.println("앞오른쪽 KumhoTire로 교체");
				 car.tires[1]=new J221223_KumhoTire("앞오른쪽",13);
				 break;
			 case 3:
				 System.out.println("뒤왼쪽 HankookTire로 교체");
				 car.tires[2]=new J221223_HankookTire("뒤왼쪽",14);
				 break;
			 case 4:
				 System.out.println("뒤오른쪽 KumhoTire로 교체");
				 car.tires[3]=new J221223_KumhoTire("뒤오른쪽",17);
				 break;
			 }
			 System.out.println("------------"+i+" 바퀴 회전하였습니다.-------------");
		 }
	}

}
