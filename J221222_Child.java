
public class J221222_Child extends J221222_Parent {
  public String sameValueName="자식 클래스 값"; // 동일한 이름으로 자식 클래스에 정의된 변수는 상속에서 제외되므로 다른 타입도 가능 ex)int sameValueName=9999;
  public String childValue="ChildValue"; //221223 Polymorphism 다형성을  추가
  
//  @Override  
//static 메소드는 오버라이딩이 안됨 -자식클래스 부모클래스 모두 static처리를하고 어노테이션을 지우면 컴파일 에러가 뜨지않는데 그 이유는 오버라이딩이 된게아니라 부모클래스의 정적 메소드를 숨겨주고 자식클래스 메소드를 호출함
  public void printResult(String a) { 
  System.out.println("자식 클래스의 printResult 메소드가 실행되었습니다.");	  
  }  
  public void printResult(int a) {
	  System.out.println("자식 클래스의 OverLoading된 메소드가 실행되었습니다.");	  
	  }
  //super를 통해 부모의 메소드 및 변수를 호출할 수 있으나 접근제어자의 영향을 받는다.
  public void superPrintResult() {
	  super.printResult(sameValueName); //super를 이용해 부모 메소드 호출
  }
  public void superSameValueName() {
	  System.out.println(super.sameValueName); //super를 이용해 부모 변수 호출 
  }
	
  public void childMethod() {//221223 Polymorphism 다형성을  추가
	  System.out.println("자식 클래스 메소드 실행");
}
}
