package org.chubxu.groundhog.dal.entity;

import java.io.Serializable;
import java.util.Date;

public class TaskTemplate implements Serializable {
    private Integer id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public int getTaskType() {
        return taskType;
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public String getTaskConfig() {
        return taskConfig;
    }

    public void setTaskConfig(String taskConfig) {
        this.taskConfig = taskConfig;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(String updatedUser) {
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
