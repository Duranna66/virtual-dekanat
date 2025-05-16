package ru.dekan.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.dekan.entity.ScheduleEntry;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<ScheduleEntry, Long> {
    List<ScheduleEntry> findAllByGroupName(String groupName);
}
