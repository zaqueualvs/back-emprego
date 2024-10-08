package com.alves.backemprego.adapter.out.persistence.entity;

import com.alves.backemprego.application.domain.model.enums.AcademicDegree;
import com.alves.backemprego.application.domain.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "education")
@Entity
public class EducationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private ResumeEntity resume;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private AcademicDegree academicDegree;
    private String course;
    private String description;
    private String institution;
}
