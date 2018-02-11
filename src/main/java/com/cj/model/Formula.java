package com.cj.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Formula implements Comparable<Formula> {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Formula formula = (Formula) o;

        if (name != null ? !name.equals(formula.name) : formula.name != null) return false;
        return parentId != null ? parentId.equals(formula.parentId) : formula.parentId == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(parameters);
        result = 31 * result + (childFormulas != null ? childFormulas.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (abbreviation != null ? abbreviation.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (hasChildren ? 1 : 0);
        return result;
    }

    @Override
    public int compareTo(Formula that) {
        return this.name.compareTo(that.name);
    }
}
