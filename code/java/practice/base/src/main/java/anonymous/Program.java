package anonymous;

public class Program {
    public static void main(String[] args) {
        Program p = new Program();
    }

    public Program() {
        ISay say = () -> {
            System.out.println("helloHK2 world");
            Program.this.sayGoodBye();
        };
        say.sayHello();
    }

    private void sayGoodBye() {
        System.out.println("Good Bye");
    }
}
