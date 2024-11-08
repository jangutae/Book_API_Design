package com.example.schedule.dto;

import com.example.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {

    private Long ScheduleId;
    private String name;
    private String password;
    private String content;
    private String createDate;
    private String updateDate;


    public ScheduleResponseDto(Schedule schedule) {
        this.ScheduleId = schedule.getScheduleId();
        this.name = schedule.getName();
        this.password = schedule.getPassword();
        this.content = schedule.getContent();
        this.createDate = schedule.getCreateDate();
        this.updateDate = schedule.getUpdateDate();
    }
}
