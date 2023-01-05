/*
 * Class ArrayListCompletion with Function, StoreManageMent, Store
 * Date 23.01.04
 * ArrayList 응용을 위한 예제를 만들어 보았다.
 * 모든 것은 프로그램 실행 후 콘솔을 통해 입력한 데이터로 작동하게 하였다.
 * StoreManageMent 클래스를 통해 각 지점(store 인스턴스를 생성, 제거, 등) 관리하고
 * store에는 지점별(인스턴스 별) 고객 추가 제거를 할 수 있고 
 * 고객 중 블랙리스트로 추가하는 기능까지 구현하였다.
 * 자주 사용하는 기능은 Function 클래스를 만들어 간략화하였다.
 */

package javaplus.collection.list.arrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayListCompletion {
    public static void main(String[] args) throws IOException, InterruptedException {
    	//기본 데이터 입력구간
    	StoreManageMent.addStore("김태산", "서울 이대", 1);
    	StoreManageMent.stores.get(0).addMember("김정렬", 1);
    	StoreManageMent.stores.get(0).addMember("김상추", 1);
    	StoreManageMent.stores.get(0).addMember("나상렬", 1);
    	StoreManageMent.stores.get(0).addMember("다국이", 1);
    	StoreManageMent.stores.get(0).addMember("라마가", 1);
    	StoreManageMent.stores.get(0).addMember("마정수", 1);
    	StoreManageMent.addStore("장성태", "인천 구래", 1);
    	StoreManageMent.stores.get(1).addMember("신용권", 1);
    	StoreManageMent.stores.get(1).addMember("인간성", 1);
    	StoreManageMent.stores.get(1).addMember("소고기", 1);
    	StoreManageMent.stores.get(1).addMember("장독대", 1);
    	StoreManageMent.stores.get(1).addMember("양치기", 1);
    	StoreManageMent.stores.get(1).addMember("바둑이", 1);
    	StoreManageMent.addStore("김영광", "경기 화성", 1);
    	StoreManageMent.stores.get(2).addMember("고로쇠", 1);
    	StoreManageMent.stores.get(2).addMember("고로케", 1);
    	StoreManageMent.stores.get(2).addMember("쌍따봉", 1);
    	StoreManageMent.stores.get(2).addMember("양배추", 1);
    	StoreManageMent.stores.get(2).addMember("인사동", 1);
    	StoreManageMent.stores.get(2).addMember("다람쥐", 1);
    	
    	programRun(args);
         

    }

	public static void programRun(String[] args) throws InterruptedException, IOException {
		ArrayList<String> TIMES = new ArrayList<String>(Arrays.asList("오전 9시", "오전 10시", "오전 11시", "오후 12시","오후 1시",
				                                                "오후 2시", "오후 3시", "오후 4시", "오후 5시", "오후 6시", "오후 7시", "오후 8시", "오후 9시"));
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String menuStr = "-- 땡땡 프랜차이즈 예약 관리 시스템입니다. 원하시는 항목 번호를 입력해주세요. --"
    			+ "\n 1 : 고객 등록"
    			+ "\n 2 : 예약"
    			+ "\n 0 : 관리자"
    			+ "\n 8 : 시스템 종료";
    	Function.print(menuStr);
    	
    	int selectedNum;
    	Store selectedStore;
    	String answer;
    	
    	try {
        switch (Integer.parseInt(br.readLine())) {
        case 1:
        	Function.print("등록할 지점을 선택해 주세요.");
        	StoreManageMent.printStores();
        	selectedNum = Integer.parseInt(br.readLine());
        	Function.print(StoreManageMent.stores.get(selectedNum - 1).getLocation() + "지점을 선택하셨습니다. 고객명을 입력하세요.");
        	StoreManageMent.stores.get(selectedNum - 1).addMember(br.readLine());
        	programRun(args);
        	break;
        	
        case 2:
        	Function.print("예약할 지점을 선택해 주세요.");
        	StoreManageMent.printStores();
        	selectedNum = Integer.parseInt(br.readLine());
        	selectedStore = StoreManageMent.stores.get(selectedNum - 1);
        	Function.print(selectedStore.getLocation() + "지점을 선택하셨습니다. 고객명을 입력하세요.");
        	String name = br.readLine();
        	if (selectedStore.members.contains(name)) {
        		Function.print("예약할 시간을 선택하세요."
        				+ "\n 1 : 오전 9시"
        				+ "\n 2 : 오전 10시"
        				+ "\n 3 : 오전 11시"
        				+ "\n 4 : 오후 12시"
        				+ "\n 5 : 오후 1시"
        				+ "\n 6 : 오후 2시"
        				+ "\n 7 : 오후 3시"
        				+ "\n 8 : 오후 4시"
        				+ "\n 9 : 오후 5시"
        				+ "\n 10 : 오후 6시"
        				+ "\n 11 : 오후 7시"
        				+ "\n 12 : 오후 8시"
        				+ "\n 13 : 오후 9시", 10);
            	selectedNum = Integer.parseInt(br.readLine());
            	Function.print(name + "고객님 " + selectedStore.getLocation() + "지점 " + TIMES.get(selectedNum - 1) + "에 예약되었습니다.");
            	restart(args);
        	} else {
        		Function.print("해당 지점에 등록되지 않은 고객입니다. 먼저 등록해주세요.");
            	programRun(args);
        	}
        	break;
        	
        case 0:
        	Function.print("패스워드를 입력하세요.");
        	
        	if (StoreManageMent.checkCode(br.readLine())) {
        		Function.print("관리할 항목을 선택해주세요."
        				+ "\n 1 : 지점 관리"
        				+ "\n 2 : 고객 관리",10);
        		selectedNum = Integer.parseInt(br.readLine());
        		switch (selectedNum) {
        		case 1:
        			Function.print("1 : 지점 추가"
        					+ "\n 2 : 지점 제거",10);
            		selectedNum = Integer.parseInt(br.readLine());
            		switch (selectedNum) {
            		case 1:
            			Function.print("추가할 지점 위치를 입력해주세요.");
            			String location = br.readLine();
            			Function.print("지점장 이름을 입력해주세요.");
            			String manager = br.readLine();
            			StoreManageMent.addStore(manager, location);
                    	restart(args);
            			break;
            		case 2:
            			Function.print("제거할 지점을 선택해주세요.");
            			StoreManageMent.printStores();
                		selectedNum = Integer.parseInt(br.readLine());
                		StoreManageMent.removeStore(selectedNum - 1);
                    	restart(args);
            			break;
            		default:
            			break;
            		}
        			break;
        		case 2:
        			Function.print("지점을 선택해주세요.");
                	StoreManageMent.printStores();
                	selectedNum = Integer.parseInt(br.readLine());
                	selectedStore = StoreManageMent.stores.get(selectedNum - 1);
                	Function.print(selectedStore.getLocation() + "지점을 선택하셨습니다."
                			+ "\n 1 : 고객 리스트"
                			+ "\n 2 : 고객 추가"
                			+ "\n 3 : 고객 제거"
                			+ "\n 4 : 블랙리스트 확인"
                			+ "\n 5 : 블랙리스트 등록",10);
                	selectedNum = Integer.parseInt(br.readLine());
                	switch (selectedNum) {
                	case 1:
                		Function.printList(selectedStore.members);
                		Thread.sleep(1000);
                		break;
                	case 2:
                		Function.print("추가할 고객명을 입력해주세요.");
                		answer = br.readLine();
                		selectedStore.addMember(answer);
                		restart(args);
                		break;
                	case 3:
                		Function.print("제거할 고객명을 입력해주세요.");
                		answer = br.readLine();
                		selectedStore.removeMember(answer);
                		restart(args);
                		break;
                	case 4:
                		Function.print("---- " + selectedStore.getLocation() + "지점 블랙리스트 ----");
                		Function.printList(selectedStore.blackList);
                		restart(args);
                		break;
                	case 5:
                		selectedStore.memberToBlackList();
                		restart(args);
                		break;
                	default:
                		break;
                	}
        			break;
        		default:
        			break;
        		}
        		
        	}
        	
        	break;
        case 8:
        	Function.print("시스템을 종료합니다.");
        	break;
        default:
        	Function.print("올바른 숫자를 입력해주세요.");	
        	Function.print("프로그램을 재시작 합니다.");	
        	programRun(args);
        	break;
        }
    	}
    	catch (Exception e) {
    		Function.print("올바른 숫자를 입력해주세요.");
        	Function.print("프로그램을 재시작 합니다.");	
        	programRun(args);
    	}
	}

	public static void restart(String[] args) throws InterruptedException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Function.print("초기 화면으로 돌아가시겠습니까? Y/N");
		String answer = br.readLine();
		if (answer.equals("Y") || answer.equals("y")) {
        	programRun(args);
		} else if (answer.equals("N") || answer.equals("n")) {
        	Function.print("시스템을 종료합니다.");
		}
	}
}

class Function{
	
	static void print(String str, int milisec) throws InterruptedException {

    	for (int i = 0; i < str.length(); i++) {
    		Thread.sleep(milisec);
    		System.out.print(str.charAt(i));
    	}
    	System.out.println();
	}
	static void print(String str) throws InterruptedException {
		
		for (int i = 0; i < str.length(); i++) {
			Thread.sleep(30);
			System.out.print(str.charAt(i));
		}
		System.out.println();
	}
	
	static void printList(ArrayList<String> arrayList) throws InterruptedException {
		Iterator<String> itr = arrayList.iterator();
		int n = 0;
		while(itr.hasNext()) {
			n++;
			Function.print(n + " - " + itr.next());
		}
	}
}

class StoreManageMent{
	static final private String ACCESSCODE = "111111";
    static ArrayList<Store> stores = new ArrayList<Store>();

    static void addStore(String manager, String location) throws InterruptedException{
        stores.add(new Store(manager, location));
    }
    
    static void addStore(String manager, String location, int n) throws InterruptedException{
    	stores.add(new Store(manager, location, n));
    }
    
    static void printStores() throws InterruptedException {
    	Iterator<Store> itr = stores.iterator();
		int n = 0;
		while(itr.hasNext()) {
			n++;
			Function.print(n + " - " + itr.next().getInfo());
		}
    }
    
    static void removeStore(int n) throws InterruptedException {
    	Function.print(stores.get(n).getLocation() + " 지점을 제거합니다.");
    	stores.remove(n);
    }
    
    static boolean checkCode(String code) {
    	if (ACCESSCODE.equals(code)) {
    		return true;
    	}
    	else {
    		System.out.println("Access Denied");
    		return false;
    	}
    }
    

}

class Store{
    private final String manager;
    private final String location;
    ArrayList<String> members = new ArrayList<String>();
    ArrayList<String> blackList = new ArrayList<String>();

    Store(String manager, String location) throws InterruptedException{
        this.manager = manager;
        this.location = location;
        Function.print(this.location + "지점이 등록되었습니다. (지점장 : " + this.manager + ")");
    }
    Store(String manager, String location, int n) throws InterruptedException{
    	this.manager = manager;
    	this.location = location;
    	if (n != 1) {
    	Function.print(this.location + "지점이 등록되었습니다. (지점장 : " + this.manager + ")");
    	}
    }
    
    public void addMember(String name) throws InterruptedException {
    	this.members.add(name);
    	Function.print(this.location + "지점에 \'" + name + "\'고객님이 등록되었습니다.");
    }
    public void addMember(String name, int n) throws InterruptedException {
    	this.members.add(name);
    	if (n != 1) {
    	Function.print(this.location + "지점에 \'" + name + "\'고객님이 등록되었습니다.");
    	}
    }
    
    public String getInfo() {
    	return this.location + "지점, 지점장 : " + this.manager;
    }
    
    public String getLocation() {
    	return this.location;
    }
    
    public String getMembers() {
    	return String.join(",", members);
    }
    
    
    public void removeMember(String name) throws InterruptedException {
    	if (this.members.remove(name)) {
    		Function.print(this.location + "지점의 \"" + name + "\" 님이 등록 해제 되었습니다.");
    	}
    }
    
    public void memberToBlackList() throws InterruptedException, NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	Function.print(this.location + "지점의 고객 명단입니다. 블랙리스트에 추가할 고객번호를 입력하세요.");
    	Function.printList(this.members);
    	int n = Integer.parseInt(br.readLine());
    	Function.print(this.members.get(n - 1) + " 고객이 블랙리스트에 등록 되었습니다.");
    	this.blackList.add(this.members.get(n - 1));
    	this.members.remove(n - 1);
    
    }


}