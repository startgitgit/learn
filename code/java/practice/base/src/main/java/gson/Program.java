package gson;


import com.google.common.base.Optional;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.*;

/**
 * Created by mac on 2017/6/25.
 */
public class Program {
    public static final Gson gson = new Gson();

    public static void main(String[] args) {
        Person person = new Person("zhou",30L);
        Person person1 = new Person("zhou",31L);

        HashSet<Person> set= new HashSet<Person>();
        set.add(person);
        set.add(person1);

        HashMap<Person,String> map = new HashMap<Person, String>();
        map.put(person,"zhou");
        map.put(person1,"zhou");

        TreeSet<Person> treeSet = new TreeSet<Person>();
        treeSet.add(person);
        treeSet.add(person1);
        treeSet.add(new Person("zhou",1L));

        treeSet.remove(new Person("zhou",30L));



        for (Person p : treeSet){
            System.out.println(p.getAge());
        }

        HashMap<Integer,Integer> a = new HashMap<Integer, Integer>();
        a.put(1,2);
        a.put(10,2);
        a.put(4,2);

        String str1 = gson.toJson(a);


        //GsonBuilder可以
       /* Gson gson = new GsonBuilder()
                .disableHtmlEscaping()
                .create();
        person1.setName(gson.toJson(person));*/

        String str = gson.toJson(person1);
        System.out.println(str);
    }
}
