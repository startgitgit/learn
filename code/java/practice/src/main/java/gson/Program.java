package gson;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by mac on 2017/6/25.
 */
public class Program {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Mr{2222222222-fdsfasfs}");
        person.setAge(34);

        Person person1 = new Person();



        Gson gson = new GsonBuilder()
                .disableHtmlEscaping()
                .create();
        person1.setName(gson.toJson(person));

        String str = gson.toJson(person1);
        System.out.println(str);
    }
}
