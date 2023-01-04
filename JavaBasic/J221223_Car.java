package JavaBasic;

public class J221223_Car {
	
	J221223_Tire[] tires= {
	new J221223_Tire("앞왼쪽" , 6),
	new J221223_Tire("앞오른쪽", 2),
	new J221223_Tire("뒤왼쪽",3),
	new J221223_Tire("뒤오른쪽",4)
	};
  
  
  int run() {
	System.out.println("Run 메소드가 실행되었습니다. 모든 바퀴의 roll 메소드가 실행됩니다.");  
	for(int i=0;i<=tires.length-1;i++) {
		if (tires[i].roll()==false) {stop(); return (i+1);}
		}
	return 0;
	}
  void stop() {
	  System.out.println("자동차가 멈춥니다.");
  }
}
