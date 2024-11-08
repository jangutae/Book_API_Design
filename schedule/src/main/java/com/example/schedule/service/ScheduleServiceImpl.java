package com.example.schedule.service;

import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleREpository, ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;

    }

    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto requestDto) {

        // 요청받은 데이터로 Schedule 객체 생성 Id없음
        Schedule schedule = new Schedule(requestDto.getName(), requestDto.getPassword(), requestDto.getContent(),
                requestDto.getCreateDate(), requestDto.getUpdateDate());

        return scheduleRepository.saveSchedule(schedule);
    }

    // 작성자명과 수정일로 조회 기능 구현 실패
    @Override
    public List<ScheduleResponseDto> findAllSchedule(String name, String updateDate) {

        // 전체 조회
        List<ScheduleResponseDto> allSchedules = scheduleRepository.findAllSchedule(name, updateDate);

        return allSchedules;

    }

    @Override
    public ScheduleResponseDto findScheduleById(Long scheduleId) {

        // 단건 조회
        Optional<Schedule> optionalSchedule = scheduleRepository.findScheduleById(scheduleId);

        if (optionalSchedule.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Schedule not found =" + scheduleId);
        }

        return new ScheduleResponseDto(optionalSchedule.get());
    }

    @Override
    public void deleteSchedule(Long scheduleId) {
        // schedule 삭제
        int deletedRow = scheduleRepository.deleteSchedule(scheduleId);
        // 삭제한 row가 0개 라면
        if (deletedRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist scheduleId = " + scheduleId);
        }

    }
    // 수정 기능 구현 실패 (BAD_REQUEST만 반복적으로 나옵니다.)
    @Transactional
    @Override
    public ScheduleResponseDto updateNameAndContent(Long scheduleId, String name, String password,
                                                    String content, String createDate, String updateDate) {

        if (content == null || name == null || createDate != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Content and name cannot be null");
        }

        int updatedRow = scheduleRepository.updateNameAndContent(scheduleId, name, content);

        if (updatedRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Schedule not found =" + scheduleId);
        }


        return new ScheduleResponseDto(scheduleRepository.findScheduleById(scheduleId).get());
    }
}




