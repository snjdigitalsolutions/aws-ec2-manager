package com.snjdigitalsolutions.awsec2manager.controller;

import com.snjdigitalsolutions.awsec2manager.response.SuccessResponse;
import com.snjdigitalsolutions.awsec2manager.scheduledtask.TaskGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController {

    private final TaskGenerator taskGenerator;

    public ScheduleController(TaskGenerator taskGenerator)
    {
        this.taskGenerator = taskGenerator;
    }

    @GetMapping("/resetschedule")
    public @ResponseBody SuccessResponse resetScheduleFromConfig()
    {
        taskGenerator.generateTasks();
        return new SuccessResponse(true);
    }

}
