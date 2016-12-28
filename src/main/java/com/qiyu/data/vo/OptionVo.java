package com.qiyu.data.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/17.
 */
public class OptionVo implements Serializable {
    private String title;
    private List<Object> xAxis;
    private List<Object> yAxis;
    private List<Object> series;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Object> getSeries() {
        return series;
    }

    public void setSeries(List<Object> series) {
        this.series = series;
    }

    public List<Object> getxAxis() {
        return xAxis;
    }

    public void setxAxis(List<Object> xAxis) {
        this.xAxis = xAxis;
    }

    public List<Object> getyAxis() {
        return yAxis;
    }

    public void setyAxis(List<Object> yAxis) {
        this.yAxis = yAxis;
    }
}
