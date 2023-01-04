package JavaBasic;

public class J221221 {

	public static void main(String[] args) {
		//------------------static---------------
		J221221_Car.companyinfo(); //static 메소드는 인스턴스를 생성하지 않아도 호출 가능
		System.out.println(J221221_Car.company); //static 변수는 인스턴스를 생성하지 않아도 호출 가능
		System.out.println(J221221_Car.info); //static 변수는 인스턴스를 생성하지 않아도 호출 가능
		J221221_Car.company="기아자동차"; //클래스 자체의 static 변수의 값도 변경이 가능하다
		//다만 클래스 자체의 static 변수의 값을 바꾸면 이후 생성되는 인스턴스,이미 생성된인스턴스 전부 영향을 준다.
		System.out.println(J221221_Car.company);
        J221221_Car newcar=new J221221_Car();
        //기본적으로 인스턴스를 생성해서 static변수를 호출하는것은 class에서 호출하라고 경고를 주나 런타임 오류가 생기진않는다
        System.out.println(newcar.company); 
        newcar.company="자동차"; //심지어 인스턴스의 static변수의 값을 변경해도 Class 자체의 static변수값이 변경되고 이후 생성되는 인스턴스,이미 생성된인스턴스 전부 영향을 준다.
        //이는 static변수의 주소값을 모두 공유한다는 것을 알수있다.
		System.out.println(J221221_Car.company);
        
		
		//----------------------final------------------------
		//J221221_Person newPerson=new J221221_Person(); //final 변수값 초기화중에 매개변수를 활용한 변수가 있으므로 매개변수 없이 생성이 불가능함
		J221221_Person newPerson=new J221221_Person("920119-1111111","김태산");
		//newPerson.ssn="999999-1111111"; final 값은 수정이 불가능함
		//static과 다른점은 static 변수값은 변경이 가능하나 모든 인스턴스에 영향을 주고 final 변수값은 추후 변경이 안되지만 인스턴스 생성전에 접근도 불가능할 뿐더러 각 인스턴스별 다른 주소를 참조한다.
		
		//-------------------static final-----------------------
	    System.out.println("지구의 반지름: "+J221221_Earth.EARTH_RADIUS+" km");	
	    System.out.println("지구의 표면적: "+J221221_Earth.EARTH_SURFACE_AREA+" km^2");	
	}

}
