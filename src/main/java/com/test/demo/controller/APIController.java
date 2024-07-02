package com.test.demo.controller;


import com.test.demo.service.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class APIController {

    @Autowired
    APIService apiService;

    @PostMapping("/api/request")
    public String request() {
        apiService.recordApiCall();
        return "api request recorded "+ apiService.getTotalApiCalls();
    }

    @GetMapping("/api/statistics")
    public  Map<String, Object> statistics() {
        Map<String, Object> statistics = new HashMap<>();
        statistics.put("totalApiCalls", apiService.getTotalApiCalls());
        statistics.put("apiCallsInLastMinute", apiService.getApiCallsInLastMinute());
        statistics.put("apiCallsInLastHour", apiService.getApiCallsInLastHour());
        statistics.put("apiCallsInLastDay", apiService.getApiCallsInLastDay());
        statistics.put("averageApiCallsPerMinuteInLastHour", apiService.getAverageApiCallsPerMinuteInLastHour());
        return statistics;
    }

}