import java.util.Arrays;


public class J221231 extends Object { //모든 클래스는 작성하지않아도 자동으로 Object 클래스를 상속받는다. 따라서 Object의 메소드를 사용가능하다.
	
	private final String name;
	
    public J221231(String name) {
    	this.name = name;
    }

	public static void main(String[] args) {
	    int[] a = new int[1];
	    a[0] = 1;
	    reference(a);
	    System.out.println(a[0]);  // 1이 출력됨 a는 int[]인스턴스의 주소값만가지고 있고 메소드를 호출하면 주소값을 전달 해당 변수에 새로운 인스턴스 주소를 할당하고 값을 변경해도 원래 주소값이 들어있는 a는 관계가 없음 

		
		String[] java = {"J","A","V","A"};
        System.out.println(Arrays.toString(java)); //배열 출력법
        J221231 lime1 = new J221231("Lime");
        J221231 lime2 = new J221231("Lime");
        System.out.println(lime1.equals(lime2)); // 원래있는 Object 클래스 내의 메소드 equals 당연히 인스턴스의 주소값을 비교하기때문에 false
        System.out.println(lime1.toString()); //J221231@7a81197d
        System.out.println(lime2.toString()); //J221231@5ca881b5  클래스 + @ + 인스턴스 주소값이 obj.toString() 메소드의 리턴값이지만
        // 역시 오버라이딩 하면 원하는대로 사용가능하다
        // equals는 J221231 클래스 내의 name값을 비교하는 메소드로 toString은 ---로 오버라이딩한 메소드를 작성하였다.
        System.out.println(lime1.equals(lime2)); // 새로 오버라이딩한 equals 인스턴스 내 name 변수값을 비교하게 하였음 true
        System.out.println(lime1.toString()); //새로 오버라이딩한 인스턴스 내 name 변수 값 + 해시코드를 리턴하게 함
        System.out.println(lime2.toString()); //새로 오버라이딩한 인스턴스 내 name 변수 값 + 해시코드를 리턴하게 함
        
  
		
	}
	
	static void reference(int[] b) { //참조에 대해 헷갈릴수 있는 부분  
		b = new int[2];
		b[0] = 2;
	} 
	
	public String toString() { 
		return  this.getName()+this.hashCode();
	}
	
	public boolean equals(Object obj) {
		J221231 a = (J221231) obj;
		return this.getName() == a.getName();
	}
	
	public String getName() {
		return this.name;
	}

}
