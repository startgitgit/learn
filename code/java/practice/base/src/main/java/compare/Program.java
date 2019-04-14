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
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("aa",18L));
        list.add(new Person("bb",2L));
        Collections.sort(list);
    }
}
