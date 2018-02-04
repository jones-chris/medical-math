package com.cj.model;


import java.util.ArrayList;
import java.util.List;

public class Formula {
    private Long id;
    private String name;
    private String[] parameters;
    private List<Formula> childFormulas;
    private Category category;
    private String abbreviation;
    private Long parentId;
    private boolean hasChildren;

    public Formula() {
        this.childFormulas = new ArrayList<>();
    }

    public Formula(String name, String[] parameters, Category category, Long parentId, boolean hasChildren) {
        this.name = name;
        this.parameters = parameters;
        this.category = category;
        this.parentId = parentId;
        this.hasChildren = hasChildren;
        this.childFormulas = new ArrayList<>();
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

    public Long getParentId() {
        return parentId;
    }

    public List<Formula> getChildFormulas() {
        return childFormulas;
    }

    public void setChildFormulas(List<Formula> childFormulas) {
        this.childFormulas = childFormulas;
    }

    public void addChildFormula(Formula formula) {
        // TODO: 2/3/2018  add() method returns a boolean, so use that in order to handle any exceptions.
        childFormulas.add(formula);
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public boolean getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }
}
