package com.alves.backemprego.adapter.in.rest.data.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProfessionalExperienceRequest{
        private Long id;
        private String position;
        private String company;
        private String description;
        private Date startDate;
        private Date endDate;
        @JsonProperty("isCurrent")
        private boolean isCurrent;
}