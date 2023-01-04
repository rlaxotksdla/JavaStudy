package JavaBasic;

public class J221228 {

	/* 예외 처리
	 * NullPointerException - null인 객체로 메소드 호출할때
	 * ArrayIndexOutOfBoundsException - 배열의 인덱스범위를 벗어난 접근을 할때
	 * NumberFormatException - 숫자로 변환할 수 없는걸 변환하려 할때
	 * ClassCastException - 상속이나 인터페이스 간의 타입변환이 불가능할 경우 발생 타입변환 전 타입 변환이 가능한지 instanceof 연산자로 확인하면 해결할 수 있음
	 * 
	 * 처리방법
	 * try - catch - finally : try 블럭내에 실행할 코드 catch (exception 종류 , 변수) , finally 예외 발생 여부 무관하게 작동하는 코드
	 * catch 문은 다중 , 멀티가 가능하다 다중은 오버로딩과 같은 방식으로 매개변수의 exception 종류 별로 나눠 받아 따로 처리할때 멀티는 두가지 이상의 예외를 같은 방식으로 처리할 때 사용하면된다
	 * 다중 catch 문을 사용할 때에는 상위 예외 클래스를  나중 순서로 작성해야한다 예를 들면 다중 catch 문을 작성시 맨위에 Exception 캐치문을 작성하면 그 아래 하위 예외 클래스 문은 절대 실행되지 않는다 
	 * 메소드 throws + 예외 종류를 통해서 예외를 던질 수 있다 그런경우 메소드를 호출한 쪽에서 해당 예외를 처리해야하는데 처리하지 않거나 못하면 에러 메세지가 출력된다. main메소드도 throws 를 통해 예외를 던질 수 있는데
	 * 이경우 JVM이 받아 예외에 맞는 에러 메세지를 출력하는것으로 처리해준다. 
	 * throw new 예외 종류("메세지")를 통해 강제로 예외를 발생시킬수 있다.
	 * 변수(e).getMessage() 를 받아와 출력하여 "메세지"를 출력할 수 있고 변수(e).printStackTrace();를 통해 예외가 발생한 곳을 추척한 데이터를 출력할 수 있다.
	 * 
	 */
	
	public static void main(String[] args) {
		
		try {
			String data1 = args[0];
			String data2 = args[1];
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int result = value1 + value2;
			System.out.println(data1 + "+" + data2 + "=" + result);
		} catch(ArrayIndexOutOfBoundsException | NumberFormatException e) {  //멀티 캐치문
			System.out.println("실행 매개값의 수가 부족하거나 숫자로 변환할 수 없습니다.");
		} catch(Exception e) {
			System.out.println("예상하지 못한 예외 발생");
		} finally {
			System.out.println("다시 실행하세요.");
		}

	}

}
