package com.isa.pharmacy.service.interfaces;

import com.isa.pharmacy.domain.Complaint;
import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.domain.EPrescription;
import com.isa.pharmacy.domain.Examination;
import com.isa.pharmacy.rabbitmq.ActionsAndBenefits;
import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.users.domain.User;
import org.springframework.mail.MailException;
import org.springframework.scheduling.annotation.Async;

public interface IEmailService {
     @Async
     void activationEmail(User user) throws MailException;

     @Async
     void verificationEmailPatient(Patient patient) throws MailException;

     @Async
     void successfulExamSchedule(Examination examiantion) throws  MailException;

     @Async
     void successfulCounselingSchedule(Counseling counseling) throws  MailException;

     @Async
     void sendApiKey(String hospitalEmail, String apiKey) throws MailException;

     @Async
     void notifyHospitalSftp(String hospitalEmail, String patientName) throws MailException;

     @Async
     void notifyPharmacySftp(String pharmacyEmail) throws MailException;
     @Async
     void notifyAdminPharmacyAboutMedicine(String adminEmail, String pharmacyAdmin, String medName)throws MailException;
     @Async
     void sendAction(ActionsAndBenefits action, String email, String phName) throws MailException;
     @Async
     void sendEmailEPrescription(EPrescription ePrescription) throws MailException;
     @Async
     void sendComplaintResponse(Complaint complaint) throws MailException;
}