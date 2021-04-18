package com.github.searchgithubapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties
public class ResultRepo {

    private String total_count;
    private List<ProjectRepo> items;

    public String getTotal_count() {
        return total_count;
    }

    public void setTotal_count(String total_count) {
        this.total_count = total_count;
    }

    public List<ProjectRepo> getItems() {
        return items;
    }

    public void setItems(List<ProjectRepo> items) {
        this.items = items;
    }

}
