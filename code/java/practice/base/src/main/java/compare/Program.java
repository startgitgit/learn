package compare;

import model.Person;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: zhouyq
 * @Date: 2019/4/14 11:16
 * @Version 1.0
 * @Description
 */
public class Program {
    public static void main(String[] args) {
        ArrayList<Person> peoples = new ArrayList<>();
        peoples.add(new Person("aa",18));
        peoples.add(new Person("bb",2));
        peoples.add(new Person("bb",12));
        Collections.sort(peoples);
        peoples.forEach(System.out::println);
    }
}
