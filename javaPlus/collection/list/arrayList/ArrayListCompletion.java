/*
 * Class ArrayListPlus
 * Date 23.01.04
 * ArrayList 응용을 위한 예제를 만들어 보았다.
 */

package javaPlus.collection.list.arrayList;

import java.util.*;

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
    final String manager;
    final String location;
    ArrayList<String> members = new ArrayList<String>();

    Store(String manager, String location){
        this.manager = manager;
        this.location = location;
        System.out.println(this.location + "지점이 등록되었습니다. (지점장 : " + this.manager);
    }


}