package com.rupeng;

public class Staff extends OrgItem{
    //级别
    private String level;
    //岗位名称
    private String jobName;

    public Staff(String name) {
        this.setName(name);
    }

    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public String getJobName() {
        return jobName;
    }
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

}
