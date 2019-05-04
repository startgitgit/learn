package reflect;

import java.util.*;

/**
 * CREATED BY mac on 2017/6/16.
 */
public class Student {
    private String name;
    private int age;
    private  ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
    public Student(){}

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /*public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }*/

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public  static  void testSetOrder(){
        Integer[] arr = {5,1,4,0};
        Set<Integer> resultHashSet =  new HashSet<Integer>();
        LinkedHashSet<Integer> resultLinkedHashSet = new LinkedHashSet<Integer>();
        for (Integer i:arr){
            resultHashSet.add(i);
            resultLinkedHashSet.add(i);
        }

        for (Integer i : resultHashSet){
            System.out.print(i);
        }
        System.out.print("\n");
        for (Integer i : resultLinkedHashSet) {
            System.out.print(i);
        }
        System.out.print("\n");
        ArrayList<String> a = new ArrayList<String>();
    }


}
