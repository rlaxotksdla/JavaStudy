import java.io.IOException;

public class J221216 {

	public static void main(String[] args)  {//인풋 아웃풋에서 오류 발생시 예외처리
		try {
		switchExample(); //스위치 연습
		guguExample(); //구구단 연습
		forWhileExamples(); //for, While문 연습
		}
		catch (IOException e) {
			System.out.println("예외가 발생하였습니다.");
		}
		//메인 메소드로 넘겨진 예외처리를 try catch를 해주거나 forWholeExamples처럼 throws IOException을 메소드에도 사용해줘야함
}

	public static void forWhileExamples() throws IOException { //인풋 아웃풋에서 오류 발생시 예외처리를 main 메소드에 넘김
		//for문은 일반적으로 반복횟수가 정해져 있을때 while은 아닐때
		//for과 while문 사용 시 변수의 위치를 잘 정해야함
				for(int i=1;i<=10;i++) {
					System.out.println(i);
				}
				//float 혹은 double을 사용하면 오차로 인해 제대로된 출력값을 못얻으니 주의
				for(float i=0.1f;i<=1;i=i+0.1f) {
					System.out.println(i);
				}
				for(int i=1; i<=3;i++) {
					for(int k=1;k<=2;k++) {
						System.out.println(k);
					}
				}
				int sum=0;
				for (int i = 0; i <=100; i++) {
					sum= i%2==0 ? sum+i : sum;			
				}
				System.out.println(sum);
				
				sum=0;
				int i=1;
				while(i<=100) {
					sum=i%2==0 ? sum+i : sum;
					i++;
				}
				System.out.println(sum);
		        
				// throws Exception
				boolean run=true;
				int speed=0;
				int keyCode=0;
				while(run) {
					if(keyCode!=13 && keyCode!=10) {
						System.out.println("---------------------");
						System.out.println("1.증속 | 2.감속 | 3.중지");
						System.out.println("---------------------");
						System.out.println("선택 : ");
					}
					keyCode=System.in.read();
					
					if (keyCode==49) {
						//1일 경우
						System.out.println("현재 속도= "+ ++speed);
					}
					else if(keyCode==50) {
					    //2일 경우
						System.out.println("현재 속도= "+ --speed);
					}
					else if(keyCode==51) {
						//3일 경우
						run=false;
					}
				}
				System.out.println("프로그램 종료");
	}

	public static void guguExample() {
		for (int i = 2; i<=9; i++) {
			System.out.println(i+"단 입니다.");
			for (int j = 1; j <=9; j++) {
              System.out.println(i+" X "+j+" = "+i*j);	
			}
      	 if(i!=9) {
      		 System.out.println();
      	 }
		}
	}

	public static void switchExample() {
		int num = (int)(Math.random()*6)+1;
		System.out.println(num);
		
		//switch 문에서 char, String 타입도 사용 가능하다
		
		switch(num) {
		case 1:
			System.out.println("1");
			break;
		case 2:
			System.out.println("2");
			break;
		case 3:
			System.out.println("3");
			break;
		case 4:
			System.out.println("4");
			break;
		case 5:
			System.out.println("5");
			break;
		default:
			System.out.println("6");
			break;
	}
	}
}


/*

package chap04;

import java.util.Scanner;

public class doWhile {

	public static void main(String[] args) {
		System.out.println("메세지를 입력하세요");
		System.out.println("종료하려면 q를 입력하세요");
		
        Scanner scanner=new Scanner(System.in);
        String inputString;
        do {
        	System.out.println(">>");
        	inputString=scanner.nextLine();
        	System.out.println("입력 데이터는 \'"+inputString+"\'입니다. ");
        }
        while(!inputString.equals("q"));
        System.out.println();
        System.out.println("프로그램이 종료되었습니다.");

	}

}

package chap04;

import java.util.Scanner;


//6나올때까지 주사위 굴리기
public class breakExample {

	public static void main(String[] args) {

		System.out.println("최대숫자를 입력하세요");
//		int maxString=(int)System.in.read(); System.in.read()는 입력값을 byte로 받아 출력하므로 scanner를 사용
		Scanner maxNum=new Scanner(System.in);
		int maxNumber;
        while(true) {
        System.out.println("입력 대기중");
		if (!maxNum.hasNextInt())
        {
			System.err.println("숫자를 입력하세요.");
       	    maxNum.nextLine();
		}
        else if (maxNum.hasNextInt()) {
        	maxNumber=maxNum.nextInt();
        	if (maxNumber>1) {
        		break;
        	}
            else {
    			System.err.println("1보다 큰 숫자를 입력하세요.");
           	    maxNum.nextLine();
        	}
        }
        }

		System.out.println("뽑고 싶은 숫자를 입력하세요 범위 : 1~"+maxNumber);
	    int chosenNumber;
		Scanner chosenNum=new Scanner(System.in);
		while(true) {
		chosenNumber=chosenNum.nextInt();
		if (1<=chosenNumber&&maxNumber>=chosenNumber) {
			break;
		}
		else {
			System.out.println("범위 내의 숫자를 입력하세요.");
		}
		}
		int count=0;
		while(true) {
			int num=(int)(Math.random()*maxNumber)+1;
			count++;
			System.out.println(count+"번째 시도 : "+num+"를 뽑았다!");
		if (num==chosenNumber)
		{
			System.out.println("정수 1부터 "+maxNumber+"까지 랜덤으로 추출했을때 "+count+"번째에서 "+ chosenNumber+"이 나왔어!");
			break;
		}
		}
		
		     
	}
}

*/