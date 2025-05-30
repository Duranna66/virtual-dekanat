package ru.dekan.mapper;

import org.springframework.stereotype.Component;
import ru.dekan.dto.ScheduleRowDto;
import ru.dekan.entity.ScheduleEntry;

@Component
public class ScheduleMapper {

    public ScheduleRowDto toDto(ScheduleEntry entity) {
        ScheduleRowDto dto = new ScheduleRowDto();
        dto.setId(entity.getId());
        dto.setDay(entity.getDay());
        dto.setSubject(entity.getSubject());
        dto.setTime(entity.getTime());
        return dto;
    }

    public ScheduleEntry toEntity(ScheduleRowDto dto) {
        ScheduleEntry entry = new ScheduleEntry();
        entry.setId(dto.getId());
        entry.setGroupName(dto.getGroup());
        entry.setDay(dto.getDay());
        entry.setSubject(dto.getSubject());
        entry.setTime(dto.getTime());
        return entry;
    }
}
