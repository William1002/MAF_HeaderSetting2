package com.maf.header.setting.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by CLH on 2016/7/12.
 */
@DatabaseTable
public class SubjectCategory {
    @DatabaseField(generatedId = true)
    @JsonProperty("identifier")
    private String id;
    @DatabaseField
    private String title;
    @DatabaseField
    @JsonProperty("short_name")
    private String shortName;
    @DatabaseField
    @JsonProperty("nd_code")
    private String ndCode;
    @DatabaseField
    private String parent;
    @DatabaseField
    private String description;
    @DatabaseField
    @JsonProperty("order_num")
    private int orderNum;
    @DatabaseField
    @JsonProperty("gb_code")
    private String gbCode;
    @DatabaseField
    private String category;
    @DatabaseField
    @JsonProperty("dimension_path")
    private String dimensionPath;

    public SubjectCategory() {
        //need by ormlite.
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getNdCode() {
        return ndCode;
    }

    public void setNdCode(String ndCode) {
        this.ndCode = ndCode;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getGbCode() {
        return gbCode;
    }

    public void setGbCode(String gbCode) {
        this.gbCode = gbCode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDimensionPath() {
        return dimensionPath;
    }

    public void setDimensionPath(String dimensionPath) {
        this.dimensionPath = dimensionPath;
    }
}
