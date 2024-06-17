package com.poncho_boncho.cinema.api.cpntrollers;

import com.poncho_boncho.cinema.api.model.Staff;
import com.poncho_boncho.cinema.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class StaffController {

    private StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService){
        this.staffService = staffService;
    }

    @GetMapping("/staff")
    public Optional<Staff> getStaff(@RequestParam Integer id){
        return staffService.getById(id);
    }
}
