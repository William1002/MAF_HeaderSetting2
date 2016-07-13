package com.maf.header.setting.bean;

import java.util.List;

/**
 * Created by CLH on 2016/7/12.
 */
public class SubjectCategoryDataSum {
    private String limit;
    private int total;
    private List<SubjectCategory> items;

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<SubjectCategory> getItems() {
        return items;
    }

    public void setItems(List<SubjectCategory> items) {
        this.items = items;
    }
}
