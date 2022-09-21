package org.chubxu.groundhog.console.service;

import org.chubxu.groundhog.dal.entity.TaskTemplate;

import java.util.List;

public interface TaskTemplateService {
    List<TaskTemplate> selectList();
}
