package JavaBasic;

import java.util.ArrayList;

//접근제한에 대해 배우고 활용 어떻게할지 아이디어내서 만들어봄
/*public 다른 패키지에서도 import한뒤로 사용 가능  -class, field, 생성자, method
 *protected 같은 패키지에서 사용가능 + 다른패키지에 있는 해당클래스의 자식클래스에서도 호출가능   -field, 생성자, method
 *default 지정 안했을경우 default 처리 같은 패키지 내에서만 사용 가능 -class, field, 생성자, method
 *private 해당 클래스 내에서만 사용 가능 -field, 생성자, method
 */
public class J221222_Class {

   final static private String acaname="서울학원"; //한 학원에서 사용하는 프로그램으로 제작 따라서 학원이름 final로 지정
   static private String address="";  //주소와 번호는 이전할경우 변경될 가능성이 있으므로 setter, getter 메소드를 작성하고 final 선언하지않음
   static private String acanumber="";
   static private ArrayList<J221222_Class> classList=new ArrayList<J221222_Class>(); //학원의 class리스트를 출력하기 위한 변수 당연하게 인스턴스 생성없이 호출가능하도록 static 선언
   final private String roomName;  // 인스턴스에서 메소드 호출없이 직접 변수값을 변경하지 못하게 private선언, 초기값 입력 후 변경 안되게 final선언
   final private int roomNumber;
   private String teacher; //마찬가지로 인스턴스에서 메소드 호출없이 직접 변수값 변경 방지 private
   ArrayList<Student> students=new ArrayList<Student>(); //학생리스트를 출력 하기위한 변수
   
   public J221222_Class(String roomNameData, int roomNumbData) { //생성자 final초기값 안줬던 반 이름과 반 번호는 당연하게 입력해줘야함
	   roomName=roomNameData;
	   roomNumber=roomNumbData;
	   this.teacher="미배정";
	   classAdd(this); //클래스 생성시 classlist에 추가함
   }
   private void classAdd(J221222_Class newclass) { //외부에서 직접호출할일 없는 메소드이므로 private 
	   classList.add(newclass);
	   System.out.println(newclass.roomNumber+"호의 반이 생성되었습니다.");
   }
   public static void setAddress(String addressData) {  //Class자체에서 호출할 용도이므로 static
	   address=addressData;
	   System.out.println("학원 주소가 등록되었습니다.");
   }
   public static String getAddress() { //Class자체에서 호출할 용도이므로 static
	   return address;
   }
   public static void setAcaNumber(String acanumberData) { //Class자체에서 호출할 용도이므로 static
	   acanumber=acanumberData;
	   System.out.println("학원 연락처가 등록되었습니다.");
   }
   public static String getAcaNumber() { //Class자체에서 호출할 용도이므로 static
	   return acanumber;
   }
   public String getRoomName() {//생성된 인스턴스가 아니면 반이름과 반번호가 있을수없으므로 static 선언안함
	   return this.roomName;
   }
   public int getRoomNumber() {//생성된 인스턴스가 아니면 반이름과 반번호가 있을수없으므로 static 선언안함
	   return this.roomNumber;
   }
   
   public String getTeacher() {//생성된 인스턴스가 아니면 반이름과 반번호가 있을수없으므로 static 선언안함
	   return this.teacher;
   }
   public void setTeacher(String teacher) { //생성된 인스턴스가 아니면 교사를 배정할 필요가 없음
	   this.teacher = teacher;
	   System.out.println(this.roomNumber+"호에 교사 "+this.teacher+"이(가) 배정되었습니다.");
   }
   public void addStudent(String nameInput,int ageInput) { //생성된 인스턴스가 아니면 학생을 배정할 필요가 없음
	   students.add(new Student(nameInput,ageInput));
	   System.out.println(this.roomNumber+"호에 "+nameInput+" 학생이 등록되었습니다.");
   }
   public void removeAllStudents() { //생성된 인스턴스가 아니면 학생을 제거할 필요가 없음
	   students.clear();
   }
   public void printStudentList() {//생성된 인스턴스가 아니면 학생리스트를 출력할 필요가 없음
	   System.out.println(this.roomNumber+"호의 학생 목록입니다.");
	   for (Student student : students) {
	   System.out.println(student.name+" : "+student.age+"세");
	   }
   }
   public static void printAcaInfo() { //Class자체에서 호출할 용도이므로 static
	   System.out.println("-학원 정보-\n이름 : "+acaname+"\n주소 : "+address+"\n번호 : "+acanumber);
   }
   public void printClassInfo() {//생성된 인스턴스가 아니면 반 정보를 출력할 필요가 없음
	   System.out.println(this.roomNumber+"호의 반 정보입니다."+"\n반 이름: "+this.roomName+"\n인원 : "+this.students.size()+"명");
   }
   public static void printClassList() {//Class자체에서 호출할 용도이므로 static
	   System.out.println("현재 "+ acaname+"의 총 "+J221222_Class.classList.size()+ "개의 반 리스트 입니다.");
	   for(J221222_Class classlist : classList) {
	   System.out.println("반 이름 : "+classlist.roomName+", 반 번호 : "+classlist.roomNumber+", 인원 : "+classlist.students.size()+"명"+", 교사 : "+classlist.teacher);
	   }
   }
   public static void removeClass(J221222_Class cls) { //메소드에 클래스인자를 넣어 해당 클래스를 제거, 당연하게 classList에서도 제거
	   classList.remove(cls);
	   System.err.println(cls.roomNumber+"호의 데이터를 삭제합니다.");
	   cls=null;
   }
   
}

class Student{
     final int age;
     final String name;
    public Student(String nameInput,int ageInput) {
    	this.name=nameInput;
    	this.age=ageInput;
    }
}


