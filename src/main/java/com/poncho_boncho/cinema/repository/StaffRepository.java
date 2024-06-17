package com.poncho_boncho.cinema.repository;

import com.poncho_boncho.cinema.api.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
}
