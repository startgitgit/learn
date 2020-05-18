package jdbc;

import com.google.common.base.Preconditions;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.commons.lang3.StringUtils;
import org.postgresql.ds.PGPoolingDataSource;
import thread.ThreadService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/5/18 19:31
 */
public class Program {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "zaq12345";
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setUser(username);
        mysqlDataSource.setPassword(password);
        mysqlDataSource.setUrl(url);
        PGPoolingDataSource pgPoolingDataSource = new PGPoolingDataSource();
        Connection connection1 = pgPoolingDataSource.getConnection();
        connection1.close();


        ThreadLocal<Connection> connectionThreadLocal = ThreadLocal.withInitial(() -> {
            try {
//                return DriverManager.getConnection(url, username, password);

                return  mysqlDataSource.getConnection();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        });

        Arrays.asList(1,2,3,4,5,6,7,8,9).parallelStream().forEach(x -> {
//            Connection connection = connectionThreadLocal.get();
            Connection connection = null;
            try {
                connection = mysqlDataSource.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
                return;
            }
            PreparedStatement preparedStatement = null;
            Preconditions.checkNotNull(connection);
            try {
//                Thread.sleep(10000);
                connection.setAutoCommit(false);
                String sql = "INSERT INTO `test`.`employee`(`id`) VALUES (" + x +200000+");";
                preparedStatement = connection.prepareStatement(sql);
                Preconditions.checkNotNull(preparedStatement);
                preparedStatement.executeUpdate();

                String sql2 =  "INSERT INTO `test`.`employee`(`id`) VALUES (" + x +500000+");";
                PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
                preparedStatement2.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.rollback();
                    assert preparedStatement != null;
                    preparedStatement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });


        /*for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                Connection connection = connectionThreadLocal.get();
                PreparedStatement preparedStatement = null;
                Preconditions.checkNotNull(connection);
                try {
                    connection.setAutoCommit(false);
                    String sql = "INSERT INTO `test`.`employee`(`id`) VALUES (" + finalI +200000+");";
                    preparedStatement = connection.prepareStatement(sql);
                    Preconditions.checkNotNull(preparedStatement);
                    preparedStatement.executeUpdate();

                    String sql2 =  "INSERT INTO `test`.`employee`(`id`) VALUES (" + finalI +500000+");";
                    PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
                    preparedStatement2.executeUpdate();
                    connection.commit();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        connection.rollback();
                        assert preparedStatement != null;
                        preparedStatement.close();
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }*/



        System.out.println(StringUtils.center("end",50,"="));


    }
}
