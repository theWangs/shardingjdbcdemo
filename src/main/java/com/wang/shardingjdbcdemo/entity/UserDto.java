package com.wang.shardingjdbcdemo.entity;

/**
 * @Author: meng
 * @Date: 2020-10-16 16:04
 */
public class UserDto {

    private Integer userId;
    private String userName;
    private boolean userAge;
    private String updateTime;
    private String createTime;
    private String houseName;
    private String houseId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isUserAge() {
        return userAge;
    }

    public void setUserAge(boolean userAge) {
        this.userAge = userAge;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", updateTime='" + updateTime + '\'' +
                ", createTime='" + createTime + '\'' +
                ", houseName='" + houseName + '\'' +
                ", houseId='" + houseId + '\'' +
                '}';
    }
}
