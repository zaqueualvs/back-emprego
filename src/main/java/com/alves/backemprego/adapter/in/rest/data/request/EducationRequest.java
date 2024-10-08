package com.alves.backemprego.adapter.in.rest.data.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EducationRequest {
    private Long id;
    private StatusRequest status;
    private AcademicDegreeRequest academicDegree;
    private String course;
    private String description;
    private String institution;
}
