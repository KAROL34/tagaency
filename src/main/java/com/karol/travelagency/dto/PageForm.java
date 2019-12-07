package com.karol.travelagency.dto;


import org.springframework.data.domain.Sort;


public class PageForm {
    public PageForm() {
        this.page = page;
        this.size = size;
        this.sortOrder = sortOrder;
        this.sortField = sortField;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Sort.Direction getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Sort.Direction sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    private Integer page;
    private Integer size;
    private Sort.Direction sortOrder;
    private String sortField;
}
