/*
 * Class ArrayListPlus
 * Date 23.01.04
 * ArrayList 응용을 위한 예제를 만들어 보았다.
 */

package javaPlus.collection.list.arrayList;

import java.util.*;

public class ArrayListCompletion {
    public static void main(String[] args) {

    }
}

class Store{
    final String manager;
    final String location;

    Store(String manager, String location){
        this.manager = manager;
        this.location = location;
        System.out.println(this.location + "지점이 등록되었습니다. (지점장 : " + this.manager);
    }
}