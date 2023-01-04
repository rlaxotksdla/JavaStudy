package JavaBasic;

public class J221223_KumhoTire extends J221223_Tire {
public J221223_KumhoTire(String location, int maxRotation) {
	super(location,maxRotation);
}
@Override
public boolean roll() {
	++accumulatedRotation;
	if(accumulatedRotation<maxRotation) {
		System.out.println(location+" KumhoTire 수명: "+(maxRotation-accumulatedRotation)+"회");
		return true;
	}else {
		System.out.println("*** "+location+"KumhoTire의 수명이 다했습니다. ***");
		return false;
	}
}
}
