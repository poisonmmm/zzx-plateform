package com.association.platform.controller;


import com.association.platform.entity.Materialsupply;
import com.association.platform.service.impl.MaterialsupplyServiceImpl;
import com.association.platform.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author luming
 * @since 2021-02-22
 */
@RestController
@RequestMapping("/materialsupply")
public class MaterialsupplyController {

    @SuppressWarnings("All")
    @Autowired
    MaterialsupplyServiceImpl materialsupplyService;

    @PostMapping("/add")
    public Result add(Materialsupply materialsupply){
        return materialsupplyService.add(materialsupply);
    }

    @PostMapping("/delete")
    public Result delete(Materialsupply materialsupply){
        return materialsupplyService.delete(materialsupply);
    }

    @GetMapping("/showAll")
    public Result showAll(){
        return materialsupplyService.showAll();
    }

    @PostMapping("/searchByName")
    public Result searchByName(String key){
        return materialsupplyService.searchByName(key);
    }
}
