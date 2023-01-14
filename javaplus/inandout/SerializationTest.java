/*
 * Class SerializationTest
 * Date 23.01.14
 * 직렬화 기본 테스트
 */

package javaplus.inandout;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//오브젝트를 읽고 쓸때 Serializable을 구현해야함
//Externalizable이라는 것도 있는데 이건 읽고 쓸때 특정한 방법을 구현하기 위할때 쓰는것
class Person implements Serializable{
	
	private static final long serialVersionUID = -5058847192711990586L;

	String name;
	String title;
	//socket처럼 Serialize가능하지 않은것이나 넘겨주지 않을 데이터 접두어로 쓰면 output되지 않음
	transient String transientdata; 
	public Person() {}
	public Person(String name, String title) {
		this.name = name;
		this.title = title;
	}
	
	@Override
	public String toString() {
		return name + ", " + title;
	}
}
public class SerializationTest {

	public static void main(String[] args) throws ClassNotFoundException {

		String path = System.getProperty("user.dir") + "/javaplus/inandout/";
		
		Person personeLee = new Person("Lee", "Manager");
		try( FileOutputStream fos = new FileOutputStream(path + "Serial.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(personeLee);			
		} catch (IOException e) {
			System.out.println(e);
		}
		
		try( FileInputStream fis = new FileInputStream(path + "Serial.dat");
				ObjectInputStream ois = new ObjectInputStream(fis)){
			Object obj = ois.readObject();
			
			//읽은 오브젝트가 Person일때만 작동하게
			if( obj instanceof Person) {
				Person p = (Person)obj;
				System.out.println(p);
			}
		}catch (IOException e) {
			System.out.println(e);
		}
		
	}

}
