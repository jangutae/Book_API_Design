package com.example.schedule.controller;

import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.PathMatcher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService, PathMatcher mvcPathMatcher) {
        this.scheduleService = scheduleService;
    }

    // 일정 생성
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto) {

        // Service
        return new ResponseEntity<ScheduleResponseDto>(scheduleService.saveSchedule(requestDto), HttpStatus.CREATED);
    }
    // 작성자명과 수정일로 전체 조회
    @GetMapping
    public List<ScheduleResponseDto> findAllSchedule(String name, String updateDate) {

        return scheduleService.findAllSchedule(name, updateDate);
    }
    // 식별자로 일정 선택 조회
    @GetMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long scheduleId) {

        return new ResponseEntity<ScheduleResponseDto>(scheduleService.findScheduleById(scheduleId), HttpStatus.OK);
    }
    // 선택한 일정 할일 및 작성자 수정 (기능 구현 실패)
    @PutMapping("/{scheduleID}")
    public ResponseEntity<ScheduleResponseDto> updateNameAndContent(
            @PathVariable Long scheduleId,
            @RequestBody ScheduleRequestDto requestDto
    ) {
        return new ResponseEntity<>(scheduleService.updateNameAndContent(scheduleId, requestDto.getName(), requestDto.getPassword(), requestDto.getContent(),
                requestDto.getCreateDate(), requestDto.getUpdateDate()), HttpStatus.OK);


    }
    // 식별자로 일정 삭제 (비밀번호 요청 기능 실패)
    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long scheduleId) {

        scheduleService.deleteSchedule(scheduleId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
