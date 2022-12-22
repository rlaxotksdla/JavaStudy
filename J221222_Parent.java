
public class J221222_Parent {  //클래스도 final 선언이 가능한데 하면 상속할수가없음 
  public String sameValueName="부모 클래스 값";
  private String privateValue="privateValue";
  String defaultValue="defaultValue";
  public String publicValue="publicValue";
  
  public void printResult(String a) {  //메소드에도 final을 선언하면 상속 할 수 없음 
  System.out.println("부모 클래스의 printResult 메소드가 실행되었습니다.");	  
  }
  
	
}
