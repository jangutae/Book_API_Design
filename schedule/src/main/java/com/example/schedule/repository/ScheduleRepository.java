package com.example.schedule.repository;

import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {

    ScheduleResponseDto saveSchedule(Schedule schedule);
    List<ScheduleResponseDto> findAllSchedule(String name, String updateDate);
    Optional<Schedule> findScheduleById(Long scheduleId);
    int updateNameAndContent(Long scheduleId, String name, String content);
    int deleteSchedule(Long scheduleId);
}
