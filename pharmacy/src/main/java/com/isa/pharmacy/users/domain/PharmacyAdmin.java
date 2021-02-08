package com.isa.pharmacy.users.domain;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.domain.WorkSchedule;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class PharmacyAdmin implements Serializable {
    private static final long serialVersionUID = 6265056492526032848L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User user;
    @OneToOne
    private Pharmacy pharmacy;
    @OneToMany
    private List<WorkSchedule> schedule;

    public PharmacyAdmin(){}

    public PharmacyAdmin(Long id, User user, Pharmacy pharmacy,List<WorkSchedule> schedule) {
        this.user =user;
        this.id = id;
        this.pharmacy = pharmacy;
        this.schedule = schedule;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public List<WorkSchedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<WorkSchedule> schedule) {
        this.schedule = schedule;
    }
}
