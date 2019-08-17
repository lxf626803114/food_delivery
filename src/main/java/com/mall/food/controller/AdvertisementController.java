package com.mall.food.controller;

import com.mall.food.mapper.AdvertisementMapper;
import com.mall.food.pojo.Advertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdvertisementController {
    @Autowired
    private AdvertisementMapper advertisementMapper;
    @GetMapping("/advertisements")
    public String findAll(Model model){
        List<Advertisement> advertisements = advertisementMapper.selectAll();
        model.addAttribute("advertisements",advertisements);
        return "advertising_list";
    }

    @GetMapping("/advertisement/{avdId}")
    public String findOne(@PathVariable Integer avdId ,Model model){
        Advertisement advertisement = advertisementMapper.selectAdvertisementById(avdId);
        model.addAttribute("advertisement",advertisement);
        return "advertising";
    }

    @PutMapping("/advertisement")
    public String modify(Advertisement advertisement){
        advertisementMapper.update(advertisement);
        return "redirect:/advertisements";
    }
    //进入添加页面
    @GetMapping("/advertisement")
    public String initAdd(Model model){
        return "advertising";
    }
    //
    @PostMapping("/advertisement")
    public String insert(Advertisement advertisement){
        advertisementMapper.insert(advertisement);
        return "redirect:/advertisements";
    }

    @DeleteMapping("/advertisement/{advId}")
    public String delete(@PathVariable("advId") Integer advId){
        advertisementMapper.deleteAdvertisementById(advId);
        return "redirect:/advertisements";
    }
}
