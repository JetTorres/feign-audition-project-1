package com.application.upwork.feignauditionproject.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PartnerAtrributeResource {

    @JsonProperty("sponsored")
    private Boolean isSponsored;

    @JsonProperty("redirect_apply")
    private String redirectApply;

    @JsonProperty("utm_medium")
    private String utmMedium;

    @JsonProperty("utm_campaign")
    private String utmCampaign;

    private String keyword;

    @JsonProperty("search_fetch_id")
    private String searchFetchId;

    private Integer page;

    private Integer order;

    @JsonProperty("city_center")
    private String cityCenter;

    @JsonProperty("utm_source")
    private String utmSource;

    private String source;
}
