package com.example.activitiinterviewprocess.service;

import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InterviewServiceImpl implements InterviewService {

    @Autowired
    private RuntimeService runtimeService;

    @Override
    public void startInterviewProcess(String interviewer) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("interviewer", interviewer);
        runtimeService.startProcessInstanceByKey("interviewProcess", variables);
    }
}
