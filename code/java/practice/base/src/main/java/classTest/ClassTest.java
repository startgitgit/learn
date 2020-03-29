package classTest;

import model.Apple;
import model.Food;
import model.Student;

public class ClassTest {
    public static void main(String[] args) {
        System.out.println(Food.class.isAssignableFrom(Apple.class));
        Apple apple = new Apple();
        Food food = new Food();
        System.out.println(apple instanceof Food);
        System.out.println(food instanceof  Apple);
        System.out.println(apple.getClass() instanceof Class<?>);
        System.out.println(Student.class.isInstance(apple));
    }
}
