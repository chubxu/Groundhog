package org.chubxu.groundhog.console.service.impl;

import org.chubxu.groundhog.console.dao.TaskTemplateDao;
import org.chubxu.groundhog.console.service.TaskTemplateService;
import org.chubxu.groundhog.dal.entity.TaskTemplate;
import org.chubxu.groundhog.dal.mapper.TaskTemplateMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TaskTemplateServiceImpl implements TaskTemplateService {

    @Resource
    private TaskTemplateDao taskTemplateDao;

    @Override
    public List<TaskTemplate> selectList() {
        return taskTemplateDao.selectList();
    }
}
