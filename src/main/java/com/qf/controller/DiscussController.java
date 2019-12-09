package com.qf.controller;

import com.qf.pojo.*;
import com.qf.service.DiscussService;
import com.qf.service.MenuService;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/discuss")

public class DiscussController {
    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private DiscussService discussService;
    @RequestMapping("/add/{text}/{m3_id}")
    public int add(@PathVariable("text") String text, @PathVariable("m3_id") Integer m3_id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            User user1 = userService.selectByName(user.getName());
            Discuss discuss = new Discuss();
            discuss.setM3_id(m3_id);
            discuss.setUid(user1.getId());

            discuss.setText(text);
            discuss.setTime(new Date());
            return discussService.add(discuss);
        }
        return -1;
    }
    @RequestMapping("/findall/{id}")
    public Discuss_User findall(@PathVariable("id") Integer id){
        Discuss_User discuss_user=new Discuss_User();
        List<Discuss> discusses = discussService.selectById(id);
        discuss_user.setRows(discussService.getRows(id));
        discuss_user.setList(discusses);
        return discuss_user;
    }
}


