package ru.dekan.mapper;

import org.springframework.stereotype.Component;
import ru.dekan.dto.StudentDto;
import ru.dekan.entity.Student;

@Component
public class StudentMapper {
    public StudentDto toDto(Student student) {
        StudentDto dto = new StudentDto();
        dto.setId(student.getId());
        dto.setFullName(student.getFullName());
        dto.setGroup(student.getGroupName());
        dto.setBirthDate(student.getBirthDate());
        return dto;
    }

    public Student toEntity(StudentDto dto) {
        Student student = new Student();
        student.setId(dto.getId());
        student.setFullName(dto.getFullName());
        student.setGroupName(dto.getGroup());
        student.setBirthDate(dto.getBirthDate());
        return student;
    }
}