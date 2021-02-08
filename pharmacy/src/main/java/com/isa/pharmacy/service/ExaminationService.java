package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.dto.ExamDermatologistDto;
import com.isa.pharmacy.controller.exception.InvalidActionException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.mapping.ExaminationMapper;
import com.isa.pharmacy.domain.Examination;
import com.isa.pharmacy.domain.Prescription;
import com.isa.pharmacy.repository.ExaminationRepository;
import com.isa.pharmacy.users.controller.dto.PatientDto;
import com.isa.pharmacy.users.controller.mapping.PatientMapper;
import com.isa.pharmacy.users.domain.Dermatologist;
import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.users.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ExaminationService {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");

    @Autowired
    private ExaminationRepository examinationRepository;
    @Autowired
    private PatientService patientService;
    @Autowired
    private EmailService emailService;


    public List<Examination> getAllFreeExaminationTerms(){
        List<Examination> freeExaminations = new ArrayList<>();
        for(Examination exam : examinationRepository.findAll())
            if(exam.getPatient() == null && exam.getSchedule().getStartDate().after(Calendar.getInstance().getTime()))
                freeExaminations.add(exam);
        return freeExaminations;
    }

    public List<Examination> getFreeExaminationTermsByPharmacy(String pharmacyName){
        List<Examination> freeExaminations = new ArrayList<>();
        for(Examination exam : examinationRepository.findAll())
            if(exam.getPharmacy().getName().equals(pharmacyName) &&
               exam.getPatient() == null &&
               exam.getSchedule().getStartDate().after(Calendar.getInstance().getTime()))
                freeExaminations.add(exam);
        return freeExaminations;
    }

    public List<Examination> getExaminationByPatient(String email){
        return examinationRepository.findByPatient(patientService.getPatient(email));
    }

    public void scheduleExamination(String patientEmail, Long examinationId){
        Examination examination = examinationRepository.findExaminationById(examinationId);
        if(examination.getPatient() != null || examination.getSchedule().getStartDate().before(Calendar.getInstance().getTime()))
            throw new InvalidActionException("Examination cannot be scheduled!");
        examination.setPatient(patientService.getPatient(patientEmail));
        Examination scheduledExam = examinationRepository.save(examination);
        emailService.successfulExamSchedule(scheduledExam);
    }

    public void cancelExamination(Long examinationId){
        Examination examination = examinationRepository.findExaminationById(examinationId);
        Calendar currDateTime = Calendar.getInstance();
        currDateTime.add(Calendar.HOUR, 24);
        if(examination.getSchedule().getStartDate().compareTo(currDateTime.getTime()) <= 0)
//            if(currDateTime.getTime().after(examination.getSchedule().getStartTime()))  Treba porediti i sate/minute
                throw new InvalidActionException("Examination can't be canceled!");
        Examination newExamination = new Examination(examination.getDermatologist(),
                examination.getPharmacy(), examination.getSchedule(), examination.getPrice(),
                examination.getLoyaltyGroup());
        examinationRepository.delete(examination);
        examinationRepository.save(newExamination);
    }

    public List<ExamDermatologistDto> getAllByDermatologist(Dermatologist dermatologist) {
        List<Examination> examinations = examinationRepository.findByDermatologist(dermatologist);
        List<ExamDermatologistDto> examDermatologistDtos = new ArrayList<>();
        if(examinations.isEmpty() == false){
            for(Examination e : examinations){
                if(e.getPrescription() == null){
                    e.setPrescription(new Prescription());
                }
                if(e.getPatient() != null){
                    PatientDto patientDto = PatientMapper.mapPatientToPatientDto(e.getPatient());
                    ExamDermatologistDto examDermatologistDto = ExaminationMapper.mapExaminationToExaminationDto(e, patientDto);
                    examDermatologistDtos.add(examDermatologistDto);
                }
            }
        }
        return examDermatologistDtos;
    }

    public ExamDermatologistDto getById(long id) {
        // provera vremena
        Examination examination = examinationRepository.findExaminationById(id);
        if(examination == null)
            throw new NotFoundException("Examination is not found.");
        if (examination.getPatient() != null && examination.getDermatologist() != null) {
            PatientDto patientDto = PatientMapper.mapPatientToPatientDto(examination.getPatient());
            return ExaminationMapper.mapExaminationToExaminationDto(examination, patientDto);
        } else if (examination.getPatient() == null || examination.getDermatologist() == null)
            throw new InvalidActionException("Examination with that id exist but no one scheduled it.");
        throw new NotFoundException("Examination not found");
    }

    public List<String> getDermatologistNameByPatient(Patient patient){
        String dermatologistName;
        List<String> dermatologistNames = new ArrayList<>();
        List<Examination> examinationList = examinationRepository.findByPatient(patient);
        for(Examination examination: examinationList){
            if(examination.getPatientCame()){
                dermatologistName = examination.getDermatologist().getUser().getRole().toString() + ": " + examination.getDermatologist().getUser().getName()+" "+ examination.getDermatologist().getUser().getSurname();
                dermatologistNames.add(dermatologistName);
            }
        }
        return dermatologistNames;
    }
}
