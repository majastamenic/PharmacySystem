package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.WorkScheduleDto;
import com.isa.pharmacy.domain.WorkSchedule;

public class WorkScheduleMapper {
    public static WorkScheduleDto mapWorkScheduleToWorkScheduleDto (WorkSchedule workSchedule){
        WorkScheduleDto workScheduleDto = new WorkScheduleDto();
        workScheduleDto.setId(workSchedule.getId());
        workScheduleDto.setEndDate(workSchedule.getSchedule().getEndDate());
        workScheduleDto.setEndTime(workSchedule.getSchedule().getEndTime());
        workScheduleDto.setStartDate(workSchedule.getSchedule().getStartDate());
        workScheduleDto.setStartTime(workSchedule.getSchedule().getStartTime());
        return workScheduleDto;

    }
}