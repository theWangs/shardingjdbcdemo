package com.wang.shardingjdbcdemo.entity;

/**
 * @Author: meng
 * @Date: 2020-10-16 15:59
 */
public class House {
    /**
     * house_id
     */
    private Integer houseId;

    /**
     * house_name
     */
    private String houseName;

    /**
     * house_address
     */
    private String houseAddress;

    /**
     * update_time
     */
    private String updateTime;

    /**
     * create_time
     */
    private String createTime;

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
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

    @Override
    public String toString() {
        return "House{" +
                "houseId=" + houseId +
                ", houseName='" + houseName + '\'' +
                ", houseAddress='" + houseAddress + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
