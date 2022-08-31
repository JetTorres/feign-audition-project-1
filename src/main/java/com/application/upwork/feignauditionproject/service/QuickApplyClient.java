package com.application.upwork.feignauditionproject.service;

import com.application.upwork.feignauditionproject.resource.QuickApplyResource;
import feign.Headers;
import feign.RequestLine;
import feign.Response;

@Headers("x-api-key: someApiKey")
public interface QuickApplyClient {

    @RequestLine("POST /easy-apply")
    @Headers("Content-Type: application/json")
    Response easyApply(QuickApplyResource quickApplyResource);
}
