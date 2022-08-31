package com.application.upwork.feignauditionproject;

import com.application.upwork.feignauditionproject.client.QuickApplyClientBuilder;
import com.application.upwork.feignauditionproject.resource.ApplicantResource;
import com.application.upwork.feignauditionproject.resource.JobResource;
import com.application.upwork.feignauditionproject.resource.PartnerAtrributeResource;
import com.application.upwork.feignauditionproject.resource.QuickApplyResource;
import com.application.upwork.feignauditionproject.service.QuickApplyClient;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class FeignAuditionProjectApplicationTests {


    private QuickApplyClient quickApplyClient;

    @BeforeEach
    void setup() {
        QuickApplyClientBuilder quickApplyClientBuilder = new QuickApplyClientBuilder();
        quickApplyClient = quickApplyClientBuilder.getQuickApplyClient();
    }

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        Response response = quickApplyClient.easyApply(buildRequest());

        assertNotNull(response);
        assertEquals(403, response.status());
        assertTrue(response.body().toString().contains("Missing Authentication Token"));
        log.info(String.valueOf(response.body()));
        log.info(String.valueOf(response.request()));
        log.info(String.valueOf(response.status()));
    }

    private QuickApplyResource buildRequest() {
        return QuickApplyResource.builder()
                .applicant(ApplicantResource.builder()
                        .email("someEmail@mail.com")
                        .fullName("John Doe")
                        .phoneNumber("123-321")
                        .build())
                .getPersonToken(123)
                .enqueue(true)
                .job(JobResource.builder()
                        .jobId("jobCode01")
                        .build())
                .partnerAtrributeResource(PartnerAtrributeResource.builder()
                        .isSponsored(true)
                        .redirectApply("https://jobs-univision.apploi.com/view/468036?utm_campaign=integration&utm_medium=job-board-search&utm_source=<utm_source>-boosted&ajs_event=LOAD_JOB_PAGE&ajs_aid=3f617530-4530-11e9-a2ca-7e775511d9e3&ajs_prop_search_fetch_id=efb330ceef1b44e3b07328adae1b1ccd&ajs_prop_keyword=&ajs_prop_page=1&ajs_prop_city_center=Unselected&ajs_prop_search_order=5&ajs_prop_job_id=468036&ajs_prop_doc_type=preferredjob&ajs_prop_job_location_lat=39.3798123&ajs_prop_job_location_lon=-74.5302804&ajs_prop_boosted=1&ajs_prop_utm_source=<utm_source>-boosted&ajs_prop_utm_medium=job-board-search&ajs_prop_utm_campaign=integration")
                        .utmMedium("job-board-search")
                        .utmCampaign("integration")
                        .searchFetchId("efb330ceef1b44e3b07328adae1b1ccd")
                        .page(1)
                        .order(5)
                        .cityCenter("Unselected")
                        .utmSource("<exploratory>-quick-apply-boosted")
                        .source("<source>-apply")
                        .build())
                .build();
    }


}
