package org.chubxu.groundhog.console.controller;

import org.chubxu.groundhog.console.service.TaskTemplateService;
import org.chubxu.groundhog.dal.entity.TaskTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/task-template")
public class TaskTemplateController {
    @Resource
    private TaskTemplateService taskTemplateService;

    @GetMapping("/list")
    public List<TaskTemplate> selectList() {
        return taskTemplateService.selectList();
    }
}