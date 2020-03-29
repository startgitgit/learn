package Generics;

import model.Person;

public class Erasure {

    public <T> Erasure(Class<T> clazz) {
        try {
            T t = clazz.newInstance();
            System.out.println(t instanceof Person);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}