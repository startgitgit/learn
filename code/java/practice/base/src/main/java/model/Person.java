package model;

/**
 * Created by mac on 2017/6/25.
 */
public class Person implements  Comparable<Person> {
    private String name;
    private Long age;

    public Person(String name, Long age) {
        this.name = name;
        this.age = age;
    }

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

    /*@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + name.hashCode();
        result = prime * result + age.intValue();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Person other = (Person) obj;
        if (name != other.name) {
            return false;
        }
        if (age != other.age) {
            return false;
        }

        return true;
    }*/


    public int compareTo(Person person){
       Long r = this.age - person.age;
       return  r.intValue();
    }
}
