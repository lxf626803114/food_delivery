package com.mall.food.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.food.mapper.CommodityTypeMapper;
import com.mall.food.pojo.CommodityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CommodityTypeController {
    @Autowired
    private CommodityTypeMapper commodityTypeMapper;
    @GetMapping("/commodityTypes")
    public String findAll(Model model ,@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<CommodityType> commodityTypes = commodityTypeMapper.selectAll();
        PageInfo<CommodityType> page = new PageInfo<>(commodityTypes);
        model.addAttribute("page",page);
        return "commodityTypes_list";
    }

    @GetMapping("/commodityType/{type}")
    public String findOne(@PathVariable String type , Model model){
        CommodityType commodityType = commodityTypeMapper.selectByType(type);
        model.addAttribute("commodityType",commodityType);
        return "commodityTypes";
    }

    @GetMapping("/commodity")
    public String fuzzy(String describes,Model model,@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum){
        List<CommodityType> commodityTypes = null;
        if (!describes.equals("")&&describes!=""){
            PageHelper.startPage(pageNum,5);
             commodityTypes = commodityTypeMapper.selectByDescribes(describes);
        }else {
            PageHelper.startPage(pageNum,5);
             commodityTypes = commodityTypeMapper.selectAll();
        }
        PageInfo<CommodityType> page = new PageInfo<>(commodityTypes);
        model.addAttribute("page",page);
        model.addAttribute("describes",describes);
        return "commodityTypes_list";
    }

    @PutMapping("/commodityType")
    public String modify(CommodityType commodityType){
        commodityTypeMapper.update(commodityType);
        return "redirect:/commodityTypes";
    }
    //进入添加页面
    @GetMapping("/commodityType")
    public String initAdd(Model model){
        return "commodityTypes";
    }
    //
    @PostMapping("/commodityType")
    public String insert(CommodityType commodityType){
        commodityTypeMapper.insert(commodityType);
        return "redirect:/commodityTypes";
    }

    @DeleteMapping("/commodityType/{type}")
    public String delete(@PathVariable("type") String type){
        commodityTypeMapper.deleteByType(type);
        return "redirect:/commodityTypes";
    }
}
