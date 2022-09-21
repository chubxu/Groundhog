package org.chubxu.groundhog.console.dao;

import org.chubxu.groundhog.dal.entity.TaskTemplate;
import org.chubxu.groundhog.dal.mapper.TaskTemplateMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class TaskTemplateDao {
    @Resource
    private TaskTemplateMapper taskTemplateMapper;

    public List<TaskTemplate> selectList() {
        return taskTemplateMapper.selectList(null);
    }
}
