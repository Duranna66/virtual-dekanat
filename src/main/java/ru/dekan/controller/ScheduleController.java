package ru.dekan.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dekan.dto.ScheduleRowDto;
import ru.dekan.service.ScheduleService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schedule")
@CrossOrigin("*")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/{group}")
    public ResponseEntity<List<ScheduleRowDto>> getScheduleByGroup(@PathVariable String group) {
        return ResponseEntity.ok(scheduleService.getSchedule(group));
    }

    @PostMapping
    public ResponseEntity<?> saveSchedule(@RequestBody List<ScheduleRowDto> rows) {
        scheduleService.saveSchedule(rows);
        return ResponseEntity.ok().build();
    }
}
