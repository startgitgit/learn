package jdbc;

import com.google.common.base.Preconditions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

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
        ThreadLocal<Connection> connectionThreadLocal = ThreadLocal.withInitial(() -> {
            try {
                return DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        });
        CompletableFuture.runAsync(() -> {

            Connection connection = connectionThreadLocal.get();
            PreparedStatement preparedStatement = null;
            Preconditions.checkNotNull(connection);
            try {
                connection.setAutoCommit(false);
                String sql = "INSERT INTO `test`.`employee`(`id`, `name`, `gender`, `birthday`, `idCard`, `wedlock`, `nationId`, `nativePlace`, `politicId`, `email`, `phone`, `address`, `departmentId`, `jobLevelId`, `posId`, `engageForm`, `tiptopDegree`, `specialty`, `school`, `beginDate`, `workState`, `workID`, `contractTerm`, `conversionTime`, `notWorkDate`, `beginContract`, `endContract`, `workAge`) VALUES (101002, '江南一点雨', '男', '1990-01-01', '610122199001011256', '已婚', 1, '陕西', 13, 'laowang@qq.com', '18565558897', '深圳市南山区', 5, 9, 29, '劳务合同', '本科', '信息管理与信息系统', '深圳大学', '2018-01-01', '在职', '00000001', 2, '2018-04-01', NULL, '2018-01-01', '2020-01-01', NULL);\n";
                preparedStatement = connection.prepareStatement(sql);
                Preconditions.checkNotNull(preparedStatement);
                preparedStatement.executeUpdate();

                String sql2 = "INSERT INTO `test`.`employee`(`id`, `name`, `gender`, `birthday`, `idCard`, `wedlock`, `nationId`, `nativePlace`, `politicId`, `email`, `phone`, `address`, `departmentId`, `jobLevelId`, `posId`, `engageForm`, `tiptopDegree`, `specialty`, `school`, `beginDate`, `workState`, `workID`, `contractTerm`, `conversionTime`, `notWorkDate`, `beginContract`, `endContract`, `workAge`) VALUES (101000, '江南一点雨', '男', '1990-01-01', '610122199001011256', '已婚', 1, '陕西', 13, 'laowang@qq.com', '18565558897', '深圳市南山区', 5, 9, 29, '劳务合同', '本科', '信息管理与信息系统', '深圳大学', '2018-01-01', '在职', '00000001', 2, '2018-04-01', NULL, '2018-01-01', '2020-01-01', NULL);\n";
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

        }).get();


    }
}
