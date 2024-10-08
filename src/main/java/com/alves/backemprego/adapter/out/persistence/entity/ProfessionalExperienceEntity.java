package com.alves.backemprego.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "professional_experience")
@Entity
public class ProfessionalExperienceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private ResumeEntity resume;
    private String position;
    private String company;
    private String description;
    private Date startDate;
    private Date endDate;
    private boolean isCurrent;
}