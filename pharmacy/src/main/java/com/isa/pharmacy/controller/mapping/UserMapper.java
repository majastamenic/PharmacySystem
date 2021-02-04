package com.isa.pharmacy.controller.mapping;


import com.isa.pharmacy.controller.dto.LoginDto;
import com.isa.pharmacy.controller.dto.RegistrationDto;
import com.isa.pharmacy.controller.dto.UserDto;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.domain.Profile.*;
import com.isa.pharmacy.domain.enums.Role;
import net.bytebuddy.utility.RandomString;

public class UserMapper {

    public static Patient mapRegistrationDtoToPatient(RegistrationDto registrationDto) {
        Patient patient = new Patient();
        User user = new User();
        if(registrationDto.getPassword().equals(registrationDto.getPasswordAgain()))
            user.setPassword(registrationDto.getPassword());
        else
            throw new NotFoundException(String.format("Wrong password"));
        user.setEmail(registrationDto.getEmail());
        user.setName(registrationDto.getName());
        user.setSurname(registrationDto.getSurname());
        user.setAddress(registrationDto.getAddress());
        user.setCity(registrationDto.getCity());
        user.setCountry(registrationDto.getCountry());
        user.setPhone(registrationDto.getPhone());
        user.setActive(false);
        user.setRole(Role.PATIENT);

        patient.setVerificationCode(RandomString.make(10));
        patient.setUser(user);
        return patient;
    }

    public static User mapLoginDtoToUser(LoginDto loginDto) {
        User user = new User();
        user.setPassword(loginDto.getPassword());
        user.setEmail(loginDto.getEmail());
        return user;
    }

    public static Dermatologist mapRegistrationDtoToDermatologist(RegistrationDto registrationDto) {
        Dermatologist dermatologist = new Dermatologist();
        dermatologist.setUser(mapRegistrationDtoToUser(registrationDto));
        return dermatologist;
    }


    public static RegistrationDto mapUserToRegistrationDto(User user){
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setEmail(user.getEmail());
        registrationDto.setPassword(user.getPassword());
        registrationDto.setCity(user.getCity());
        registrationDto.setAddress(user.getAddress());
        registrationDto.setCountry(user.getCountry());
        registrationDto.setPhone(user.getPhone());
        return registrationDto;
    }

    public static User mapRegistrationDtoToUser(RegistrationDto registrationDto){
        User user = new User();
        user.setPassword(RandomString.make(10));
        user.setEmail(registrationDto.getEmail());
        user.setName(registrationDto.getName());
        user.setSurname(registrationDto.getSurname());
        user.setAddress(registrationDto.getAddress());
        user.setCity(registrationDto.getCity());
        user.setCountry(registrationDto.getCountry());
        user.setPhone(registrationDto.getPhone());
        user.setActive(false);
        user.setRole(registrationDto.getRole());
        return user;
    }

    public static Supplier mapRegistrationDtoToSupplier(RegistrationDto registrationDto){
        Supplier supplier = new Supplier();
        supplier.setUser(mapRegistrationDtoToUser(registrationDto));
        return supplier;
    }

    public static Admin mapRegistrationDtoToAdmin(RegistrationDto registrationDto){
        Admin admin = new Admin();
        admin.setUser(mapRegistrationDtoToUser(registrationDto));
        return admin;
    }

    public static User mapUserDtoToUser(UserDto userDto){
        User user = new User();
        if(userDto.getPassword().equals(userDto.getPasswordAgain()))
            user.setPassword(userDto.getPassword());
        else
            throw new NotFoundException(String.format("Wrong password"));
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setAddress(userDto.getAddress());
        user.setCity(userDto.getCity());
        user.setCountry(userDto.getCountry());
        user.setPhone(userDto.getPhone());
        user.setActive(userDto.getActive());
        user.setRole(userDto.getRole());

        return user;
    }
}
