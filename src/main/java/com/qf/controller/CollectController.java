package com.qf.controller;

import com.qf.pojo.Collect;
import com.qf.pojo.Menu3;
import com.qf.pojo.User;
import com.qf.service.CollectService;
import com.qf.service.MenuService;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/collect")
public class CollectController {
    @Autowired
    private CollectService collectService;
    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;
    @RequestMapping("/add/{id}")
    public int add(@PathVariable("id") Integer id, HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user==null){
            return -1;
        }else{

            User user1 = userService.selectByName(user.getName());
            Menu3 menu3 = menuService.selectC3ById(id);
            Collect collect=new Collect();
            collect.setName(menu3.getName3());
            collect.setM3_id(id);
            collect.setSid(2);
            collect.setUid(user1.getId());
            collect.setUrl(menu3.getPic());
            Collect collect1 = collectService.selectByUidAndM3Id(collect);
            if (collect1==null){
                return collectService.add(collect);
            }

        }
        return -1;
    }
    @RequestMapping("/findall/{sid}")
    public List<Collect> findall(@PathVariable("sid") Integer sid,HttpSession session){
        User user = (User) session.getAttribute("user");
       /* System.out.println(user+"====="+sid);*/
        if (user!=null){
            User user1 = userService.selectByName(user.getName());
            /*System.out.println(user1+"///////////////"+sid);*/
            return collectService.findall(user1.getId(),sid);
        }
        return null;
    }

}
