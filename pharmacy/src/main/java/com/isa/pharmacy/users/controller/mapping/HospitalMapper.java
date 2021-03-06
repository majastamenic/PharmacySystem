package com.isa.pharmacy.users.controller.mapping;


import com.isa.pharmacy.users.controller.dto.HospitalManagerRegistrationDto;
import com.isa.pharmacy.users.domain.Hospital;

public class HospitalMapper {

    public static Hospital mapRegistrationDtoToHospital(HospitalManagerRegistrationDto hospitalDto, Hospital hospital) {
        if (hospital == null) {
            hospital = new Hospital();
            hospital.setName(hospitalDto.getName());
            hospital.setEmail(hospitalDto.getEmail());
        }
        return hospital;
    }
}
