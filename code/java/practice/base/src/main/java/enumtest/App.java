package enumtest;

public class App {
    public static void main(String[] args) {
        System.out.println(Enum.valueOf(Day.class,"MONDAY"));
        System.out.println(Color.valueOf(Color.class,"RED"));


    }
}