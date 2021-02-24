package com.association.platform.controller;


import com.association.platform.entity.Volunteer;
import com.association.platform.service.impl.VolunteerServiceImpl;
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
@RequestMapping("/volunteer")
public class VolunteerController {
    @Autowired
    VolunteerServiceImpl volunteerService;

    @PostMapping("/add")
    public Result add(Volunteer volunteer){
        return volunteerService.addVolunteer(volunteer);
    }

    @GetMapping("/showAll")
    public Result showAll(){
        return volunteerService.showAllVolunteer();
    }

    @PostMapping("/delete")
    public Result delete(Volunteer volunteer){
        return volunteerService.deleteVolunteer(volunteer);
    }
    @PostMapping("/searchByName")
    public Result searchByName(String key){
        return volunteerService.searchByName(key);
    }




}
