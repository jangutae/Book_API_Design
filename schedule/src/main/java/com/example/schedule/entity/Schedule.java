package com.example.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Schedule {

    private Long scheduleId;
    private String name;
    private String password;
    private String content;
    private String createDate;
    private String updateDate;

    public Schedule(String name, String password, String content, String createDate, String updateDate) {
        this.name = name;
        this.password = password;
        this.content = content;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

}
