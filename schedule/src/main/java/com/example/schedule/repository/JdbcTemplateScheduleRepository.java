package com.example.schedule.repository;

import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class JdbcTemplateScheduleRepository implements ScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // INSERT를 사용하지 않고 일정생성
    @Override
    public ScheduleResponseDto saveSchedule(Schedule schedule) {
        /// INSERT Query를 직접 작성하지 않아도 된다.
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("schedule").usingGeneratedKeyColumns("scheduleId");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", schedule.getName());
        parameters.put("password", schedule.getPassword());
        parameters.put("content", schedule.getContent());
        parameters.put("createDate", schedule.getCreateDate());
        parameters.put("updateDate", schedule.getUpdateDate());

        // 저장 후 생성은 key값을 Number 타입으로 반환하는 메서드
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));

        return new ScheduleResponseDto(key.longValue(), schedule.getName(), schedule.getPassword(), schedule.getContent(),
                schedule.getCreateDate(), schedule.getUpdateDate());
    }
    // 전체 일정 조회 (이름, 수정일자로 검색)
    @Override
    public List<ScheduleResponseDto> findAllSchedule(String name, String updateDate) {
       return jdbcTemplate.query("select * from schedule where name = ? or updateDate = ? order by updateDate desc ",
                                    scheduleRowMapper(), name, updateDate);
    }
    // DB에 값 조회 (식별자로 선택 일정 조회)
    @Override
    public Optional<Schedule> findScheduleById(Long scheduleId) {
        List<Schedule> result = jdbcTemplate.query("select * from schedule where scheduleId = ?",
                scheduleRowMapperV2(), scheduleId);

        return result.stream().findAny();
    }
    // 일정 수정 (기능 구현 실패)
    @Override
    public int updateNameAndContent(Long scheduleId, String name, String content) {
        // 쿼리 영향을 받은 row 수를 int로 반환한다.
        return jdbcTemplate.update("update schedule set name = ?, content = ? where scheduleId = ? ", name, content, scheduleId);
    }
    // 일정 삭제
    @Override
    public int deleteSchedule(Long scheduleId) {
        return jdbcTemplate.update("delete from schedule where scheduleId = ?", scheduleId);
    }

    private RowMapper<ScheduleResponseDto> scheduleRowMapper() {
        return new RowMapper<ScheduleResponseDto>() {
            @Override
            public ScheduleResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new ScheduleResponseDto(
                        rs.getLong("scheduleId"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getString("content"),
                        rs.getString("createDate"),
                        rs.getString("updateDate")
                );
            }
        };
    }

    private RowMapper<Schedule> scheduleRowMapperV2() {
        return new RowMapper<Schedule>() {
            @Override
            public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Schedule(
                        rs.getLong("scheduleId"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getString("content"),
                        rs.getString("createDate"),
                        rs.getString("updateDate")
                );
            }

        };
    }
}

