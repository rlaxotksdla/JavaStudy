package JavaBasic;

public class J221214 {

	public static void main(String[] args) {
		
		//정수 리터럴 관련 내용 배우는 중 8진수 16진수를 10진수로 계산해주는 프로그램을 구현하고 싶어져 만듬
		//정수리터럴 8진수 - 0으로 시작, 16진수 0x 혹은 0X로 시작

		String inputString=args[0].toString();
		if (args.length==1) {
		char[] charArray=inputString.toCharArray();
		int arraylength=charArray.length;
		System.out.println("Data Recieved");		
		System.out.println("Input Data : "+inputString);
		  calc(inputString, charArray, arraylength);
		}
		else {
			System.out.println("Only one data can be entered");
		}
		 
	}

		
		
public static void calc(String inputData, char[] ArrayData, int arraylengthData) {
		double sum = 0;
		double n = 0;
		int i;
		
		for(int e=0;e<arraylengthData;e++) {
		  ArrayData[e]=Character.toUpperCase(ArrayData[e]); 
		  //System.out.println(ArrayData);
		}
		
		
		if (ArrayData[0]=='0') {
			if (ArrayData[1]=='X') {
				n=16.;//Hexadecimal Number
				i=2;}
			else {
				n=8.;//Octal Number
				i=1;
			}
		for(;i<arraylengthData;i++) {
		if (ArrayData[i]=='1') {
			 sum=sum +Math.pow(n,arraylengthData-i-1)*1;
		  }
		  else if (ArrayData[i]=='2') {
			 sum=sum +Math.pow(n,arraylengthData-i-1)*2;
		  }
		  else if (ArrayData[i]=='3') {
			 sum=sum +Math.pow(n,arraylengthData-i-1)*3;
		  }
		  else if (ArrayData[i]=='4') {
			 sum=sum +Math.pow(n,arraylengthData-i-1)*4;
		  }
		  else if (ArrayData[i]=='5') {
			 sum=sum +Math.pow(n,arraylengthData-i-1)*5;
		  }
		  else if (ArrayData[i]=='6') {
			 sum=sum +Math.pow(n,arraylengthData-i-1)*6;
		  }
		  else if (ArrayData[i]=='7') {
			 sum=sum +Math.pow(n,arraylengthData-i-1)*7;
		  }
		  else if (ArrayData[i]=='8') {
			 sum=sum +Math.pow(n,arraylengthData-i-1)*8;
		  }
		  else if (ArrayData[i]=='9') {
			 sum=sum +Math.pow(n,arraylengthData-i-1)*9;
		  }
		  else if (ArrayData[i]=='0') {
			 sum=sum +Math.pow(n,arraylengthData-i-1)*0;
		  }
		  else if (ArrayData[i]=='A') {
			 sum=sum +Math.pow(n,arraylengthData-i-1)*10;
		  }
		  else if (ArrayData[i]=='B') {
			 sum=sum +Math.pow(n,arraylengthData-i-1)*11;
		  }
		  else if (ArrayData[i]=='C') {
			 sum=sum +Math.pow(n,arraylengthData-i-1)*12;
		  }
		  else if (ArrayData[i]=='D') {
			 sum=sum +Math.pow(n,arraylengthData-i-1)*13;
		  }
		  else if (ArrayData[i]=='E') {
			 sum=sum +Math.pow(n,arraylengthData-i-1)*14;
		  }
		  else if (ArrayData[i]=='F') {
			 sum=sum +Math.pow(n,arraylengthData-i-1)*15;
		  }
		}
		
		}
		if (n==16.) {
			System.out.println("[It's a Hexadecimal Number] - Convert ot Decimal Result : "+(int)sum);
		}
		else if(n==8.) {
			System.out.println("[It's a Octal Number] - Convert ot Decimal Result : "+(int)sum);
		}
		else {
			System.out.println("[It's a Decimal Number] - No need to Convert. Result : "+inputData);

	}
}
}