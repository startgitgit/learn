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
        Class<?> class1= Class.forName("reflect.Student");
        System.out.println("类名称：" + class1.getSimpleName());

        Object o = class1.newInstance();
        Field  fieldName = class1.getDeclaredField("name");
        Field  fieldAge = class1.getDeclaredField("age");

        fieldName.setAccessible(true);
        fieldAge.setAccessible(true);

        fieldName.set(o,"zhou");
        fieldAge.set(o,34);

        System.out.println(fieldName.get(o));

        System.out.println(o);

        String alarmLevel = "1,2,3,4";
        String[] arr = alarmLevel.split(",");
        System.out.println(arr.toString());
    }
}
