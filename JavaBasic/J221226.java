package JavaBasic;

public class J221226 {
	//인터페이스의 본질은 추상메서드 _default 메서드와 static 메서드도 있다
    //default,static 메서드 인터페이스에서 기존 인스턴스 클래스의 실행에 오류를 주지않고 메서드를 추가할 수 있는방법이고
	//둘의 차이는 default는 인스턴스를 통해서, static은 인터페이스를 통해 호출이 가능하다는 점이다.
		
	public static void main(String[] args) {
        J221226_Member member = new J221226_Member();
        member.method();
        member.method1();
        System.out.println();
        
        //인터페이스도 일종의 조상이다. 다형성 개념이 적용된다.
        J221226_Creature creature = new J221226_Member();
        creature.method();
        System.out.println();
        //원래 타입을 벗어나지 못하므로 Member클래스의 멤버메서드는 호출불가.
        //creature.method1();
        
        J221226_Person person = new J221226_Person();
        person.method();
        person.method2();
        
        creature = new J221226_Person();
        creature.method();
        
        //상수접근시 인터페이스명. 상수명으로 접근함.
        System.out.println(creature.MAX);
	}

}
