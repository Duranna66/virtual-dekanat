package ru.dekan.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dekan.dto.StudentDto;
import ru.dekan.entity.Student;
import ru.dekan.mapper.StudentMapper;
import ru.dekan.repository.StudentRepository;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl  {

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;

    public StudentDto getStudentById(Long id) {
        return studentRepository.findById(id)
                .map(studentMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Студент не найден"));
    }

    public StudentDto getStudentByUserId(Long userId) {
        return studentMapper.toDto(studentRepository.findByUserId(userId));
    }

    public StudentDto updateStudent(Long id, StudentDto dto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Студент не найден"));
        student.setFullName(dto.getFullName());
        student.setGroupName(dto.getGroup());
        student.setBirthDate(dto.getBirthDate());
        return studentMapper.toDto(studentRepository.save(student));

    }
}
