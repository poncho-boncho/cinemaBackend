package com.poncho_boncho.cinema.api.cpntrollers;

import com.poncho_boncho.cinema.api.model.Staff;
import com.poncho_boncho.cinema.client.StaffRestClient;
import com.poncho_boncho.cinema.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    private final StaffRestClient client;
    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService, StaffRestClient client){
        this.staffService = staffService;
        this.client = client;
    }

    @GetMapping("/client")
    List<Staff> findAll(){
        return client.findAll();
    }
    @GetMapping("/client/{id}")
    Staff findById(@PathVariable Integer id){
        return client.findById(id);
    }
    @PostMapping("/client")
    @ResponseStatus(HttpStatus.CREATED)
    Staff create(@RequestBody Staff staff ){
        return client.create(staff);
    }

    @PutMapping("/client/{id}")
    Staff update (@PathVariable Integer id, @RequestBody Staff staff){
        return client.update(id,staff);
    }
    @DeleteMapping("/client/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Integer id){
        client.delete(id);
    }
    @GetMapping("")
    public ResponseEntity<List<Staff>> staff() {
            if (staffService.getAll().isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(staffService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity <Staff> getStaff(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(staffService.getById(id),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity <Staff> add(@RequestBody Staff staff){
        try {
            return new ResponseEntity<>(staffService.addStaff(staff),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        //return staffService.addStaff(staff);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity.HeadersBuilder<?> deleteStaff(@PathVariable("id") int id){
        staffService.delete(id);
        return ResponseEntity.noContent();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable int id, @RequestBody Staff newstaff){
        try {
            Staff update = staffService.updateStaff(id);
            update.setAddress(newstaff.getAddress());
            update.setBirthDay(newstaff.getBirthDay());
            update.setFio(newstaff.getFio());
            update.setOtdel(newstaff.getOtdel());
            update.setPost(newstaff.getPost());

            staffService.savee(update);

            return ResponseEntity.ok(update);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
