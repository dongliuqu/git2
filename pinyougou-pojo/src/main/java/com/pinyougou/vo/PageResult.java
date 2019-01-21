package com.pinyougou.vo;

import java.io.Serializable;
import java.util.List;

public class PageResult implements Serializable {
    private Long total;
    private List<?> dateList;


    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getDateList() {
        return dateList;
    }

    public void setDateList(List<?> dateList) {
        this.dateList = dateList;
    }

    public PageResult() {

    }

    public PageResult(Long total, List<?> dateList) {

        this.total = total;
        this.dateList = dateList;
    }
}
