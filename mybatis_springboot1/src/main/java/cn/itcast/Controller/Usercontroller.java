package cn.itcast.Controller;



import cn.itcast.domain.User;
import cn.itcast.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class Usercontroller {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/user")
    @ResponseBody
    public List<User> queryUserList(){

        List<User> users = userMapper.queryUserList();

        return users;

    }



}
