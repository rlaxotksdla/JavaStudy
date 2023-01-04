package JavaBasic;

public class J221222_Parent {
  public String sameValueName="부모 클래스 값";
  private String privateValue="privateValue";
  String defaultValue="defaultValue";
  public String publicValue="defaultValue";
  public String parentValue="ParentValue";//221223 Polymorphism 다형성을 위해  추가
  
  public void printResult(String a) {
  System.out.println("부모 클래스의 printResult 메소드가 실행되었습니다.");	  
  }

  public void parentMethod() {//221223 Polymorphism 다형성을 위해  추가
	  System.out.println("부모 클래스 메소드");
  }
  private void privateParentMethod() {//221223 Polymorphism 다형성을 위해  추가
	  System.out.println("부모 클래스 Private 메소드");
  }
}