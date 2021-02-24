package com.association.platform.controller;


import com.association.platform.entity.Moneyrequire;
import com.association.platform.entity.Servicesupply;
import com.association.platform.service.impl.MoneyrequireServiceImpl;
import com.association.platform.service.impl.ServicesupplyServiceImpl;
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
@RequestMapping("/servicesupply")
public class ServicesupplyController {
    @SuppressWarnings("All")
    @Autowired
    ServicesupplyServiceImpl servicesupplyService;

    @PostMapping("/add")
    public Result add(Servicesupply servicesupply){
        return servicesupplyService.add(servicesupply);
    }

    @PostMapping("/delete")
    public Result delete(Servicesupply servicesupply){
        return servicesupplyService.delete(servicesupply);
    }

    @GetMapping("/showAll")
    public Result showAll(){
        return servicesupplyService.showAll();
    }

    @PostMapping("/searchByCity")
    public Result searchByCity(String key){
        return servicesupplyService.searchByCity(key);
    }

    @PostMapping("/searchBySupplytype")
    public Result searchBySupplytype(String key){
        return servicesupplyService.searchBySupplytype(key);
    }

}
