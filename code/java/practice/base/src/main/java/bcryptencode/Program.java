package bcryptencode;

import org.mindrot.jbcrypt.BCrypt;

/**
 * @Author: zhouyq
 * @Date: 2020/1/26 9:40
 * @Version 1.0
 * @Description
 */
public class Program {
    public static void main(String[] args) {
        String password = "12345";
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(hashed);

        String hashed01 = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(hashed01);

        String hashed02 = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(hashed02);


        String hashed03 = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(hashed03);


        String hashed04 = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(hashed04);

        String hashed05 = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(hashed05);
        String hashed2 = BCrypt.hashpw(password, BCrypt.gensalt(12));
        String candidate = "12345";

        if (BCrypt.checkpw(candidate, hashed)) {
            System.out.println("It matches");
        } else {
            System.out.println("It does not match");
        }
    }
}
