package gson;


import com.google.gson.Gson;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by mac on 2017/6/25.
 */
public class Program {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("zhouyanqing");
        person.setAge(34);

        List<Person> personList = new ArrayList<Person>();
        personList.add(person);
        personList.add(person);


        Gson gson = new Gson();
        String str = gson.toJson(personList);
        System.out.println(str);
    }
}
