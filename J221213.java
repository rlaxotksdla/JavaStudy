public class J221213 {

   public static void main(String[] args) {
      // public protected private 해당 클래스의 접근정도에 따라 사용
      // static 프로그램 실행시 메모리에 저장 (메모리 정리 대상이 안되게함) -main 메소드는 항상 존재해야하는 메소드
      // void 리턴값 없을때 선언 -main 메소드는 프로그램의 시작과 끝이므로 리턴값이 존재할 수 없음
      //String[] 프로그램 실행시 변수 입력을 위한 사전 선언 - args는 바뀔수있는 변수명 프로그램 실행시 변수 입력가능, main 메소드는 프로그램의 시작과 끝이므로 변수를 입력받아야할 방법이 필요하기에 꼭 선언해야함
      int a=1;
      int b=5;
      int result1 = a + b;
      int result2 = a * b;
      double result3 = (double)a / b;  //(double)을 붙이지 않으면 비트손실이 일어난 상태에서 result3값으로 들어가기에 0.0이됨 
      boolean result4 = a == b;
       String result41 = String.valueOf(result4);
       //String.valueOf() > boolean값을 String으로 강제 변환 , 변환전 result4값을 출력하면 false가 출력 되지만 한글로 바꾸기위해 해봄
        if (result41=="true") {
           result41="네";
        }
        else
        {
        result41="아니요";   
        }
      System.out.println("화면에 문자열 출력하기 - 221213 Java Class Start");
      System.out.println("화면에 args 입력값 출력하기 - " +args[0]+","+args[1]);
      System.out.println("변수 연산 결과 출력하기 \n a + b = " + result1 +"\n a * b= " + result2 + "\n a / b = " +result3+ "\n a와 b는 같나요? : " + result41 );
      

   }

}