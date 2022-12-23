
public class J221223_HankookTire extends J221223_Tire {
public J221223_HankookTire(String location, int maxRotation) {
	super(location,maxRotation);
}
@Override
public boolean roll() {
	++accumulatedRotation;
	if(accumulatedRotation<maxRotation) {
		System.out.println(location+" HankookTire 수명: "+(maxRotation-accumulatedRotation)+"회");
		return true;
	}else {
		System.out.println("*** "+location+"HankookTire의 수명이 다했습니다. ***");
		return false;
	}
}
}
