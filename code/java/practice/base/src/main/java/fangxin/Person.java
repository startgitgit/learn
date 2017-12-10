package fangxin;

/**
 * Created by mac on 2017/6/25.
 */
public class Person {
    private String name;
    private Long age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return name + ":" +age;
    }
}
