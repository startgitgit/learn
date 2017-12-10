package fangxin;

public class Erasure<T> {
    private Class<T> clazz;
    private T t;

    public void Erasure(Class<T> aa) {
        this.clazz = aa;
        try {
            t = clazz.newInstance();
            System.out.println(t instanceof Person);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}