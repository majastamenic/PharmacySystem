package com.isa.pharmacy.scheduling.service;

import com.isa.pharmacy.controller.dto.VacationScheduleDto;
import com.isa.pharmacy.controller.exception.InvalidActionException;
import com.isa.pharmacy.controller.mapping.VacationScheduleMapper;
import com.isa.pharmacy.scheduling.domain.VacationSchedule;
import com.isa.pharmacy.scheduling.repository.VacationScheduleRepository;
import com.isa.pharmacy.users.domain.Dermatologist;
import com.isa.pharmacy.users.service.DermatologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VacationScheduleService {

    @Autowired
    private VacationScheduleRepository vacationScheduleRepository;
    @Autowired
    private DermatologistService dermatologistService;

    public VacationSchedule save(VacationSchedule vs) {
        if(vs.getStartDate().compareTo(vs.getEndDate()) > 0 )
            throw new InvalidActionException("Start date can't be greater than end date");
        return vacationScheduleRepository.save(vs);
    }

    public List<VacationSchedule> getAll(){ return vacationScheduleRepository.findAll(); }

    public boolean isEmployeeOnVacation(List<VacationSchedule> vacationList, Date eagerDate){
        for(VacationSchedule vacation : vacationList)
            if(isOnVacation(vacation, eagerDate))
                return true;
        return false;
    }

    private boolean isOnVacation(VacationSchedule vacation, Date eagerDate){
        return (vacation.getStartDate().compareTo(eagerDate) <= 0 &&
                vacation.getEndDate().compareTo(eagerDate) >= 0);
    }

    public List<VacationScheduleDto> getVacationScheduleByDermatologist(String email){
        List<VacationScheduleDto> vacationScheduleDtos = new ArrayList<>();
        Dermatologist dermatologist = dermatologistService.findUserByEmail(email);
        if(dermatologist != null){
            List<VacationSchedule> vacationSchedules = dermatologist.getVacationSchedules();
            if(vacationSchedules != null){
                for(VacationSchedule vs: vacationSchedules)
                    vacationScheduleDtos.add(VacationScheduleMapper.mapVacationScheduleToVacationScheduleDto(vs));
            }
        }
        return vacationScheduleDtos;
    }
}
