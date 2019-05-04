package reflect;

import java.lang.reflect.Field;
import java.util.ArrayList;


public class Program
{
    public static void main( String[] args ) throws Exception
    {
        Student student = new Student("zhou",15);
        System.out.println(student);
        System.out.println("1 Set排序");
        Student.testSetOrder();
        //反射
        System.out.println("2 反射 ");
        Class<?> classSutdent= Class.forName("reflect.Student");
        System.out.println("类名称：" + classSutdent.getSimpleName());

        Object o = classSutdent.newInstance();
        Field  fieldName = classSutdent.getDeclaredField("name");
        Field  fieldAge = classSutdent.getDeclaredField("age");
        Field  fieldList = classSutdent.getDeclaredField("list");

        fieldName.setAccessible(true);
        fieldAge.setAccessible(true);
        fieldList.setAccessible(true);

        fieldName.set(o,"zhou");
        fieldAge.set(o,34);
        ArrayList<Integer> list = (ArrayList<Integer>) fieldList.get(o);
        list.remove(0);

        System.out.println(fieldName.get(o));

        System.out.println(o);
    }
}
