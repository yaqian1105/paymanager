package com.qiyu.data.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kk on 2016/6/1.
 */
public class MyPage<T> implements Serializable {
    private int totalNum;
    private List<T> list;

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}
