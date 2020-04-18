package druid;

import com.alibaba.druid.pool.DruidPooledConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Session {
    public void executeupdatebysql(String sql) throws SQLException {
        DbPoolConnection dbp = DbPoolConnection.getInstance();
        DruidPooledConnection con = dbp.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while(resultSet.next()) {
            System.out.println(resultSet.getString("name") + " ");
        }
        ps.close();
        con.close();
        dbp = null;
    }
}
