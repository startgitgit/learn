package mock;

import model.User;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/6/9 21:31
 */
public class UserServiceImpl {
    private UserDao dao;

    public User query(String name) {
        return dao.getByName(name);
    }

    public void setDao(UserDao userDao) {
        this.dao = userDao;
    }
}
