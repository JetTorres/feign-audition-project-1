package com.application.upwork.feignauditionproject.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuickApplyResource {

    private ApplicantResource applicant;

    @JsonProperty("get_person_token")
    private Integer getPersonToken;

    private Boolean enqueue;

    private JobResource job;

    @JsonProperty("partner_attributes")
    private PartnerAtrributeResource partnerAtrributeResource;

}
