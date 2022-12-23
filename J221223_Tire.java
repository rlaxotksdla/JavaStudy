
public class J221223_Tire {
public int maxRotation; //최대 회전수(타이어 수명)
public int accumulatedRotation; //누적 회전수
public String location;//타이어 위치

public J221223_Tire(String location,int maxRotation) {
	this.location=location;
	this.maxRotation=maxRotation;
}

public boolean roll() {
	++accumulatedRotation;
	if(accumulatedRotation<maxRotation) {
		System.out.println(location+ "Tire 수명 : "+(maxRotation-accumulatedRotation)+"회");
		return true;
	}else {
		System.out.println("*** "+location+"Tire 수명이 다되었습니다 ***");
		return false;
	}
}
}
