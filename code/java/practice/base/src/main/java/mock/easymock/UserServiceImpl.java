package mock.easymock;

import model.User;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/6/9 21:31
 */
public class UserServiceImpl {
    private UserDao dao;

    public User query(String name) throws Exception {
        try {
            return dao.getByName(name);
        } catch (Exception e) {
            throw e;
        }
    }

    public void setDao(UserDao userDao) {
        this.dao = userDao;
    }
}
