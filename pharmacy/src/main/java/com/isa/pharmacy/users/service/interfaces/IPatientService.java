package com.isa.pharmacy.users.service.interfaces;

import com.isa.pharmacy.users.domain.Patient;

import java.util.Date;
import java.util.List;

public interface IPatientService {
     Patient registration(Patient patient);

     String activateProfile(String email, String code);

     void updateAllergies(String patientEmail, List<String> allergies);

     Patient getPatient(String email);

     List<Patient> getAllPatients();

     void deletePatient(long id);

     Patient save(Patient p);

     boolean patientIsFree(Patient patient, Date start, Date end);

     String getPatientEmailByExamination(Long id);

     List<Patient> findPatientByName(String name, String surname);
}
