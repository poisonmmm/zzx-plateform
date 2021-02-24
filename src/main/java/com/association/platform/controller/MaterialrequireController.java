package com.association.platform.controller;


import com.association.platform.entity.Materialrequire;
import com.association.platform.service.impl.MaterialrequireServiceImpl;
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
@RequestMapping("/materialrequire")
public class MaterialrequireController {
    @SuppressWarnings("All")
    @Autowired
    MaterialrequireServiceImpl materialrequireService;

    @PostMapping("/add")
    public Result add(Materialrequire materialrequire){
        return materialrequireService.insert(materialrequire);
    }

    @GetMapping("/showAll")
    public Result showAll(){
        return materialrequireService.showAll();
    }

    @PostMapping("/delete")
    public Result delete(Materialrequire materialrequire){
        return materialrequireService.delete(materialrequire);
    }

    @PostMapping("/searchByReceiveName")
    public Result searchByReceiveName(String key){
        return materialrequireService.searchByReceiveName(key);
    }
}
