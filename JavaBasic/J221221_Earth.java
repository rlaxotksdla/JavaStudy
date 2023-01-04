package JavaBasic;

public class J221221_Earth {
static final double EARTH_RADIUS = 6400; //static final 변수는 인스턴스 생성전에 접근도 가능할 뿐더러 수정도 불가능하다
static final double EARTH_SURFACE_AREA; // static final 변수는 인스턴스 생성전에 접근이 가능해야 하고 변경또한 불가능하므로 매개변수를 받아 초기화시킬수없다
static {
	EARTH_SURFACE_AREA=4*Math.PI*EARTH_RADIUS*EARTH_RADIUS; //따라서, 필드에서 초기화를 시키지 않았다면 static블록 내에서 초기화가 반드시 이루어져야한다
}

}
