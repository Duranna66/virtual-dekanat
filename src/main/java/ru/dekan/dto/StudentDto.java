package ru.dekan.dto;


import lombok.Data;

@Data
public class StudentDto {
    private Long id;
    private String fullName;
    private String group;
    private String birthDate;
}
