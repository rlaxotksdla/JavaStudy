import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class J221219 {

	public static void main(String[] args) throws IOException {
		 changeCalc(); //Array 연습
		 arrayinArray(); 
		 arrayCopy(); //Array Copy 해보기
		 
		 //클래스 생성, 호출, 빈생성의 경우 대비해서 메소드 생성
		 ClassCreate newclass=new ClassCreate();
		 newclass.name="김태산";
		 newclass.number=501;
		 System.out.print(newclass.name+", "+newclass.number);
	}

	public static void arrayCopy() {
		int[] oldIntArray = {1,2,3};
			int[] newIntArray = new int[5];
			for (int i = 0; i < oldIntArray.length; i++) {
				System.out.println(oldIntArray[i]);
			}
			//향상된 for문
			for(int i : oldIntArray) {
				System.out.println(i);
			}
			for (int i = 0; i < oldIntArray.length; i++) {
				newIntArray[i]=oldIntArray[i];
			}
			for (int i = 0; i < newIntArray.length; i++) {
			System.out.println(newIntArray[i]);	
			}
			for (int i = 0; i < newIntArray.length; i++) {
				if (newIntArray[i]==0) {
					newIntArray[i]=i+1;
				}
			}
			for (int i = 0; i < newIntArray.length; i++) {
			System.out.println(newIntArray[i]);	
			}

				
			
			String[] old = {"1", "2", "3"};
			String[] newArray = new String[5];
		    System.err.println(newArray.length);
			newArray  = old;
		    System.err.println(newArray.length);
			
			for(String num : newArray) System.out.print(num+", ");
				System.out.println();
				System.out.println();	
			
				old[0] = "100";	
				
			for(String num : newArray) System.out.print(num+", "); 
			//여기 출력결과 중요 Array의 기존 주소값이 복사된것이므로 기존 Array의 데이터를 변경하면 복사한 Array의 값을 불러오면 변경한 값이 불러와짐
				System.out.println();
				System.out.println();	
			
			for(String num : old) System.out.print(num+", ");
	}

	public static void arrayinArray() {
		int[][] scores = new int[2][3];
		scores[0][0]=1;
		scores[0][1]=2;
		scores[0][2]=3;
		scores[1][0]=4;
		scores[1][1]=5;
		scores[1][2]=6;
		for (int i=0; i<scores.length ;i++) {
			for (int j=0; j<scores[i].length;j++) {
				System.out.println(scores[i][j]);
			}
			
		}
	}

	public static void changeCalc() {
		Scanner input=new Scanner(System.in);
		 System.out.println("물건의 가격은 얼마입니까?");
		 int price=input.nextInt();
		 System.out.println("얼마를 지불했습니까?");
		 int paid=input.nextInt();
		 int[] moneyunit= {50000,10000,5000,1000,500,100,50,10};
		 if (paid-price<0) {
			 System.err.println("지불한 금액이 부족합니다.");
		 }
		 else if(paid==price) {
			 System.out.println("거스름돈이 없습니다.");
		 }
		 else {
	     int difference=paid-price;
		 System.out.println("거스름돈은");
		 for (int money:moneyunit) {
			 if (difference/money!=0) {
			 System.out.println(money+" : "+difference/money+"개");
			 difference=difference-money*(difference/money);
			 }
		 }
		 }

		 System.out.println("입니다.");
	}
	

}
class ClassCreate {
	String name;
	int number;
	public ClassCreate() {
		this.name=null;
		this.number=0;
	}
}