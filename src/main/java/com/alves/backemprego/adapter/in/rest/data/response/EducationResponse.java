package com.alves.backemprego.adapter.in.rest.data.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EducationResponse {
    private Long id;
    private StatusResponse status;
    private AcademicDegreeResponse academicDegree;
    private String course;
    private String description;
    private String institution;
}
