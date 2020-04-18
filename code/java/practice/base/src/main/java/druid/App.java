package druid;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        Session s = new Session();
        s.executeupdatebysql("select * from employee");
    }
}
