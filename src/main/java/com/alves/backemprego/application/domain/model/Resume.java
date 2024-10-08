package com.alves.backemprego.application.domain.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Resume implements Serializable {
    private Long id;
    private User user;
    private Set<ProfessionalExperience> professionalExperiences = new HashSet<>();
    private Set<Education> educations = new HashSet<>();

    public Resume() {
    }

    public Resume(Long id, User user, Set<ProfessionalExperience> professionalExperiences, Set<Education> educations) {
        this.id = id;
        this.user = user;
        this.professionalExperiences = professionalExperiences;
        this.educations = educations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<ProfessionalExperience> getProfessionalExperiences() {
        return professionalExperiences;
    }

    public void setProfessionalExperiences(Set<ProfessionalExperience> professionalExperiences) {
        this.professionalExperiences = professionalExperiences;
    }

    public Set<Education> getEducations() {
        return educations;
    }

    public void setEducations(Set<Education> educations) {
        this.educations = educations;
    }
}
