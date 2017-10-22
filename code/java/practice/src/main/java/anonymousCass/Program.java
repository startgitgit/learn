package anonymousCass;

public class Program {
    public static void main(String[] args) {
        ISay say = new ISay() {
            public void sayHello() {
                System.out.println("hello world");
            }
        };
        say.sayHello();
    }
}
