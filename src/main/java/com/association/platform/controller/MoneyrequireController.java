package com.association.platform.controller;


import com.association.platform.entity.Materialsupply;
import com.association.platform.entity.Moneyrequire;
import com.association.platform.service.impl.MaterialsupplyServiceImpl;
import com.association.platform.service.impl.MoneyrequireServiceImpl;
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
@RequestMapping("/moneyrequire")
public class MoneyrequireController {
    @SuppressWarnings("All")
    @Autowired
    MoneyrequireServiceImpl moneyrequireService;

    @PostMapping("/add")
    public Result add(Moneyrequire moneyrequire){
        return moneyrequireService.add(moneyrequire);
    }

    @PostMapping("/delete")
    public Result delete(Moneyrequire moneyrequire){
        return moneyrequireService.delete(moneyrequire);
    }

    @GetMapping("/showAll")
    public Result showAll(){
        return moneyrequireService.showAll();
    }

    @PostMapping("/searchByReceiveName")
    public Result searchByReceiveName(String key){
        return moneyrequireService.searchByReceiveName(key);
    }
}
