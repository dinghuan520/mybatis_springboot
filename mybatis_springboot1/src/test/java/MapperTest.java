import cn.itcast.Application;
import cn.itcast.domain.User;
import cn.itcast.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

//springboot整合until的单元测试
// SpringRunner继承自SpringJUnit4ClassRunner，使用哪一个Spring提供的测试测试引擎都可以
@RunWith(SpringRunner.class)
//@SpringBootTest的属性指定的是引导类的字节码对象(启动类)
@SpringBootTest(classes = Application.class)
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {

        List<User> users = userMapper.queryUserList();

        System.out.println(users);

    }

}
