package com.rzevsky.basic_rest_api_project.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
//@AllArgsConstructor
@Builder
public class Student {
    private String name;
    private String email;

}