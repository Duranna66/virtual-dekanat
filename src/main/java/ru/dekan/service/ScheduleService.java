package ru.dekan.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dekan.dto.ScheduleRowDto;
import ru.dekan.entity.ScheduleEntry;
import ru.dekan.mapper.ScheduleMapper;
import ru.dekan.repository.ScheduleRepository;
import ru.dekan.service.ScheduleService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper scheduleMapper;

    public List<ScheduleRowDto> getSchedule(String groupName) {
        return scheduleRepository.findAllByGroupName(groupName)
                .stream()
                .map(scheduleMapper::toDto)
                .collect(Collectors.toList());
    }

    public void saveSchedule(List<ScheduleRowDto> rows) {
        List<ScheduleEntry> entries = rows.stream()
                .map(scheduleMapper::toEntity)
                .collect(Collectors.toList());
        scheduleRepository.saveAll(entries);
    }
}
