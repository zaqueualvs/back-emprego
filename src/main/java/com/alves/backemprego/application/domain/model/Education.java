package com.alves.backemprego.application.domain.model;

import com.alves.backemprego.application.domain.model.enums.AcademicDegree;
import com.alves.backemprego.application.domain.model.enums.Status;

import java.io.Serializable;

public class Education implements Serializable {
    private Long id;
    private Resume resume;
    private Status status;
    private AcademicDegree academicDegree;
    private String course;
    private String description;
    private String institution;

    public Education() {
    }

    public Education(Long id, Resume resume, Status status, AcademicDegree academicDegree, String course, String description, String institution) {
        this.id = id;
        this.resume = resume;
        this.status = status;
        this.academicDegree = academicDegree;
        this.course = course;
        this.description = description;
        this.institution = institution;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public AcademicDegree getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(AcademicDegree academicDegree) {
        this.academicDegree = academicDegree;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }
}
