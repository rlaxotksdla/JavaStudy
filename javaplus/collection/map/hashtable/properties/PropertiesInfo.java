/*
 * Class PropertiesInfo
 * Date 23.01.09
 */

package javaplus.collection.map.hashtable.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;

public class PropertiesInfo {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		//경로를 지정하여 Properties 인스턴스 생성하는 법
		Properties properties = new Properties();
		properties.load(new FileReader("C:/Users/user/git/JavaStudy/javaplus/collection/map/hashtable/properties/database.properties"));
		
		//클래스 파일과 함께 properties 파일이 있는 경우 경로를 불러와서 Properties 인스턴스 생성하는 법(하위 패키지에 있는경우 "하위패키지명/database.properties")
		String path = PropertiesInfo.class.getResource("database.properties").getPath();
		//경로 내 한글이 있는 경우
		path = URLDecoder.decode(path, "utf-8");
		properties.load(new FileReader(path));
		
		//값 불러오는 법_ Map의 get()메소드를 사용하지 않는 이유는 object 타입으로 반환하기 때문에 강제 형변환을 추가로 해줘야하기 때문
		System.out.println(properties.getProperty("id"));
		

	}

}
