
public class J221222 {
	
	public static void main(String[] args) { 
		
		//J221222_Class Test용
	 J221222_Class class1=new J221222_Class("501호",501);
	 J221222_Class class2=new J221222_Class("601호",601);
	 class1.addStudent("김태산",31);
	 class2.addStudent("장성태",31);
	 class1.addStudent("김영광",31);
	 class1.printStudentList();
	 class1.setTeacher("이순재");
	 class2.setTeacher("이효리");
	 J221222_Class.setAcaNumber("02-9999-9999");
	 J221222_Class.setAddress("서울시 ---- ---- ---");
	 J221222_Class.printAcaInfo();
	 class1.printClassInfo();
	 class2.printClassInfo();
	 class1.removeAllStudents();
	 class1.printClassInfo();
	 J221222_Class.printClassList();
	 J221222_Class.removeClass(class1);
	 J221222_Class.printClassList();
	 
	 //상속 Inheritance 일부 데이터 변수나 메소드를 공용으로 사용할수있는경우 굳이 새로운 Class에 전부 작성할 필요없이 상속받아 사용하면된다. 클래스 명 뒤에 extends + 상속받을 클래스 명을 작성하면 되고
	 //private 접근제한을 가는 필드와 메소드는 해당 클래스를 상속받더라도 사용할 수 없고 default 인 경우라면 다른 패키지에 존재할 경우 사용할 수 없다.
	 
	 J221222_Child child=new J221222_Child();
	 System.out.println(child.publicValue);
	 System.out.println(child.defaultValue);  //패키지가 다를경우엔 접근 불가
//	 System.out.println(child.privateValue); privateValue는 접근 불가
	 child.printResult(""); //오버라이딩을 하기위해선 반환되는 값, 매개변수 타입,메소드명이 같아야하며 접근 제어자는 부모클래스보다 넓거나 같아야한다.
	 child.printResult(1);//부모 메소드에선 String이 인자였는데 자식 메소드에 추가로 동일이름의 메소드를 작성한것, 이건 오버라이딩된게 아니라 오버로딩된것
	 child.superPrintResult(); //super를 이용해 자식클래스에서 부모 변수나 메소드에 접근가능
	 child.superSameValueName(); 
	 System.out.println(child.sameValueName); //부모 클래스와 같은 이름의 변수가 있다면 상속제외가 되어 자식클래스의 값이 적용됨

	

	  
	}

}
