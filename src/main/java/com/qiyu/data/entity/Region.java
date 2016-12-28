package com.qiyu.data.entity;



import com.qiyu.common.data.SkuIdEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 地区表
 */
@Entity
@Table(name = "region")
public class Region extends SkuIdEntity implements java.io.Serializable{
    private String id;

    private String name;

    private String parentId;

    private Integer level;

    private Integer position;//排序

    private String lng;

    private String lat;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

}