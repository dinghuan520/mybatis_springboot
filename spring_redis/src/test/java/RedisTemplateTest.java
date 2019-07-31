import cn.itcast.SpringbootJpaApplication;
import cn.itcast.domain.User;
import cn.itcast.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


//springboot与reids整合
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootJpaApplication.class)
public class RedisTemplateTest {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private RedisTemplate redisTemplate;


    //缓存测试类
    @Test
    public void test() throws JsonProcessingException {

        //从redis中获得缓存数据
        String userList = (String) redisTemplate.boundValueOps("user.findAll").get();

        //如果redis中没有数据的话
        if (userList==null){
            //缓存中的数据为null ，就从数据库读取数据
            List<User> list = userRepository.findAll();

            //转换为json格式的字符串
            ObjectMapper mapper = new ObjectMapper();

            //再将list转换为string格式
             userList = mapper.writeValueAsString(list);

            //将数据存储到redis中，下次查询的话直接从redis中获得数据，不用再查询数据库
            redisTemplate.boundValueOps("user.findAll").set(userList);
            System.out.println("从数据库中获得数据");
        }else {
            //不为null
            System.out.println("从redis中获取数据");

        }
    }


}
