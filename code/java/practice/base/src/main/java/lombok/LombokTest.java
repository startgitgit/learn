package lombok;

import model.Student;

public class LombokTest {
    public static void main(String[] args) {
        Student student = Student.builder().no(10081524).name("zhouyanqing").build();
        System.out.println(student);
    }
}
