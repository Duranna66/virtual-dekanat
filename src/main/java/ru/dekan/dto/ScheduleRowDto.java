package ru.dekan.dto;

import lombok.Data;

@Data
public class ScheduleRowDto {
    private String day;
    private Long id;
    private String subject;
    private String time;
    private String group;
}
