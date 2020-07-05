package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/7/5 18:04
 */
public class PetDaoImpl extends BaseDao implements PetDao {
    /**
     * 查询所有宠物
     */
    @Override
    public List<Pet> findAllPets() throws Exception {
        Connection conn = BaseDao.getConnection();
        String sql = "select * from pet";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Pet> petList = new ArrayList<>();
        while (rs.next()) {
            Pet pet = new Pet(
                    rs.getInt("id"),
                    rs.getInt("owner_id"),
                    rs.getInt("store_id"),
                    rs.getString("name"),
                    rs.getString("type_name"),
                    rs.getInt("health"),
                    rs.getInt("love"),
                    rs.getDate("birthday")
            );
            petList.add(pet);
        }
        BaseDao.closeAll(conn, stmt, rs);
        return petList;
    }
}
