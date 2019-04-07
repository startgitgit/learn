package fangxin;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Program {

    public static void main(String[] args) {
        FX<Number> ex_num = new FX<Number>(100);
        FX<Integer> ex_int = new FX<Integer>(200);
        FX<String> ex_string = new FX<String>("hello");
        getData(ex_num);
        getData(ex_int);//编译错误
        getData(ex_string);

        System.out.println(FX.TEST);

        Erasure erasure = new Erasure(Person.class);

        // 泛型数组创建

        Object result = Array.newInstance(Integer.class, 10);

        Arrays.fill((Integer[])result,20);

    }

    public static void getData(FX<?> temp) { //此行若把Number换为“？”编译通过
        //do something...
    }
    public <T> T get(T obj) {
        return (T) obj;
    }
}


