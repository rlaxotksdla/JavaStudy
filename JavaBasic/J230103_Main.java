package JavaBasic;

public class J230103_Main {

	public static void main(String[] args) {
		
		J230103_A a = new J230103_A();
		J230103_A.J230103_B b = a.new J230103_B(); // 클래스 내 인스턴스 클래스를 생성하기 위해서는 외부클래스를 먼저 생성하야함;
		b.field1 = 3;
		b.method1();
		
		J230103_A.J230103_C c = new J230103_A.J230103_C(); //인스턴스 생성시 외부클래스 먼저 생성할 필요 없음.
		c.field1 = 3;
		c.method1();  //인스턴스 메소드와 필드는 당연하게 인스턴스 생성 후 호출
		J230103_A.J230103_C.field2 = 3; //정적 필드나 정적 메소드는 클래스를 통해 호출
		J230103_A.J230103_C.method2();
		
		a.method();
		
	}

}
