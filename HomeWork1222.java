/*정답 및 해설
 * 
 * 1번 정답 : 501 - 동일한 이름의 변수가 있을 경우 상속제외가 되므로 501이 출력된다. (상속 제외가 되므로 타입을 다르게해도 상관없음)
 *
 * 2번 정답 : "자식 클래스에서 OverLoading된 메소드가 실행되었습니다.","자식 클래스의 printResult 메소드가 실행되었습니다."
 * - 오버라이딩을 위해서는 메소드 명,변수 타입과 갯수, 반환 타입까지 동일해야하지만 그렇다고해서 같은 메소드 명을 이용해서 오버로딩을 못하는건 아니다.
 * 
 * 3번 정답 : 3번 
 * -1번 인스턴스를 통해 부모의 private값에 직접 접근 불가능
 * -2번 자식 클래스 내에서도 부모의 private값에 직접 접근 불가능
 * -3번 부모 클래스 내에서 자신의 private값을 리턴하는 public 메소드는 호출이 가능하므로 해당 리턴값을 받아 출력 가능
*/

//메인 클래스 파일
public class HomeWork1222 {

	public static void main(String[] args) {
		
	Child child=new Child();

	//1번 문제 출력되는 값은 무엇인가요?
	
	System.out.println(child.sameValueName); 
	
	
	//2번 문제 각각 출력되는 값은 무엇인가요?
	
	child.printResult(10);
	child.printResult("text");
	
	
	//3번 문제 부모클래스에 속한 privateValue 변수의 값 "privateValue"를 출력하기 위한 방법으로 옳은것은?
	
	/*1번*/ 
	System.out.println(child.privateValue);
	/*2번*/ 
	System.out.println(child.returnValue1());
	/*3번*/ 
	System.out.println(child.returnValue2());
		
	}

}
//부모 클래스 파일
class Parent {
	public String sameValueName="부모";
	private String privateValue="privateValue";
	  
public void printResult(String a) {   
	  System.out.println("부모 클래스의 printResult 메소드가 실행되었습니다.");	  
	  }
	public String returnValue1() {
		return this.privateValue;
	}

}


//자식 클래스 파일

class Child extends Parent {

  public int sameValueName=501; 
  
  @Override
  public void printResult(String a) {
  System.out.println("자식 클래스의 printResult 메소드가 실행되었습니다.");	  
  }  
  public void printResult(int a) {
	  System.out.println("자식 클래스에서 OverLoading된 메소드가 실행되었습니다.");	  
	  }
  public String returnValue2() {
	  return super.privateValue;
  }

}