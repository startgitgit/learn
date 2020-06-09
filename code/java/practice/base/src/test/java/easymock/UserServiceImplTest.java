package easymock;

import model.User;
import org.easymock.EasyMock;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/6/9 21:36
 */
public class UserServiceImplTest {

    @Test
    public void query() throws Exception {
        User expectUser = new User("zhouyanqing",19);
        UserDao mock = EasyMock.createMock(UserDao.class);
        EasyMock.expect(mock.getByName("zhouyanqing")).andReturn(expectUser);
        EasyMock.replay(mock);

        UserServiceImpl userService = new UserServiceImpl();
        userService.setDao(mock);
        User user = userService.query("zhouyanqing");
        assertEquals(expectUser,user);
        EasyMock.verify(mock);

        EasyMock.expect(mock.getByName("zhouyanqing")).andThrow(new RuntimeException());
//        assertEquals(expectUser,user);
        EasyMock.verify(mock);



    }
}