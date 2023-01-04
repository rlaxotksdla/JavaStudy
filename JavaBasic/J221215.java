package JavaBasic;
public class J221215 {
	public static void main(String[] args) {		
    operator();


	}

	public static void operator() {
		/*부호연산자 (+/-)
		정수나 실수 앞에 붙여 사용가능하며 주의해야할 점은 byte나 short타입과 연산하면 int타입으로 강제casting된다는 점이다
		*/

	    System.out.println("부호연산자 (+/-)");
				byte byte1=10;
			    short short1=10000;
		/*	    byte byte2=+byte1;  이 주석범위는 컴파일 에러가 남
			    byte byte3=-byte1;
			    short short2=+short1;
			    short short3=-short1;  
		*/	    
			    int byte2=+byte1;  
			    int byte3=-byte1;
			    int short2=+short1;
			    int short3=-short1;
			    
			    System.out.println("byte2 : "+byte2+"\n"+"byte3 : "+byte3+"\n"+"short2 : "+short2+"\n"+"short3 : "+short3);
			    
	    /*증감 연산자(++,--)
	     * 변수의 앞뒤에 사용 가능하며 앞이냐 전이냐에 따라 결과가 다르므로 주의해야함 속도로는 전에 위치하는게 빠르고 
	     * 전에 위치할경우 해당 라인 다른 연산을 먼저하고 처리되고 후에 위치할경우 연산이 모두 끝난뒤에 처리됨
	     */
	    System.out.println("증감 연산자(++,--)");
	    int x=10;
	    System.out.println("x : "+ x);
	    System.out.println("++x : "+ ++x);
	    x=10;
	    System.out.println("initiated \'x\' to 10");
	    System.out.println("x++ : "+ x++); //여기서 알수있는 점 출력 후에 x+1이 됨
	    System.out.println("x : "+ x);

	    x=10;
	    System.out.println("Below Calcs all initiated \'x\' to 10");
	    boolean a;
	    a= ++x>10;
	    System.out.println("++x>10 : "+a);x=10;
	    a= x++>10;
	    System.out.println("x++>10 : "+a);x=10;
	    /*논리 부정 연산자(!)  
	     * boolean 타입에만 사용할 수 있고 true > false , false > true로 바꿔준다
	     */
	    System.out.println("논리 부정 연산자(!)");
	    boolean b=true;
	    System.out.println("b : "+b);
	    System.out.println("!b : "+!b);
	    System.out.println("b : "+b);//증감 연산자와 다르게 바로 원래 변수에 값이 저장되지 않음을 확인할 수 있음
	    /*비트 반전 연산자(~)
	     * 정수타입(byte, short, int, long) 피연산자에만 사용이 가능하며 피연산자의 비트값을 0은 1로 1은 0으로 반전한다.
	     * 부호 연산자와 마찬가지로 byte나 short타입과 연산하면 int타입으로 강제casting되는것을 주의해야한다.
	     */

	    System.out.println("비트 반전 연산자(~)");
	    byte c=1;
//	    byte c2=~c; int로 강제 변환된 리터럴을 byte 변수에 넣으려고 하면 컴파일 에러가남
	    
	    System.out.println("c : "+ c);
	    System.out.println("~c : "+ (~c));
	    System.out.println("~c+1 : "+ (~c+1));
	    System.out.println("~(~c+1)+1 : "+(~(~c+1)+1));
	    
	    /*산술 연산자(+,-,*,/,%)
	     * + : 덧셈 연산
	     * - : 뺄셈 연산
	     * * : 곱셈 연산
	     * / : 오른쪽 피연산자로 좌측 피연산자로 나눗셈 연산
	     * % : 오른쪽 피연산자로 좌측 피연산자로 나눈 나머지를 구하는 연산
	     */
	    System.out.println("산술 연산자(+,-,*,/,%)");
	    
        byte b1=1;
        byte b2=1;
//      byte b3= b1+b2  마찬가지로 int로 강제변환 되기 때문에 컴파일 안됨  b3룰 int 타입으로 둬야함
        int int1=10;
        int int2=4;
        int result2= int1/int2;
        double result3=int1/int2;
        System.out.println(result2); //2
        System.out.println(result3); //2.0
//      값을 2.5로 얻으려면 두가지 int변수중 하나를 double타입으로 먼저 강제변환시켜야함
        result3= int1*1.0/int2; 
        System.out.println(result3);//2.5 
        result3= int1/int2*1.0; 
        System.out.println(result3);//2.0  연산 순서 문제
        result3= int1/(int2*1.0); 
        System.out.println(result3);//2.5 
        result3= (double)int1/int2;  
        System.out.println(result3);//2.5
        result3= int1/(double)int2;  
        System.out.println(result3);//2.5
        
        char c1= 'A'+1; 
        //    char c3= c2+1; 바로 윗줄의 리터럴간의 연산은 타입변환이 안일어나서 문제없이 컴파일되지만 변수와 리터럴을 더하면 c2가 int타입으로 변환되므로 (char)(c2+1)로 바꿔줘야 작동한다
        char c2= 'A';

        /*오버플로우 탐지
         * 산술 연산시 연산 후의 값이 해당 타입의 범위내에 없다면 오버플로우가 발생하여 엉뚱한값이 저장되므로 주의해야한다
         */
	    System.out.println("오버플로우 탐지");
        try {
        	int Overflowresult=safeAdd(2000000000,2000000000);
        	
        }
        catch(ArithmeticException e) {
        	System.out.println("오버플로우가 발생하여 정확하게 계산불가능");
        }
	    
	    
	    /*정확한 계산은 정수타입 활용
	     */
	    System.out.println("정확한 계산은 정수타입 활용");
	    int apple =1;
	    double pieceUnit=0.1;
	    int number =7;
	    double resultpiece=apple-number*pieceUnit;
	    System.out.println("사과 한개에서"+"0.7 조각을 빼면 "+resultpiece+" 조각이 남는다.");
	    //부동 소수점 타입 float와 double은 데이터를 근사치로 처리하기 때문에 해당 오류가 생길 수 있다  BigDecimal class를 활용하거나 int타입을 활용하여 계산해야한다.
	    
	    /*NaN과 Infinity 연산
         * 정수타입으로 /와 % 연산시 우측 피연산자로 0을 사용하게 되면 컴파일은 되나 ArithmeticException 예외가 발생한다.
         *  자바는 해당 예외가 발생할경우 바로 프로그램이 종료되므로 방지를 위해 catch 블록을 실행하도록 하는게 좋다
         * 실수타입으로 /와 % 연산시 우측 피연산자로 0을 사용하게 되면 각각 Infinity와 NaN 결과값을 낸다.
         * 해당 값과 연산하면 항상 Infinity와 NaN 결과값을 내므로 Double.isInfinite()와 Double.isNaN()을 통해 Boolean값을 받아 처리해야한다.
  	     */
	    
	    /*삼항 연산자
	     * 	조건식 ? 참값 : 거짓값 기본 구조는 이러하나 거짓값에 삼항연산자를 다시 사용하여 더 많은 연산가능
	     */
	    System.out.println("삼항연산자");
	    int score =85;
		char grade = score > 90 ? 'A' : 
			score > 80 ? 'B':'C' ;
			System.out.println("Grade is "+grade);
        
	}	
	    
	public static int safeAdd(int left, int right) {
		if (right>0) {
			if (left>(Integer.MAX_VALUE-right)) {
				throw new ArithmeticException("오버플로우 발생");
			}
		}
		else {
			if(left<(Integer.MIN_VALUE-right)) {
				throw new ArithmeticException("오버플로우 발생");
			}
		}
		 return left +right;
			
	}
}
