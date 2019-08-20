package com.mall.food.controller;

import com.mall.food.pojo.ServiceMessage;
import com.mall.food.service.ServiceMessageSeivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/seiviceMessage/")
public class ServiceMessageController {
    @Autowired
    private ServiceMessageSeivice serviceMessageSeivice;
    @GetMapping("all")
    public String getAll(Model model){
        List<ServiceMessage> list=serviceMessageSeivice.selectAll();
        model.addAttribute("seiviceMessage",list);
        return "message";
    }
    //查出单条信息，点击回复进行回复
    @GetMapping("huifu/{serviceId}")
    public String selectOne(Model model,@PathVariable Integer serviceId){
        ServiceMessage serviceMessage=serviceMessageSeivice.selectOne(serviceId);
        model.addAttribute("seiviceMessage",serviceMessage);
        return  "messageHuiFu";
    }
    //进入添加页面
    @GetMapping("huifu")
    public String init(){
        return "messageHuiFu";
    }
    //回复完后新增一条信息，重定向到查询列表
    @PostMapping("huifu")
    public String insert(ServiceMessage serviceMessage){
        serviceMessageSeivice.insert(serviceMessage);
        return "redirect:/seiviceMessage/all";
    }

}
