package com.poncho_boncho.cinema.api.model;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "fio")
    private String fio;

    @Column(name = "address")
    private String address;

    @Column(name = "otdel")
    private String otdel;

    @Column(name = "birth_day")
    private String birthDay;

    @Column(name = "post")
    private String post;

/*    @OneToMany(orphanRemoval = true, cascade = CascadeType.PERSIST ,fetch = FetchType.LAZY, mappedBy = "staff")
    private List<Deportment> deportments;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "staff")
    private List<Organisation> organisations;*/

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOtdel() {
        return otdel;
    }

    public void setOtdel(String otdel) {
        this.otdel = otdel;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}