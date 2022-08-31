package com.application.upwork.feignauditionproject.resource;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApplicantResource {

    private String email;
    private String fullName;
    private String phoneNumber;
    private String resume;

}
