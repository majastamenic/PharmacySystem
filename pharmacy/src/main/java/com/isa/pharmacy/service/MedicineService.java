package com.isa.pharmacy.service;

import java.util.ArrayList;
import java.util.List;

import com.isa.pharmacy.controller.dto.MedicineLoyaltyDto;
import com.isa.pharmacy.controller.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.repository.MedicineRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MedicineService {
    @Autowired
    private MedicineRepository medicineRepository;
    @Autowired
    private PharmacyService pharmacyService;

    public Medicine create(Medicine medicine) {
        if(medicineRepository.findMedicineById(medicine.getId()) != null)
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        return medicineRepository.save(medicine);
    }

    public void delete(Medicine medicine) {
        medicineRepository.delete(medicine);

    }

    public Medicine findById(Long id) {
        return medicineRepository.findMedicineById(id);
    }

    public List<Medicine> getAll() {
        List<Medicine> medicineList = medicineRepository.findAll();
        if(medicineList == null)
            throw new NotFoundException("Pharmacy system doesnt have any medicine");
        return medicineList;
    }

    public MedicineLoyaltyDto changeLoyalty(MedicineLoyaltyDto medicineLoyaltyDto){
        Medicine medicine = medicineRepository.findMedicineByCode(medicineLoyaltyDto.getCode());
        if(medicine == null)
            throw new NotFoundException("Medicine "+ medicineLoyaltyDto.getName()+" doesnt exist.");
        medicine.setLoyaltyPoints(medicineLoyaltyDto.getLoyaltyPoints());
        medicineRepository.save(medicine);
        return medicineLoyaltyDto;
    }

    public List<Medicine> getMedicinesByNames(List<String> medicinesNames){
        List<Medicine> medicineList = new ArrayList<>();
        List<Medicine> dbMedicines = medicineRepository.findAll();
        for(Medicine medicine: dbMedicines){
            for(String name: medicinesNames){
                if(medicine.getName().equals(name)){
                    medicineList.add(medicine);
                }
            }
        }
        return medicineList;
    }
}
