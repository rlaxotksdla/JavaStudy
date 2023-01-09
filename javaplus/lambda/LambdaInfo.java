/*
 * Class LambdaInfo
 * Date 23.01.09
 * 람다식 기초
 */

package javaplus.lambda;

import java.util.function.IntBinaryOperator;

public class LambdaInfo {

	public static void main(String[] args) {
		//선언 방식
		
		//인터페이스 메소드에 매개변수가 있는경우
		Example1 example1 = (int a) -> {System.out.println(a);};
		Example1 example2 = (a) -> {System.out.println(a);};     //매개변수 타입은 생략될 수 있다.
		Example1 example3 = a -> {System.out.println(a);};	     //매개 변수가 하나라면 괄호가 생략될 수 있다.
		Example1 example4 = a -> System.out.println(a);		     //실행 문이 하나라면 중괄호도 생략가능하다.
		
		//매개변수가 없는 경우
		Example2 example5 = () -> {System.out.println("매개 변수 없음");};
		Example2 example6 = () -> System.out.println("매개 변수 없음");     //마찬가지로 실행문이 하나라면 중괄호 생략 가능.
		
		//리턴 문
		Example3 example7 = (a, b) -> {return a + b;};    
		Example3 example9 = (a, b) -> a + b;             //중괄호 내 리턴문만 있다면 중괄호 생략 가능 

		//람다식 활용을 위한 표준 API 인터페이스 정보
		
		/*
		 * Consumer - 매개값이 있고 리턴값이 없는 인터페이스
		 * 	   Consumer<T>          : void accept(T t)               - 객체값 1개
		 * 	   BiConsumer<T, U>     : void accept(T t, U u)          - 객체값 2개
		 *     DoubleConsumer       : void accept(double value)      - double 값 1개
		 *     IntConsumer          : void accept(int value)         - int 값 1개
		 *     LongConsumer         : void accept(long value)        - long 값 1개
		 *     ObjDoubleConsumer<T> : void accept(T t, double value) - 객체값 1개, double 값 1개
		 *     ObjIntConsumer<T>    : void accept(T t, int value)    - 객체값 1개, int 값 1개
		 *     ObjLongConsumer<T>   : void accept(T t, long value)   - 객체값 1개, long 값 1개
		 *     
		 * Supplier - 매개값이 없고 리턴값이 있는 인터페이스
		 *     Supplier<T>     : T get()                 - 객체 T 리턴
		 *     BooleanSupplier : boolean getAsBoolean()  - boolean 값을 리턴
		 *     DoubleSupplier  : double getAsDoubl()     - double 값을 리턴
		 *     IntSupplier     : int getAsInt()          - int 값을 리턴
		 *     LongSupplier    : long getAsLong()        - long 값을 리턴
		 *     
		 * Function - 매개값과 리턴값이 모두 있고 매핑(타입 변환)에 활용하는 인터페이스    
		 *     Function<T, R>           : R apply(T t)                     - 객체 T를 객체 R로 매핑
		 *     BiFunction<T, U, R>      : R apply(T t, U u)                - 객체 T와 U를 R로 매핑
		 *     DoubleFunction<R>        : R apply(double value)            - double을 객체 R로 매핑
		 *     IntFunction<R>           : R apply(int value)               - int 를 객체 R로 매핑
		 *     IntToDoubleFunction      : double applyAsDouble(int value)  - int 를 double로 매핑
		 *     IntToLongFunction        : double applyAsDouble(long value) - int 를 long 로 매핑
		 *     LongToDoubleFunction     : double applAsDouble(long value)  - long 을 double 로 매핑
		 *     LongToIntFunction        : int applyAsInt(long value)       - long 을 int 로 매핑
		 *     ToDoubleBiFunction<T, U> : double applyAsDouble(T t, U u)   - 객체 T와 U를 double 로 매핑
		 *     ToDoubleFunction<T>      : double applyAsDouble(T t)        - 객체 T를 double 로 매핑
		 *     ToIntBiFunction<T, U>    : int applyAsInt(T t, U u)         - 객체 T와 U를 int 로 매핑
		 *     ToIntFunction<T>         : int applyAsInt(T t)              - 객체 T를 int 로 매핑
		 *     ToLongBiFunction<T, U>   : long applyAsLong(T t, U u )      - 객체 T와 U를 long 로 매핑
		 *     ToLongFunction<T>        : long applyAsLong(T t)            - 객체 T를 long 로 매핑
		 *     
		 * Operator - 매개값과 리턴값이 모두 있고 연산에 활용하는 인터페이스  
		 *     BinaryOperator<T>     : T apply(T t1, T t2)                        - T타입 두 변수 연산 후 T 리턴
		 *     UnaryOperator<T>      : T apply(T t)                               - T를 연산한 후 T를 리턴  
		 *     DoubleBinaryOperator  : double applyAsDouble(double d1, double d2) - 두 개의 double 를 연산한 후 double 리턴
		 *     DoubleUnaryOperator   : double applyAsDouble(double d)             - 한 개의 double 을 연산한 후 double 리턴
		 *     IntBinaryOperator     : int applyAsInt(int a, int b)               - 두 개의 int 를 연산한 후 int 리턴
		 *     IntUnaryOperator      : int applyAsInt(int a)                      - 한 개의 int 를 연산한 후 int 리턴
		 *     LongBinaryOperator    : long applyAsLong(long a, long b)           - 두 개의 long 를 연산한 후 long 리턴
		 *     LongUnaryOperator     : long applyAsLong(long a)                   - 한 개의 long 를 연산한 후 long 리턴
		 *     
		 * Predicate - 매개값을 통해 연산 결과를 boolean으로 리턴하는 인터페이스
		 *     Predicate<T>      : boolean test(T t)          - 객체 T를 조사
		 *     BiPredicate<T, U> : boolean test(T t, U u)     - 객체 T와 U를 조사
		 *     DoublePredicate   : boolean test(double value) - double 값 조사
		 *     IntPredicate      : boolean test(int value)    - int 값을 조사
		 *     LongPredicate     : boolean test(long value)   - long 값을 조사
		 *     
		 *     
		 *     
		 * Consumer, Function, Operator 인터페이스 중 일부는 andThen(), compose() 디폴트 메소드를 가지고 있다.
		 *     InterfaceA 와 InterfaceB가 있다면 InterfaceA.andThen(InterfaceB) 를 실행하면 A를 먼저 실행하고 B를 실행
		 *     InterfaceA.compose(InterfaceB)를 실행하면 B를 먼저 실행하고 A를 실행한다.
		 * 
		 * Predicate 인터페이스는 모두 and(), or(), negate() 각각 &&, ||, !와 대응되는 메소드를 가지고 있고 Predicate<T>는 isEqual()의 정적 메소드도 가지고있다.
		 * 
		 * BinaryOperator<T>는 minBy(Comparator<? super T> comparator)와 maxBy(Comparator<? super T> comparator) 정적 메소드를 가지고있고
		 * 변수 a, b을 비교하여  a < b 이면 음수, a == b 이면 0, a > b 이면 양수를 리턴하는 compare() 메소드가 선언 되어 있다.
		 * 
		 */
		
		//정적 메소드 참조 - 이미 있는 메소드를 참조하려면 배운것대로 아래와 같이 선언 가능하지만.
		IntBinaryOperator operator1 = (a, b) -> Math.max(a, b); 
		//더욱 간결하게 다음과 같이 표현 가능   클래스명 :: 메소드명  - 당연한 얘기지만 매개변수의 갯수나 출력 수 형식이 같은방식이어야함
		operator1 = Math :: max; 
		//인스턴스 메소드 참조도 동일하게 인스턴스명 :: 메소드명을 이용해 참조가능
		IntBinaryOperator operator2 = operator1 :: applyAsInt;

	}

}

interface Example1 {
	public void method(int a);
}

interface Example2 {
	public void method();
}

interface Example3 {
	public int method(int a, int b);
}