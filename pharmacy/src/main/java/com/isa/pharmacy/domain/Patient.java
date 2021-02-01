package com.isa.pharmacy.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Patient implements Serializable {
    private static final long serialVersionUID = -6792194469986787879L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private User user;
    @OneToMany
    private List<Medicine> allergicMedicines;
    @OneToMany
    private List<Counseling> counselings;
    @OneToMany
    private List<Examination> examinations;

    public Patient(){}

    public Patient(User user, List<Medicine> medicines, List<Counseling> counselings, List<Examination> examinations) {
        this.user = user;
        this.allergicMedicines = medicines;
        this.counselings = counselings;
        this.examinations = examinations;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Medicine> getAllergicMedicines() {
        return allergicMedicines;
    }

    public void setAllergicMedicines(List<Medicine> allergicMedicines) {
        this.allergicMedicines = allergicMedicines;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Counseling> getCounselings() {
        return counselings;
    }

    public void setCounselings(List<Counseling> counselings) {
        this.counselings = counselings;
    }

    public List<Examination> getExaminations() {
        return examinations;
    }

    public void setExaminations(List<Examination> examinations) {
        this.examinations = examinations;
    }

    public void addAllergy(Medicine medicine){
        if(!allergicMedicines.contains(medicine))
            allergicMedicines.add(medicine);
    }
}
