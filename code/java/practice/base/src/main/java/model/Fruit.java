package model;

/**
 * @Author: zhouyq
 * @Date: 2019/4/7 19:28
 * @Version 1.0
 * @Description
 */
public class Fruit extends Food{
    private String name;

    public Fruit(String name,String name1) {
        super(name);
        this.name= name1;
    }

    public void getInfo(){
        System.out.println(this.name);
        System.out.println(super.name);
        System.out.println(this.type);
    }
}
