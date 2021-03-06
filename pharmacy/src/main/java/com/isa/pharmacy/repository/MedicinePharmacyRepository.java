package com.isa.pharmacy.repository;


import com.isa.pharmacy.domain.MedicinePharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicinePharmacyRepository extends JpaRepository<MedicinePharmacy,Long> {

    MedicinePharmacy save(MedicinePharmacy medicine);

    MedicinePharmacy findMedicinePharmacyByAndPharmacy_NameAndMedicine_Name(String pharmacyName, String medicineName);

    List<MedicinePharmacy> findAll();

    List<MedicinePharmacy> findMedicinePharmacyByPharmacy_id(Long id);

    List<MedicinePharmacy> findMedicinePharmaciesByMedicine_Name(String medicineName);

    MedicinePharmacy findMedicinePharmacyById(Long id);

}
