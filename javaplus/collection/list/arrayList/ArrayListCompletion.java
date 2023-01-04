/*
 * Class ArrayListPlus
 * Date 23.01.04
 * ArrayList 응용을 위한 예제를 만들어 보았다.
 */

package javaplus.collection.list.arrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListCompletion {
    public static void main(String[] args) {
        StoreManageMent.addStore("김태산","서울");

    }
}

class StoreManageMent{
    static ArrayList<Store> stores = new ArrayList<Store>();

    static void addStore(String manager, String location){
        stores.add(new Store(manager, location));
    }

}

class Store{
    private final String manager;
    private final String location;
    ArrayList<String> members = new ArrayList<String>();

    Store(String manager, String location){
        this.manager = manager;
        this.location = location;
        System.out.println(this.location + "지점이 등록되었습니다. (지점장 : " + this.manager + ")");
    }
    
    public void addMember(String name) {
    	this.members.add(name);
    	System.out.println(this.location + "지점에 " + name + "고객이 등록되었습니다.");
    }
    
    public String getMembers() {
    	return String.join(",", members);
    }
    
    public void removeMember(String name) {
    	if (this.members.remove(name)) {
    		System.out.println(this.location + "지점의 \"" + name + "\" 님이 등록 해제 되었습니다.");
    	}
    }
    
    public void memberToBlackList() {
    	System.out.println(this.location + "지점의 고객 명단입니다. 블랙리스트에 추가할 고객번호를 입력하세요.");
    	Iterator<String> itr = this.members.iterator();
    	int n = 0;
    	while(itr.hasNext()) {
    		n++;
    		System.out.println(n + " : " + itr.next());
    	}
    }


}