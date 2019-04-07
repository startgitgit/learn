package reflect;

import java.lang.reflect.Field;


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

        fieldName.setAccessible(true);
        fieldAge.setAccessible(true);

        fieldName.set(o,"zhou");
        fieldAge.set(o,34);

        System.out.println(fieldName.get(o));

        System.out.println(o);
    }
}
