package com.qiyu.data.entity;


import com.qiyu.common.data.IdLongEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
*/
@Entity
@Table(name = "sys_config")
public class SysConfig extends IdLongEntity {

    public static final String TYPE_APP_PRICAE="app每月使用价格设置";


    private String type;
    private long updaterId;
    private String updater;

    private String content;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(long updaterId) {
        this.updaterId = updaterId;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
