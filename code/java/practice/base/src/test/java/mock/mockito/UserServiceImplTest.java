package mock.mockito;

import mock.UserDao;
import mock.UserServiceImpl;
import model.User;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/6/9 21:36
 */
public class UserServiceImplTest {
    private UserDao userDao;
    private UserServiceImpl userService;
    private User expectUser = new User("zhouyanqing", 19);

    @Before
    public void setUp() throws Exception {
        userDao = mock(UserDao.class);
        when(userDao.getByName("zhouyanqing")).thenReturn(expectUser);
        userService = new UserServiceImpl();
        userService.setDao(userDao);
    }


    @Test
    public void query() throws Exception {
        User user = userService.query("zhouyanqing");
        assertEquals(expectUser, user);
        //验证是否执行过一次getByName("zhouyanqing")
        verify(userDao, times(1)).getByName(eq("zhouyanqing"));

    }

    @Test
    public void queryNotFound() throws Exception {
        User user = userService.query("zhouyanqing1");
        assertNotEquals(expectUser, user);


    }
}