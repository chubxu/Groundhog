package org.chubxu.groundhog.console.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.chubxu.groundhog.console.entity.R;
import org.chubxu.groundhog.console.service.TaskTemplateService;
import org.chubxu.groundhog.dal.entity.TaskTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Tag(name = "TaskTemplateController", description = "任务模板管理")
@RestController
@RequestMapping("/api/task-template")
public class TaskTemplateController {
    @Resource
    private TaskTemplateService taskTemplateService;

    @GetMapping("/list")
    public R<List<TaskTemplate>> selectList() {
        List<TaskTemplate> taskTemplates = taskTemplateService.selectList();
        return R.success(taskTemplates);
    }
}
