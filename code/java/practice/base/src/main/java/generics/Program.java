package generics;

import model.Apple;
import model.Banana;
import model.Fruit;
import model.Person;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Program {

    public static void main(String[] args) {
        Application<Number> ex_num = new Application<Number>(100);
        Application<Integer> ex_int = new Application<Integer>(200);
        Application<String> ex_string = new Application<String>("helloHK2");
        getData(ex_num);
        getData(ex_int);//编译错误
        getData(ex_string);

        System.out.println(Application.TEST);

        Erasure erasure = new Erasure(Person.class);

        // 泛型数组创建
        Object result = Array.newInstance(Integer.class, 10);

        Arrays.fill((Integer[])result,20);

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        System.out.println(Objects.equals(list1,list2));


        List<? extends  Number> aa = Arrays.asList(1, 2, 3);

        Number number = aa.get(0);

        List<? extends  Number> bb = new ArrayList<Integer>();


        List<? super   Number> list = new ArrayList<>();
        list.add(1);
        list.add(1.0);

        List<? super Fruit> fruits = new ArrayList<>();
        fruits.add(new Apple("super apple","apple"));
        fruits.add(new Banana("super banana","banana"));
        fruits.add(new Fruit("super fruit","fruit"));


    }

    public static void getData(Application<?> temp) { //此行若把Number换为“？”编译通过
        //do something...
    }
    public <T> T get(T obj) {
        return (T) obj;
    }
}


