package com.isa.pharmacy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.repository.MedicineRepository;

@Repository
public class MedicineService {
	@Autowired
	private MedicineRepository medicineRepository;
	
	public List<Medicine> getAll(){
		return medicineRepository.findAll();
	}
	
	public Medicine create(Medicine medicine) {
		return medicineRepository.save(medicine);
	}

	public void delete(Medicine medicine) {
		medicineRepository.delete(medicine);
		
	}
	

	public Medicine findById(Long id) {
		return medicineRepository.findMedicineById(id);
	}
}
