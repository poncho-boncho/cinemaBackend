package com.poncho_boncho.cinema.service;

import com.poncho_boncho.cinema.api.model.Staff;
import com.poncho_boncho.cinema.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {
    @Autowired
    private StaffRepository staffRepository;

    public Staff getById(Integer id) {
        return staffRepository.findById(id).orElseThrow();
    }

    public List<Staff> getAll() {
        return staffRepository.findAll();
    }

    public Staff addStaff(Staff staff) {
        System.out.println("cccccccc");
        return staffRepository.saveAndFlush(staff);
    }

    public void delete(int id) {
        staffRepository.deleteById(id);
    }
    public Staff updateStaff (int id){
        return staffRepository.findById(id).orElseThrow();
    }
    public void savee(Staff staff){
        staffRepository.save(staff);
    }
}
