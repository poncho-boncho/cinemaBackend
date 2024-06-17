package com.poncho_boncho.cinema.service;

import com.poncho_boncho.cinema.api.model.Staff;
import com.poncho_boncho.cinema.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StaffService {
    @Autowired
    private StaffRepository staffRepository;

    public Optional<Staff> getById(Integer id) {
        return staffRepository.findById(id);
    }
}
