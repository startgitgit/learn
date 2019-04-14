package finalTest;

import model.Person;

import java.util.ArrayList;

/**
 * @Author: zhouyq
 * @Date: 2019/4/14 11:43
 * @Version 1.0
 * @Description
 */
public class Program {
    public static void main(String[] args) {
        final  ArrayList<Person> f;
        ArrayList<Person> list1 = new ArrayList<>();
        list1.add(new Person("a",1L));
        ArrayList<Person> list2 = new ArrayList<>();
        list2.add(new Person("b",2L));
        f = list1;
        list1 = list2;

    }
}
