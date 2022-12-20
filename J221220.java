
public class J221220 {

	public static void main(String[] args) {
	 J221220_Calculator calc=new J221220_Calculator("sasd");
	 calc.powerOn();
	 System.out.println(calc.add(5, 10));
	 System.out.println(calc.multiple(5, 5));
	 System.out.println(calc.divide(5, 7));
	 int[] arr= {1,2,3,4,5,6,7};
	 System.out.println(calc.adds(arr));
     calc.batteryCheck();
	 System.out.println(calc.adds(arr));
	 System.out.println(calc.adds(arr));
	 calc.powerOn();
	 calc.charge();
     calc.batteryCheck();
	}
	
}

