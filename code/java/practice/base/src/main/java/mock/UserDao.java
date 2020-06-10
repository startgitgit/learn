package mock;

import model.User;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/6/9 21:32
 */
public interface UserDao {
    User getByName(String name);
}
