package dao;

import java.util.List;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/7/5 18:03
 */
public interface PetDao {
    /**
     * 查询所有宠物
     */
    List<Pet> findAllPets() throws Exception;
}
