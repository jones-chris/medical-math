package com.cj.model;


import java.util.List;

public class Formula {
    private Long id;
    private String name;
    private String[] parameters;
    private Category category;
    private String abbreviation;

    public Formula() {}

    public Formula(String name, String[] parameters, Category category) {
        this.name = name;
        this.parameters = parameters;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getParameters() {
        return parameters;
    }

    public void setParameters(String[] parameters) {
        this.parameters = parameters;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
