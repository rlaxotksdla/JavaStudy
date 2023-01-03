
public class J230103_A {
	class J230103_B{// 인스턴스 멤버 클래스		
		J230103_B () {}  //생성자
		int field1; //인스턴스 필드
		//static int field2; // 정적 필드 X
		void method1() {//인스턴스 메소드
			System.out.println("A 클래스 내 인스턴스 클래스인 B의 인스턴스 메소드가 실행되었습니다.");
		} 
		//static void method2(){} //정적 메소드 x 인스턴스 클래스에는 정적 메소드 , 필드가 선언될수없다.
	}
	
	static class J230103_C{
		J230103_C (){} // 생성자
		int field1;
		static int field2; 
		void method1() {
			System.out.println("A 클래스 내 정적 클래스인 C의 인스턴스 메소드가 실행되었습니다.");
		} 
		static void method2(){
			System.out.println("A 클래스 내 정적 클래스인 C의 정적 메소드가 실행되었습니다.");
		} //정적 클래스에는 정적 메소드 , 필드가 선언될 수 있다.
	}
	
    void method() {
    	//로컬 클래스
    	class J230103_D{
    		J230103_D(){}
    		int field1;
    		//static int field2 // 정적 필드 X
    		void method1() {//인스턴스 메소드
    			System.out.println("A 클래스 내 메소드 내 로컬 클래스인 D의 인스턴스 메소드가 실행되었습니다.");
    		} 
    		//static void method2(){} 정적 메소드 X 로컬 클래스는 메소드 내에서만 사용되므로 접근 제한이 필요가 없음
    	}
    	//메소드 내에서만 객체 생성 및 사용이 가능함
    	J230103_D d = new J230103_D();
    	d.field1 = 3;
    	d.method1();
    }

}
