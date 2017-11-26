package gson;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by mac on 2017/6/25.
 */
public class Program {
    public static final Gson gson = new Gson();

    public static void main(String[] args) {
        Person person = new Person();
        Person person1 = new Person();
        person1.setName(person.getName());
        person1.setAge(person.getAge());

        //GsonBuilder可以
       /* Gson gson = new GsonBuilder()
                .disableHtmlEscaping()
                .create();
        person1.setName(gson.toJson(person));*/

        String str = gson.toJson(person1);
        System.out.println(str);
    }
}
