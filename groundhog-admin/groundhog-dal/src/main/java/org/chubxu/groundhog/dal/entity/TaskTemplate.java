package org.chubxu.groundhog.dal.entity;

import java.util.Date;

public class TaskTemplate {
    private int id;
    private String taskId;
    private int taskType;
    private String taskName;
    private String taskDesc;
    private String taskConfig;
    private int state;
    private Date createdTime;
    private Date updatedTime;
    private String createdUser;
    private String updatedUser;

    public TaskTemplate() {
    }

    public TaskTemplate(int id, String taskId, int taskType, String taskName, String taskDesc, String taskConfig, int state, Date createdTime, Date updatedTime, String createdUser, String updatedUser) {
        this.id = id;
        this.taskId = taskId;
        this.taskType = taskType;
        this.taskName = taskName;
        this.taskDesc = taskDesc;
        this.taskConfig = taskConfig;
        this.state = state;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.createdUser = createdUser;
        this.updatedUser = updatedUser;
    }

    @Override
    public String toString() {
        return "TaskTemplate{" +
                "id=" + id +
                ", taskId='" + taskId + '\'' +
                ", taskType=" + taskType +
                ", taskName='" + taskName + '\'' +
                ", taskDesc='" + taskDesc + '\'' +
                ", taskConfig='" + taskConfig + '\'' +
                ", state=" + state +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                ", createdUser='" + createdUser + '\'' +
                ", updatedUser='" + updatedUser + '\'' +
                '}';
    }
}
