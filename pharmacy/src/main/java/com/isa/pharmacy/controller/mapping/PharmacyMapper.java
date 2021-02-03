package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.PharmacyDto;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.controller.dto.GetAllPharmaciesDto;
import com.isa.pharmacy.domain.Profile.PharmacyAdmin;

import java.util.ArrayList;

public class PharmacyMapper {
    public static Pharmacy mapPharmacyDtoToPharmacy(PharmacyDto pharmacyDto){
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setName(pharmacyDto.getName());
        pharmacy.setAddress(pharmacyDto.getAddress());
        pharmacy.setMedicinePharmacy(null);
        pharmacy.setPharmacists(null);
        pharmacy.setAdmins(null);
        return pharmacy;
    }

    public static PharmacyDto mapPharmacyToPharmacyDto(Pharmacy pharmacy) {
        PharmacyDto pharmacyDto = new PharmacyDto();
        pharmacyDto.setAddress(pharmacy.getAddress());
        return pharmacyDto;
    }

    public static GetAllPharmaciesDto mapPharmacyToGetAllPharmaciesDto(Pharmacy pharmacy) {
        GetAllPharmaciesDto dto = new GetAllPharmaciesDto();
        dto.setId(pharmacy.getId());
        dto.setName(pharmacy.getName());
        dto.setAddress(pharmacy.getAddress());
        dto.setPharmacists(pharmacy.getPharmacists());
        dto.setAdmins(new ArrayList<>());
        for (PharmacyAdmin pharmacyAdmin:pharmacy.getAdmins()) {
            dto.getAdmins().add(PharmacyAdminMapper.mapPharmacyAdminToGetAllPharmaciesPharmacyAdminDto(pharmacyAdmin));
        }
        return dto;
    }
}