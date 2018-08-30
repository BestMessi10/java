package com.imooc.springbootimoocstarter.pojo;

import java.util.Date;

public class TestPojo1 {
    private String areaId;
    private String areaTime;
    private Integer  priority;
    private Date createTime;
    private Date lastEditTime;

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaTime() {
        return areaTime;
    }

    public void setAreaTime(String areaTime) {
        this.areaTime = areaTime;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}
