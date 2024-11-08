package com.example.schedule.service;

import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;

import java.util.List;

public interface ScheduleService {

   ScheduleResponseDto saveSchedule(ScheduleRequestDto requestDto);
   List<ScheduleResponseDto> findAllSchedule(String name, String updateDate);
   ScheduleResponseDto findScheduleById(Long scheduleId);
   ScheduleResponseDto updateNameAndContent(Long scheduleId, String name, String password,
                                      String content, String createDate, String updateDate);
   void deleteSchedule(Long scheduleId);

}
