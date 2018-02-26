package net.cosd.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

// 声明一个控制器
@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping(method = RequestMethod.GET)
//    @ResponseBody
//    public Object home() {
//        HashMap<String,String> map=new HashMap<>();
//        map.put("name", "Aike");
//        map.put("sex", "男");
//        map.put("age", "25");
//        System.out.println("+++++++++++++++++++++home+++++++++++++++");
//        System.out.println(map.toString() + "+++++++++++++++++++++home+++++++++++++++");
//        return map;
    public String home() {
        HashMap<String,String> map=new HashMap<>();
        map.put("name", "Aike");
        map.put("sex", "男");
        map.put("age", "25");
        System.out.println("+++++++++++++++++++++home+++++++++++++++");
        System.out.println(map.toString() + "+++++++++++++++++++++home+++++++++++++++");
        return "success";
    }
}
