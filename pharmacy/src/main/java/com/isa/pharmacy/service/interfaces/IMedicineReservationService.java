package com.isa.pharmacy.service.interfaces;

import com.isa.pharmacy.domain.MedicineReservation;

import java.util.List;

public interface IMedicineReservationService {

    List<MedicineReservation> getAllReservationsByPatient(String patientEmail);

    MedicineReservation createReservation(MedicineReservation reservation);

    boolean acceptReservation(String pharmacyName, Long code);

    void cancelReservation(long reservationId);
}
