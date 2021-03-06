package com.isa.pharmacy.users.controller.mapping;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.domain.enums.Role;
import com.isa.pharmacy.users.controller.dto.CreatePhAdminDto;
import com.isa.pharmacy.users.controller.dto.PharmacyAdminDto;
import com.isa.pharmacy.users.domain.PharmacyAdmin;
import com.isa.pharmacy.users.domain.User;
import net.bytebuddy.utility.RandomString;

public class PharmacyAdminMapper {

    public static PharmacyAdmin mapPharmacyAdminDtoToPharmacyAdmin(CreatePhAdminDto createPhAdminDto, Pharmacy pharmacy){
        PharmacyAdmin pharmacyAdmin = new PharmacyAdmin();
        User user = new User();
        user.setEmail(createPhAdminDto.getEmail());
        user.setPassword(RandomString.make(10));
        user.setCountry(createPhAdminDto.getCountry());
        user.setCity(createPhAdminDto.getCity());
        user.setAddress(createPhAdminDto.getAddress());
        user.setPhone(createPhAdminDto.getPhone());
        user.setName(createPhAdminDto.getName());
        user.setSurname(createPhAdminDto.getSurname());
        user.setRole(createPhAdminDto.getRole());
        user.setActive(false);
        pharmacyAdmin.setUser(user);
        pharmacyAdmin.setPharmacy(pharmacy);
        return pharmacyAdmin;
    }

    public static CreatePhAdminDto mapPharmacyAdminToPharmacyAdminDto(PharmacyAdmin pharmacyAdmin) {
        CreatePhAdminDto createPhAdminDto = new CreatePhAdminDto();
        createPhAdminDto.setPharmacyId(pharmacyAdmin.getPharmacy().getId());
        createPhAdminDto.setEmail(pharmacyAdmin.getUser().getEmail());
        createPhAdminDto.setCountry(pharmacyAdmin.getUser().getCountry());
        createPhAdminDto.setCity(pharmacyAdmin.getUser().getCity());
        createPhAdminDto.setAddress(pharmacyAdmin.getUser().getAddress());
        createPhAdminDto.setName(pharmacyAdmin.getUser().getName());
        createPhAdminDto.setSurname(pharmacyAdmin.getUser().getSurname());
        createPhAdminDto.setActive(pharmacyAdmin.getUser().getActive());
        return createPhAdminDto;
    }

    public static PharmacyAdminDto mapPharmacyAdminnToPharmacyAdminDto(PharmacyAdmin pharmacyAdmin){
        PharmacyAdminDto pharmacyAdminDto = new PharmacyAdminDto();
        pharmacyAdminDto.setPharmacyName(pharmacyAdmin.getPharmacy().getName());
        pharmacyAdminDto.setUser(pharmacyAdmin.getUser());
        return pharmacyAdminDto;
    }

    public static PharmacyAdmin mapPharmacyAdminDTOToPharmacyAdmin(PharmacyAdminDto pharmacyAdminDto, Pharmacy pharmacy){
        PharmacyAdmin pharmacyAdmin = new PharmacyAdmin();
        pharmacyAdmin.setPharmacy(pharmacy);
        pharmacyAdmin.setUser(pharmacyAdminDto.getUser());
        return pharmacyAdmin;
    }
}
