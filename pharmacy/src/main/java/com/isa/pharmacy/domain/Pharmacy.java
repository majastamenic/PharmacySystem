package com.isa.pharmacy.domain;

import com.isa.pharmacy.domain.Profile.Pharmacist;
import com.isa.pharmacy.domain.Profile.PharmacyAdmin;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table
public class Pharmacy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String address;
    @OneToMany(fetch = FetchType.EAGER)
    private List<MedicinePharmacy> medicinePharmacy;
    @OneToMany(mappedBy = "pharmacy")
    private List<Pharmacist> pharmacists;
    @OneToMany
    private List<PharmacyAdmin> admins;

    public Pharmacy() {
    }

    public Pharmacy(Long id, String name, String address, List<MedicinePharmacy> medicinePharmacy, List<Pharmacist> pharmacists, List<PharmacyAdmin> admins) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.medicinePharmacy = medicinePharmacy;
        this.pharmacists = pharmacists;
        this.admins= admins;
    }

    public Pharmacy(Long id, String name, String address,
                    List<MedicinePharmacy> medicinePharmaciest) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.medicinePharmacy = medicinePharmacy;
    }

    public List<Pharmacist> getPharmacists() {
        return pharmacists;
    }

    public void setPharmacists(List<Pharmacist> pharmacists) {
        this.pharmacists = pharmacists;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MedicinePharmacy> getMedicinePharmacy() {
        return medicinePharmacy;
    }

    public void setMedicinePharmacy(List<MedicinePharmacy> medicinePharmacy) {
        this.medicinePharmacy = medicinePharmacy;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<MedicinePharmacy> getMedicinePharmacies() {
        return medicinePharmacy;
    }

    public List<PharmacyAdmin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<PharmacyAdmin> admins) {
        this.admins = admins;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((medicinePharmacy == null) ? 0 : medicinePharmacy.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return name;
    }


}
