package gson;


import com.google.gson.Gson;
import model.Person;

import java.util.*;

/**
 * Created by mac on 2017/6/25.
 */
public class Program {
    public static final Gson GSON = new Gson();

    public static void main(String[] args) {
        Person person = new Person("zhou",30);
        Person person1 = new Person("zhou",31);

        HashSet<Person> set= new HashSet<Person>();
        set.add(person);
        set.add(person1);

        HashMap<Person,String> map = new HashMap<Person, String>();
        map.put(person,"zhou");
        map.put(person1,"zhou");

        TreeSet<Person> treeSet = new TreeSet<Person>();
        treeSet.add(person);
        treeSet.add(person1);
        treeSet.add(new Person("zhou",1));

        treeSet.remove(new Person("zhou",30));



        for (Person p : treeSet){
            System.out.println(p.getAge());
        }

        HashMap<Integer,Integer> a = new HashMap<Integer, Integer>();
        a.put(1,2);
        a.put(10,2);
        a.put(4,2);

        String str1 = GSON.toJson(a);
        System.out.println(str1);
        System.out.println(GSON.toJson(new Date()));


        //GsonBuilder可以
       /* Gson gson = new GsonBuilder()
                .disableHtmlEscaping()
                .create();
        person1.setName(gson.toJson(person));*/

        String str = GSON.toJson(person1);
        System.out.println(str);
    }
}
