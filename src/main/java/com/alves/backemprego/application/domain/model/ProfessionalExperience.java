package com.alves.backemprego.application.domain.model;

import java.io.Serializable;
import java.util.Date;

public class ProfessionalExperience implements Serializable {
    private Long id;
    private Resume resume;
    private String position;
    private String company;
    private String description;
    private Date startDate;
    private Date endDate;
    private boolean isCurrent;

    public ProfessionalExperience() {
    }

    public ProfessionalExperience(Long id, Resume resume, String position, String company, String description, Date startDate, Date endDate, boolean isCurrent) {
        this.id = id;
        this.resume = resume;
        this.position = position;
        this.company = company;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isCurrent =isCurrent;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public void setCurrent(boolean current) {
        isCurrent = current;
    }
}