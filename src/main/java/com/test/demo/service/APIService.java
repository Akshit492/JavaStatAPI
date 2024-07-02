package com.test.demo.service;

import com.test.demo.dto.APICall;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class APIService {
    private final List<APICall> apiCalls = new ArrayList<>();

    public void recordApiCall() {
        apiCalls.add(new APICall());
    }

    public long getTotalApiCalls() {
        return apiCalls.size();
    }

    public long getApiCallsInLastMinute() {
        return getApiCallsSince(60);
    }

    public long getApiCallsInLastHour() {
        return getApiCallsSince(3600);
    }

    public long getApiCallsInLastDay() {
        return getApiCallsSince(86400);
    }

    public double getAverageApiCallsPerMinuteInLastHour() {
        long callsInLastHour = getApiCallsInLastHour();
        return callsInLastHour / 60.0;
    }

    private long getApiCallsSince(long amount) {
        LocalDateTime cutoff = LocalDateTime.now().minusSeconds(amount);
        int cnt = 0;
        for(APICall apiCall : apiCalls) {
            if(apiCall.getTimestamp().isAfter(cutoff)) {
                cnt++;
            }
        }
        return cnt;
    }
}
