package org.chubxu.groundhog.dal.mapper;

import org.chubxu.groundhog.console.GroundhogConsoleApplication;
import org.chubxu.groundhog.dal.entity.TaskTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = GroundhogConsoleApplication.class)
public class TaskTemplateMapperTest {

    @Autowired
    private TaskTemplateMapper taskTemplateMapper;

    @Test
    public void testSelect() {
        List<TaskTemplate> taskTemplateList = taskTemplateMapper.selectList(null);
        taskTemplateList.forEach(System.out::println);
    }
}
